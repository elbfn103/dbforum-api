package com.driftbapo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.List;

@Document(collection = "posts")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private String title;
    private String author;
    private String content;
    private List<String> comments;
}
