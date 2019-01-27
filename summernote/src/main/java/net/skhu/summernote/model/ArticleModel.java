package net.skhu.summernote.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ArticleModel {
    int id;

    @NotEmpty(message="제목을 입력하세요")
    String title;

    @Size(min=13, message="내용을 입력하세요")
    String body;
}
