package com.example.studyswaggerjwt.repository;

import com.example.studyswaggerjwt.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
