package com.microservices.training.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.google.common.util.concurrent.RateLimiter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



@Component
public class RateLimitingFilter extends ZuulFilter {


    private final RateLimiter productServiceRateLimiter = RateLimiter.create(10.0 / 60.0);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        return request.getRequestURI().contains("/product");
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        // Apply rate limiting for ProductService requests
        if (!productServiceRateLimiter.tryAcquire()) {
            // If rate limit exceeded, return HTTP 429 (Too Many Requests)
            ctx.setSendZuulResponse(false);  // Stop request from forwarding
            ctx.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
            ctx.setResponseBody("Rate limit exceeded for ProductService. Please try again later.");
            return null;
        }

        return null;
    }
}
