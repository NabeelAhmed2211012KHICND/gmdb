package com.galvanize.gmdb.gmdb;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    private String movie_title;
    private int year_released;
    private String Genre;
    private long runtime;

    @OneToMany(mappedBy="movie",targetEntity=Review.class)
    private List<Review> reviews;

    public Movie(){};

    public Movie(String title,int year,String Genre,long runtime){
        this.movie_title = title;
        this.year_released = year;
        this.Genre =  Genre;
        this.runtime = runtime;
    }

}
