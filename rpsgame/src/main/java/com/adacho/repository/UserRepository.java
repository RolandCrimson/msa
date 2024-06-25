package com.adacho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adacho.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByAlias(final String alias);
}
