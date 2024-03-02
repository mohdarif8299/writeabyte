package com.writeabyte.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.writeabyte.entities.Comment;
import com.writeabyte.services.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping("/blog-post/{blogPostId}")
	public ResponseEntity<List<Comment>> getCommentsByBlogPostId(@PathVariable Long blogPostId) {
		List<Comment> comments = commentService.getCommentsByBlogPostId(blogPostId);
		return ResponseEntity.ok(comments);
	}

	@PostMapping("/create")
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
		Comment createdComment = commentService.createComment(comment);
		return ResponseEntity.ok(createdComment);
	}

}
