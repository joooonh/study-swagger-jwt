package com.example.studyswaggerjwt.web;

import com.example.studyswaggerjwt.domain.Member;
import com.example.studyswaggerjwt.service.MemberService;
import com.example.studyswaggerjwt.web.dto.MemberRequestDto;
import com.example.studyswaggerjwt.web.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Member", description = "Member API")   // API 그룹 설정
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@Validated
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원 등록", description = "회원을 등록합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "등록 성공", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @PostMapping
    public ResponseEntity<Member> save(@RequestBody MemberRequestDto requestDto) {
        Member member = memberService.saveMember(requestDto);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @Operation(summary = "전체 회원 조회", description = "전체 회원을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "전체 회원 조회 성공", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @Operation(summary = "회원 조회", description = "아이디에 해당하는 회원을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @GetMapping("/{id}")
    public ResponseDto<Member> getMemberById(@PathVariable Long id) {
        Member foundMember = memberService.getMemberById(id);
        return new ResponseDto<>("200", "회원 조회 성공", foundMember);
    }

    @Operation(summary = "회원 수정", description = "아이디에 해당하는 회원 정보를 수정합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @PutMapping("/{id}")
    public ResponseDto<Member> updateMember(@PathVariable Long id, @RequestBody MemberRequestDto requestDto) {
        Member updatedMember = memberService.updateMember(id, requestDto);
        return new ResponseDto<>("200", "회원 수정 성공", updatedMember);
    }

    @Operation(summary = "회원 삭제", description = "회원 정보를 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseDto<Member> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseDto<>("200", "회원 삭제 성공");
    }

}
