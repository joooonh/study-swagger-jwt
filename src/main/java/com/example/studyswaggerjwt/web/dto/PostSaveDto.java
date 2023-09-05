package com.example.studyswaggerjwt.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveDto {

    private String title;
    private String content;
    private String author;

}
