package com.boottest.webservice;

import com.boottest.webservice.domain.Posts;
import com.boottest.webservice.domain.PostsRepository;
import com.boottest.webservice.dto.posts.PostsSaveRequestDto;
import com.boottest.webservice.service.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postsSave(){
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("v123v123s@gmail.com")
                .content("테스트 내용")
                .title("테스트 제목")
                .build();

        postsService.save(dto);

        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());

    }

}

