package com.crudo.service.impl;

import com.crudo.dto.PostDto;
import com.crudo.entity.Post;
import com.crudo.repository.PostRepository;
import com.crudo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepository.save(post);
        PostDto dto = mapToDto(savedPost);
        return dto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResolutionException("post is update " + id)
        );
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(post.getDescription());
        post.setContent(post.getContent());
        Post save = postRepository.save(post);
        PostDto dto = mapToDto(save);
        return dto;
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }


    PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        postDto.setTitle(post.getTitle());
        return postDto;
}
Post mapToEntity(PostDto postDto){
        Post post = new Post();
    post.setId(postDto.getId());
    post.setContent(postDto.getContent());
    post.setDescription(postDto.getDescription());
    post.setTitle(postDto.getTitle());
    return post;
}
}
