package com.writeabyte.repository;


import com.writeabyte.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository  extends JpaRepository<Like, Long> {
	boolean existsByUserIdAndBlogPostId(Long userId, Long blogPostId);
    Like deleteByUserIdAndBlogPostId(Long userId, Long blogPostId);
}
