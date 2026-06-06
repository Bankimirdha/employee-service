package com.crudo.service;

import com.crudo.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();


    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}
