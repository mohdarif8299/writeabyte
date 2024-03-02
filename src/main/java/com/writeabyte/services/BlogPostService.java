package com.writeabyte.services;

import com.writeabyte.entities.BlogPost;
import com.writeabyte.entities.Comment;
import com.writeabyte.entities.Like;
import com.writeabyte.entities.User;
import com.writeabyte.exceptions.BlogPostNotFoundException;
import com.writeabyte.repository.BlogPostRepository;
import com.writeabyte.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private LikeService likeService;

    @Autowired
    private CommentService commentService;
    
    public List<BlogPost> getBlogPostsByUserId(Long userId) {
        return blogPostRepository.findByUserId(userId);
    }

    public BlogPost createBlogPost(BlogPost blogPost) throws Exception {
    	 User user = userRepository.findById(blogPost.getUser().getId()).orElse(null);
         if (user == null) {
             throw new Exception("User not found with ID: " + blogPost.getUser().getId());
         }
        return blogPostRepository.save(blogPost);
    }
    
    public void deleteBlogPost(Long blogPostId) {
        if (!blogPostRepository.existsById(blogPostId)) {
            throw new BlogPostNotFoundException("Blog post not found with ID: " + blogPostId);
        }
        blogPostRepository.deleteById(blogPostId);
    }
    
    public List<BlogPost> getAllPostsWithLikesAndComments() {
        List<BlogPost> posts = blogPostRepository.findAll();

        for (BlogPost post : posts) {
            List<Like> likes = likeService.getLikesByBlogPostId(post.getId());
            post.set(likes);

            List<Comment> comments = commentService.getCommentsByBlogPostId(post.getId());
            post.setComments(comments);
        }

        return posts;
    }

    
}