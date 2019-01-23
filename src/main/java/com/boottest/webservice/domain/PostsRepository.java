package com.boottest.webservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//DB Layer 접근자(DAO), JpaRepository<Entity, PK타입 > 을 상속하면 기본적인 CRUD 메소드가 자동 생성됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
