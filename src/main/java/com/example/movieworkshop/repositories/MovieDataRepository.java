package com.example.movieworkshop.repositories;

import com.example.movieworkshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDataRepository {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieDataRepository() {
        this.movies = getMoviesFromFile();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    private ArrayList getMoviesFromFile(){
        File file = new File("imdb-data.csv");
        try {
            int count = 0;
            Scanner sc = new Scanner(file);
            String result = "";
            sc.nextLine();
            while(sc.hasNextLine()){
                count++;
                String line = sc.nextLine();

                String[] stringAsArray = line.split(";");
                int year = Integer.parseInt(stringAsArray[0]);
                int length = Integer.parseInt(stringAsArray[1]);
                String title = stringAsArray[2];
                String subject = stringAsArray[3];
                int popularity = Integer.parseInt(stringAsArray[4]);
                boolean awards;
                if(stringAsArray[5].equals("Yes")) {
                    awards = true;
                }else {
                    awards = false;
                }

                Movie movie = new Movie(year, length, title, subject, popularity, awards);
                movies.add(movie);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return movies;
    }


}
