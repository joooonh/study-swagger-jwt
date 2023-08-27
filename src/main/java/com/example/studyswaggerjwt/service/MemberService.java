package com.example.studyswaggerjwt.service;

import com.example.studyswaggerjwt.domain.Member;
import com.example.studyswaggerjwt.repository.MemberRepository;
import com.example.studyswaggerjwt.web.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 등록
    @Transactional
    public Member saveMember(MemberRequestDto requestDto) {
        Member member = new Member(requestDto.getName(), requestDto.getEmail());
        return memberRepository.save(member);
    }

    // 전체 조회
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // 조회
    @Transactional
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다. id={}" + id));
    }

    // 수정
    @Transactional
    public Member updateMember(Long id, MemberRequestDto requestDto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다. id={}" + id));
        member.update(requestDto.getName(), requestDto.getEmail());

        return member;
    }

    // 삭제
    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다. id={}" + id));
        memberRepository.delete(member);
    }
}
