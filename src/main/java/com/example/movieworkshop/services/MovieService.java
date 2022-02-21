package com.example.movieworkshop.services;

import com.example.movieworkshop.models.Movie;
import com.example.movieworkshop.repositories.MovieDataRepository;

import java.util.ArrayList;
import java.util.Collections;

public class MovieService {

    MovieDataRepository movieDB = new MovieDataRepository();
    private ArrayList<Movie> movies = movieDB.getMovies();


    public String getFirst(){
        return movies.get(0).toString();
    }

    private Movie getRandomMovie(){
        //source: https://www.geeksforgeeks.org/getting-random-elements-from-arraylist-in-java/
        int index = (int)(Math.random() * movies.size());
        return movies.get(index);
    }

    public String getRandomMovieToString(){
        return getRandomMovie().toString();
    }


    public String getTenSortByPopularity(){
        ArrayList<Movie> top10RandomMovies = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < 10; i++) {
            top10RandomMovies.add(getRandomMovie());
        }

        MovieComparator comparator = new MovieComparator("popularity");
        Collections.sort(top10RandomMovies,comparator);
        String result = "";
        for (Movie movie : top10RandomMovies) {
            result += movie.toString();
        }
        return result;
    }

    public String howManyWonAnAward(){
        ArrayList<Movie> moviesWithAward = new ArrayList<>();

        for (Movie movie : movies){
            if(movie.hasAwards()){
                moviesWithAward.add(movie);
            }
        }

        String result = moviesWithAward.size() + " movies has won at least one award</br>Here is the list: ";
        for (Movie movie : moviesWithAward){
            result += movie.toString();
        }
        return result;
    }


}
