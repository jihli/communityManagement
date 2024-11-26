package com.laioffer.communitymanagement.db;

import com.laioffer.communitymanagement.db.entity.UserEntity;

public interface UserRepository {
    UserEntity findByUsername(String username);
}
