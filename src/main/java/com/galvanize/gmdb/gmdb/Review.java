package com.galvanize.gmdb.gmdb;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.galvanize.gmdb.gmdb.Model.Movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;
    private String review_text;

    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date last_modified;

    @ManyToOne
    @JoinColumn(name="movie_id",referencedColumnName="movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="reviewer_id",referencedColumnName="reviewer_id")
    private Reviewer reviewer;

    public Review(){};

    public Review(String review_text,Date last_modified,Reviewer reviewer,Movie movie){
        this.review_text = review_text;
        this.last_modified = last_modified;
        this.reviewer = reviewer;
        this.movie = movie;
    }

}

