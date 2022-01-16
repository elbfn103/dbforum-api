package com.driftbapo.service;

import com.driftbapo.entity.Post;
import com.driftbapo.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(String postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.get();
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
