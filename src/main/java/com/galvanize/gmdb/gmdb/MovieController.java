package com.galvanize.gmdb.gmdb;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private ReviewerRepository reviewerRepo;

    @GetMapping("")
    public List<Movie> listAll(){
        // Movie movie = new Movie("Harry Mater",1923,"Action",23450);
        // movieRepo.save(movie);
        List<Movie> listMovies = movieRepo.findAll();
        return listMovies;
    }

        // 2. As a user
    //    I can provide a movie ID and get back the record shown in story 1, plus a list of reviews that contains Review ID | Movie ID | Reviewer ID | Review Text | DateTime last modified
    //    so that I can read the reviews for a movie.

    @GetMapping("/{movie_id}")
    public Movie getMovieByID(@PathVariable Integer movie_id){
        
        Reviewer reviewer = reviewerRepo.findById(1).orElse(null);
        Movie movie = movieRepo.findById(1).orElse(null);
        Review review = new Review("This is my review",new Date(),reviewer,movie);
        // reviewRepo.save(review);
        return movie;
    }

}
