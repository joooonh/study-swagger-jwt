package com.example.studyswaggerjwt.repository;

import com.example.studyswaggerjwt.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
