package com.writeabyte.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private User user;
    @ManyToOne
    private BlogPost blogPost;
    // Getters and setters
}
