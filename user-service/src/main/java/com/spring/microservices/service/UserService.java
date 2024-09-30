package com.spring.microservices.service;

import com.spring.microservices.model.User;
import com.spring.microservices.model.UserOrder;
import com.spring.microservices.model.UserOrderDTO;
import com.spring.microservices.repository.UserOrderRepository;
import com.spring.microservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserOrderRepository userOrderRepository;

    public List<User> retrieveUsers(){
        return userRepository.findAll();
    }

    public User retrieveUser(String id){
        return userRepository.findByUserId(id);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.delete(userRepository.findByUserId(id));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public List<UserOrder> retrieveUserOrders(String id){
        return userOrderRepository.findByUserId(id);
    }

    public List<UserOrder> updateUserOrders(List<UserOrder> userOrders){
        return userOrderRepository.saveAll(userOrders);
    }

    public UserOrderDTO createUserOrder(UserOrder userOrder){
        UserOrderDTO userOrderDTO = new UserOrderDTO();
        User user = userRepository.findByUserId(userOrder.getUserId());
        UserOrder userorders = userOrderRepository.save(userOrder);
        userOrderDTO.setUser(user);
        userOrderDTO.setOrders(Arrays.asList(userorders));
        return userOrderDTO;
    }

    public UserOrderDTO updateUserOrder(UserOrder userOrder){
        UserOrderDTO userOrderDTO = new UserOrderDTO();
        User user = userRepository.findByUserId(userOrder.getUserId());
        UserOrder availableUserOrder = userOrderRepository.findByOrderId(userOrder.getOrderId());
        availableUserOrder.setStatus(userOrder.getStatus());
        UserOrder userorders = userOrderRepository.save(availableUserOrder);
        userOrderDTO.setUser(user);
        userOrderDTO.setOrders(Arrays.asList(userorders));
        return userOrderDTO;
    }

    public UserOrderDTO retrieveUserOrder(String id) {
        UserOrderDTO userOrderDTO = new UserOrderDTO();
        User user = userRepository.findByUserId(id);
        List<UserOrder> userOrders = userOrderRepository.findByUserId(id);
        userOrderDTO.setUser(user);
        userOrderDTO.setOrders(userOrders);
        return userOrderDTO;
    }
}
