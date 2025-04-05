package com.example.plantilla_hack.adapter.out.persistance.user;

import com.example.plantilla_hack.model.User;

public class UserMapper {
    public static UserJPAEntity toEntity(User user) {
        UserJPAEntity userJPAEntity = new UserJPAEntity();
        userJPAEntity.setId(user.getId());
        userJPAEntity.setFullName(user.getFullName());
        userJPAEntity.setEmail(user.getEmail());
        userJPAEntity.setPassword(user.getPassword());
        return userJPAEntity;
    }

    public static User toModel(UserJPAEntity userJPAEntity) {
        User user = new User();
        user.setId(userJPAEntity.getId());
        user.setFullName(userJPAEntity.getFullName());
        user.setEmail(userJPAEntity.getEmail());
        user.setPassword(userJPAEntity.getPassword());
        return user;
    }
}
