package com.boottest.webservice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자 자동 추가 (protected Posts(){} 와 같음)
@Getter //클래스 내 모든 필드의 getter 메소드 자동생성
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity{ // 실제 DB와 매칭될 클래스(Entity 클래스)
    @Id //테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title  = title;
        this.content = content;
        this.author = author;
    }

}
