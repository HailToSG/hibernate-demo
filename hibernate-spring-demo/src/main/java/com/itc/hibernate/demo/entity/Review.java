package com.itc.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    public Review() {
    }

    public Review(String comment) {
        Comment = comment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    private String Comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", Comment='" + Comment + '\'' +
                '}';
    }
}
