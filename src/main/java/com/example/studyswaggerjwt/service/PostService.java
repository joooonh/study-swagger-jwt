package com.example.studyswaggerjwt.service;

import com.example.studyswaggerjwt.domain.Post;
import com.example.studyswaggerjwt.web.dto.PostSaveDto;
import com.example.studyswaggerjwt.repository.PostRepository;
import com.example.studyswaggerjwt.web.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 게시글 등록
    @Transactional
    public Post savePost(PostSaveDto postSaveDto) {
        Post post = new Post(postSaveDto.getTitle(), postSaveDto.getContent(), postSaveDto.getAuthor());
        return postRepository.save(post);
    }

    // 게시글 전체 조회
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    // 게시글 조회
    public Post getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. id={}" + id));
        return post;
    }

    // 게시글 수정
    @Transactional
    public Post updatePost(Long id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. id={}" + id));

        post.update(postUpdateDto);
        return post;
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. id={}" + id));
        postRepository.delete(post);
    }

}
