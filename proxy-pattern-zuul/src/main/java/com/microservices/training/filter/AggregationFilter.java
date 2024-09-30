package com.microservices.training.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AggregationFilter extends ZuulFilter {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String filterType() {
        return "route";  // Aggregate responses before forwarding
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getRequestURI().contains("/aggregate");
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        // Call ProductService
        ResponseEntity<String> productResponse = restTemplate.getForEntity("http://localhost:8090/products", String.class);

        // Call InventoryService
        ResponseEntity<String> inventoryResponse = restTemplate.getForEntity("http://localhost:8092/inventory", String.class);

        // Aggregate the responses
        String aggregatedResponse = productResponse.getBody() + "\n" + inventoryResponse.getBody();
        ctx.setResponseBody(aggregatedResponse);

        return null;
    }
}

