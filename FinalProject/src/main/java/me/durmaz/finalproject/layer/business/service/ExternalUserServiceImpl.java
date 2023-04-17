package me.durmaz.finalproject.layer.business.service;

import me.durmaz.finalproject.layer.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalUserServiceImpl {

    private final RestTemplate restTemplate;

    @Autowired
    public ExternalUserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(Long id) {
        String url = "http://localhost:8081/api/auth/user/" + id;
        return restTemplate.getForObject(url, User.class);
    }
}