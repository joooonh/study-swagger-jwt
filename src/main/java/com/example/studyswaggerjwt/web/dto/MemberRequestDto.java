package com.example.studyswaggerjwt.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Member Request")
public class MemberRequestDto {

    @NotBlank(message = "이름을 입력하세요.")
    @Schema(description = "사용자 이름", example = "Kim Junhee")
    private String name;

    @NotBlank(message = "이메일을 입력하세요.")
    @Schema(description = "사용자 이메일", example = "123@email.com")
    private String email;
}
