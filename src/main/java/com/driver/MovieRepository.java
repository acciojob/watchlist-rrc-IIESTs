package com.driver;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieRepository {
    HashMap<String,Movie> movieMap = new HashMap<>();
    HashMap<String,Director> directorMap = new HashMap<>();

    HashMap<Movie,Director> movieToDirector = new HashMap<>();

    public void addMovie(Movie m){
        movieMap.put(m.getName(),m);
    }
    public void addDirector(Director d){
        directorMap.put(d.getName(),d);
    }

    public Movie getMovieByName(String mName){
       return movieMap.get(mName);
    }

    public Director getDirectorByName(String dName){
        return directorMap.get(dName);
    }

    public List findAllMovies(){
        List<String> allMovies = new ArrayList<>(movieMap.keySet());
        return allMovies;
    }

    public void addMovieDirPair(String mName, String dName ){
        movieToDirector.put(movieMap.get(mName),directorMap.get(dName));
    }

    public List<String> getMoviesByDirectorName(String dName){
        List<String> moviesByDirector = new ArrayList<>();
        for(Map.Entry<Movie,Director> e : movieToDirector.entrySet() ){
            String dir = e.getValue().getName();
            if(dir.equals(dName)){
                if(e.getKey()!=null) {
                    moviesByDirector.add(e.getKey().getName());
                }
            }
        }
        return moviesByDirector;
    }
    public void deleteDirectorByName(String name){
        directorMap.remove(name);
        List<String> movies = getMoviesByDirectorName(name);
        for(int i=0;i<movies.size();i++){
            String mov = movies.get(i);
            Movie m = movieMap.get(mov);
            movieMap.remove(mov);
            if(movieToDirector.get(m)!=null){
                movieToDirector.remove(m);
            }
        }
    }
    public void deleteAllDirectors(){
        for(Map.Entry<String,Director> dirEntry: directorMap.entrySet()){
            String name = dirEntry.getKey();
            directorMap.remove(name);
            for(Map.Entry<Movie,Director> e:movieToDirector.entrySet()){
                String dir = e.getValue().getName();
                if(dir.equals(name)){
                    if(e.getKey()!=null) {
                        String mName = e.getKey().getName();
                        movieMap.remove(mName);
                        movieToDirector.remove(e.getKey());
                    }
                }
            }
        }
    }

}
