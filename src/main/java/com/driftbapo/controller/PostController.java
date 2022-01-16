package com.driftbapo.controller;

import com.driftbapo.entity.Post;
import com.driftbapo.links.PostLinks;
import com.driftbapo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dbforum/")
@RequiredArgsConstructor
@CrossOrigin
public class PostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @GetMapping(path = PostLinks.POSTS)
    public ResponseEntity<?> getPosts() {
        List<Post> todoList = postService.getPosts();
        return ResponseEntity.ok(todoList);
    }

    @GetMapping(path = PostLinks.POST)
    public ResponseEntity<?> getPost(@PathVariable("id") String postId) {
        try {
            LOGGER.info("PostsController::: " + postId);
            Post post = postService.getPost(postId);

            return ResponseEntity.ok(post);
        }catch (RuntimeException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", exc);
        }
    }

    @PostMapping(path = PostLinks.CREATE_POST)
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        LOGGER.info("PostsController: " + post);
        Post savedPost = postService.savePost(post);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Headers", "*");

        return ResponseEntity.ok().headers(headers).body(savedPost);
    }

//    @PutMapping(path = PostLinks.UPDATE_POST)
//    public ResponseEntity<?> updatePost(@RequestBody Post post) {
//        LOGGER.info("PostsController: " + postDTO);
//        Post post = postService.updatePost(postDTO);
//
//        return ResponseEntity.ok(post);
//    }
//
//    @DeleteMapping(path = PostLinks.DELETE_POST)
//    public ResponseEntity<?> deletePost(@PathVariable("id") String postId) {
//        LOGGER.info("PostsController: " + postId);
//        String result = postService.deletePost(postId);
//
//        return ResponseEntity.ok(result);
//    }
}
