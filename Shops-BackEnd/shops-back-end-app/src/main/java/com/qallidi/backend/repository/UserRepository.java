package com.qallidi.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qallidi.backend.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
