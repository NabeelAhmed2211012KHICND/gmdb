package com.galvanize.gmdb.gmdb.Model;

import java.util.List;

import com.galvanize.gmdb.gmdb.Review;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movie_id;

    private String movie_title;
    private Integer year_released;
    private String genre;
    private Long runtime;

    @OneToMany(mappedBy="movie",targetEntity=Review.class)
    private List<Review> reviews;

    }

   

