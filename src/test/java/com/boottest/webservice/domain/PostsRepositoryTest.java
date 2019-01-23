package com.boottest.webservice.domain;


import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;



import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest //기존 스프링test의 @ContextConfiguration 의 발전된 기능 ? 다양한 기능이 있으니 찾아볼 것
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        //테스트 후 repository 지우기
        postsRepository.deleteAll();
    }

    @Test
    public void loadtest(){
        //테스트 환경 구축
        postsRepository.save(Posts.builder()
                .title("테스트게시물")
                .content("테스트 본문")
                .author("admin@gmail.com")
                .build());

        //테스트 행위
        List<Posts> postsList = postsRepository.findAll();

        //테스트 검증
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트게시물"));
        assertThat(posts.getContent(), is("테스트 본문"));

    }

    @Test
    public void BaseTimeEntity_reg(){
        //테스트 환경 구축
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시물")
                .content("테스트본문")
                .author("테스터")
                .build());

        //테스트 행위
        List<Posts> postsList = postsRepository.findAll();

        //테스트 검증
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreateDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
