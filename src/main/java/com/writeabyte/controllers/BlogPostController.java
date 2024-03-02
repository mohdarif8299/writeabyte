package com.writeabyte.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.writeabyte.entities.BlogPost;
import com.writeabyte.entities.Comment;
import com.writeabyte.entities.Like;
import com.writeabyte.exceptions.BlogPostNotFoundException;
import com.writeabyte.services.BlogPostService;
import com.writeabyte.services.CommentService;
import com.writeabyte.services.LikeService;

@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController {
	@Autowired
	private BlogPostService blogPostService;

	@Autowired
	private LikeService likeService;

	@Autowired
	private CommentService commentService;

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<BlogPost>> getBlogPostsByUserId(@PathVariable Long userId) {
		List<BlogPost> blogPosts = blogPostService.getBlogPostsByUserId(userId);
		return ResponseEntity.ok(blogPosts);
	}

	@PostMapping("/create")
	public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) throws Exception {
		BlogPost createdBlogPost = blogPostService.createBlogPost(blogPost);
		return ResponseEntity.ok(createdBlogPost);
	}

	@DeleteMapping("/{blogPostId}")
	public ResponseEntity<?> deleteBlogPost(@PathVariable Long blogPostId) {
		try {
			blogPostService.deleteBlogPost(blogPostId);
			return ResponseEntity.ok("Blog post deleted successfully!");
		} catch (BlogPostNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to delete blog post: " + e.getMessage());
		}
	}

	@GetMapping("/{postId}/likes")
	public ResponseEntity<List<Like>> getLikesByPostId(@PathVariable Long postId) {
		List<Like> likes = likeService.getLikesByBlogPostId(postId);
		return ResponseEntity.ok(likes);
	}

	@GetMapping("/{postId}/comments")
	public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {
		List<Comment> comments = commentService.getCommentsByBlogPostId(postId);
		return ResponseEntity.ok(comments);
	}

}
