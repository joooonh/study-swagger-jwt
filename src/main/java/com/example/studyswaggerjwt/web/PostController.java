package com.example.studyswaggerjwt.web;

import com.example.studyswaggerjwt.domain.Post;
import com.example.studyswaggerjwt.service.PostService;
import com.example.studyswaggerjwt.web.dto.PostSaveDto;
import com.example.studyswaggerjwt.web.dto.PostUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Post", description = "Post API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    // 등록
    @Operation(summary = "게시글 등록", description = "게시글을 등록합니다.")
    @PostMapping
    public ResponseEntity<Post> save(@RequestBody PostSaveDto postSaveDto) {
        Post post = postService.savePost(postSaveDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    // 전체 조회
    @Operation(summary = "게시글 전체 조회", description = "게시글 목록을 조회합니다")
    @GetMapping
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    // 조회
    @Operation(summary = "게시글 조회", description = "게시글을 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<Post> findPost(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    // 수정
    @Operation(summary = "게시글 수정", description = "게시글을 수정합니다.")
    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto) {
        Post post = postService.updatePost(id, postUpdateDto);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    // 삭제
    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Post> delete(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }
}
