package com.driftbapo.controller;

import com.driftbapo.entity.Post;
import com.driftbapo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RepositoryRestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<?> getPosts() {
        List<Post> postList = postService.getPosts();
        return ResponseEntity.ok(postList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable("id") String postId) {
        try {
            LOGGER.info("PostController::: " + postId);
            Post post = postService.getPost(postId);

            return ResponseEntity.ok(post);
        }catch (RuntimeException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", exc);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Post post) {
        LOGGER.info("TasksController: " + post);
        Post savedPost = postService.savePost(post);

        return ResponseEntity.ok(savedPost);
    }

}
