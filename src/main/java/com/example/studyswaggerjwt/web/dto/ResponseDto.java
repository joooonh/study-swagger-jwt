package com.example.studyswaggerjwt.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<T> {

    @Schema(description = "상태 코드", example = "200")
    private String status;

    @Schema(description = "상태 메시지", example = "성공했습니다.")
    private String message;

    @Schema(description = "데이터")
    private T data;

    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
