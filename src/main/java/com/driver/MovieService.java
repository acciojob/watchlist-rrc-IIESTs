package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository rep;

    public void addMovie(Movie m){
        rep.addMovie(m);
    }

    public void addDirector(Director d){
        rep.addDirector(d);
    }

    public Movie getMovieByName(String name){
        return rep.getMovieByName(name);
    }

    public Director getDirectorByName(String name){
        return rep.getDirectorByName(name);
    }

    public List getAllMovies(){
        return rep.findAllMovies();
    }

    public void addMovieDirPair(String mName, String dName){
        rep.addMovieDirPair(mName,dName);
    }

    public List movieByDirector(String dName){
        return rep.getMoviesByDirectorName(dName);
    }


    public void deleteDirectorByName(String name){
        rep.deleteDirectorByName(name);
    }

    public void deleteAllDirectors(){
        rep.deleteAllDirectors();
    }


}
