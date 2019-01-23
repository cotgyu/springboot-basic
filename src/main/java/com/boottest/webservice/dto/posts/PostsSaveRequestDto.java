package com.boottest.webservice.dto.posts;

import com.boottest.webservice.domain.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Entity(Posts)는 가장 Core한 클래스. entity 클래스가 변경되면 여러 클래스에 영향이 감.
//Request와 Response용 Dto는 View를 위한 클래스라 변경이 자주 필요함. Entity와 Dto는 분리해서 사용할 것
@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
