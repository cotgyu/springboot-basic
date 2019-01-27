package com.boottest.webservice.dto.posts;

import com.boottest.webservice.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsMainResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;

    public PostsMainResponseDto(Posts entity){
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        author = entity.getAuthor();
        //view 영역에서는 LocalDataTime 타입을 모르기 떄문에, 인식하기 위해 문자열로 변경하여 등록
        modifiedDate = toStringDateTime(entity.getModified_Date());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");

        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
