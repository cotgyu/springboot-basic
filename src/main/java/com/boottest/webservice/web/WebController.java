package com.boottest.webservice.web;

import com.boottest.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/") //@RequestMapping(value="/" , method = RequestMethod.GET) 과 동일
    public String main(Model model){
        /*
        build.gradle에 추가한 handlebars-spring-boot-starter 덕분에 뷰의 path와 확장자가 자동으로 지정된다.
        src/main/resources/templates/main.hbs 로 전환되어 view Resolver가 처리
        */

        model.addAttribute("posts", postsService.findAllDesc());

        return "main";
    }
}

