package com.mycompany.pacwar.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByIdAndPassword(String id, String password);
}
