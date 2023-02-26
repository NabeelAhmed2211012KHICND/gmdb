package com.galvanize.gmdb.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galvanize.gmdb.gmdb.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer>{
    
}
