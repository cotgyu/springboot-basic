package com.boottest.webservice.web;

import com.boottest.webservice.domain.PostsRepository;
import com.boottest.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor // 모든 필드를 인자 값으로 하는 생성자를 Lombok이 대신 생성해줌
public class WebRestController {

    /*
    스프링프레임워크에서 Bean을 주입하는 방식에는 autowired , setter , 생성자 방식이 있는데 이 중 가장 권장하는 방식이 생성자 방식
    @AllArgsConstructor 을 통해 다음과 같은 형태라고 볼 수 있음
    public WebRestController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }
    */
    private PostsRepository postsRepository;


    @GetMapping("/Hello")
    public String Hello()
    {
        return "helloWorld";
    }

    @PostMapping("/post")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

}
