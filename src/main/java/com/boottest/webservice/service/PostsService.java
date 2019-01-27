package com.boottest.webservice.service;

import com.boottest.webservice.domain.PostsRepository;
import com.boottest.webservice.dto.posts.PostsMainResponseDto;
import com.boottest.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true) //readOnly 옵션: 트랜잭션 범위는 유지하되, 조회기능만 남겨두어 조회속도 개선되기 위함
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
