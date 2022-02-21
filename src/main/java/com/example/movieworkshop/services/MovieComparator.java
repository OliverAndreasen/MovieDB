package com.example.movieworkshop.services;

import com.example.movieworkshop.models.Movie;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movie> {
    private String type;

    public MovieComparator(String type) {
        this.type = type;
    }

    @Override
    public int compare(Movie o1, Movie o2) {
        int result = 0;
        if (type.equals("popularity")) {
            result = Integer.compare(o1.getPopularity(), o2.getPopularity());
        } else if (type.equals("longest")) {
            result = Integer.compare(o1.getLength(), o2.getLength());
        }
        return result;
    }
}
