package com.writeabyte.services;

import com.writeabyte.entities.Comment;
import com.writeabyte.repository.CommentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    
    
    public List<Comment> getCommentsByBlogPostId(Long blogPostId) {
        return commentRepository.findByBlogPostId(blogPostId);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
}