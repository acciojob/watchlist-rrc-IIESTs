package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService service;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie m){
        service.addMovie(m);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director d){
        service.addDirector(d);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name")String name){
        return new ResponseEntity<>(service.getMovieByName(name),HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name")String name){
        return new ResponseEntity<>(service.getDirectorByName(name),HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity<>(service.getAllMovies(),HttpStatus.OK);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie")String movie, @RequestParam("director") String director){
        try {
            service.addMovieDirPair(movie,director);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        return new ResponseEntity<>(service.movieByDirector(director),HttpStatus.OK);
    }
    @GetMapping("get-pair")
    public ResponseEntity getAll(){
        return new ResponseEntity<>(service.rep.movieToDirector,HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        service.deleteDirectorByName(name);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        service.deleteAllDirectors();
        return new ResponseEntity("Success",HttpStatus.OK);
    }

}
