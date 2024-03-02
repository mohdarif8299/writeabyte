package com.writeabyte.models.response;

import java.util.List;

public class BlogPosts {
	private Long id;

	private Long userId;
	private Long blogPostId;
	private String title;
	private String content;
	private String image;
	private int likes;
	private List<CommentResponse> comments;

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<CommentResponse> getComments() {
		return comments;
	}

	public void setComments(List<CommentResponse> comments) {
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getBlogPostId() {
		return blogPostId;
	}

	public void setBlogPostId(Long blogPostId) {
		this.blogPostId = blogPostId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
