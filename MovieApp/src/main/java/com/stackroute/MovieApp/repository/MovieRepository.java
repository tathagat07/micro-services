package com.stackroute.MovieApp.repository;

import com.stackroute.MovieApp.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {
//    @Query("FROM Movie WHERE movieName=?1")
    public List<Movie> findMovieByMovieName(String name);
}
