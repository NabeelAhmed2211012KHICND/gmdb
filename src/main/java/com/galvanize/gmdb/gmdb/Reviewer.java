package com.galvanize.gmdb.gmdb;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviewers")
@Getter
@Setter
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewer_id;

    private String username;

    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date_joined;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number_of_reviews;

    @OneToMany(mappedBy="reviewer",targetEntity=Review.class)
    private List<Review> reviews;

    public Reviewer(){};

    public Reviewer(String username,Date date_joined){
        this.username = username;
        this.date_joined = date_joined;
    }

}
