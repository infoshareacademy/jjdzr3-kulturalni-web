package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.entities.user.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByValue(String value);
}
