package com.laioffer.communitymanagement.User;

import com.laioffer.communitymanagement.db.entity.UserEntity;

public interface UserService {
    UserEntity getUserByUsername(String username);
}
