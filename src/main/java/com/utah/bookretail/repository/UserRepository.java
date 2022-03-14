package com.utah.bookretail.repository;

import com.utah.bookretail.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByIdAndDeleted(Long id, Integer deleted);
}
