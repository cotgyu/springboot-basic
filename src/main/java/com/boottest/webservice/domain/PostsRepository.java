package com.boottest.webservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

//DB Layer 접근자(DAO), JpaRepository<Entity, PK타입 > 을 상속하면 기본적인 CRUD 메소드가 자동 생성됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //@Query 를 통해 JPA에서 제공하지 않는 메소드는 쿼리로 작성 가능
    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

}
