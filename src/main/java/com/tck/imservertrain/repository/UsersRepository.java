package com.tck.imservertrain.repository;

import com.tck.imservertrain.pojo.Users;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
