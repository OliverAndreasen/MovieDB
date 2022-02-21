package com.example.movieworkshop.controllers;

import com.example.movieworkshop.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MovieController {
    MovieService service = new MovieService();


    //Controller methods
    @GetMapping("/")
    public String index() {
        return "This application is a list of movies from IMDB";
    }
    @GetMapping("/getFirst")
    public String getFirst(){
        return service.getFirst();
    }
    @GetMapping("/getRandom")
    public String getRandom(){
        return service.getRandomMovieToString();
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity(){
        return service.getTenSortByPopularity();
    }

    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward(){
        return service.howManyWonAnAward();
    }

    @GetMapping("/data1")
    public String singleParam(@RequestParam String id) {
        return "id: " + id;
    }
}