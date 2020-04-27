package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository  extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
