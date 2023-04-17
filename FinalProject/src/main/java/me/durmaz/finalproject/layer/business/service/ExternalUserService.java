package me.durmaz.finalproject.layer.business.service;

import me.durmaz.finalproject.layer.data.entity.User;

public interface ExternalUserService {
    User getUserById(Long id);
}