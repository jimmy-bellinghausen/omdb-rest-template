package com.galvanize.controllers;

import com.galvanize.model.OmdbMovie;
import com.galvanize.model.SearchResults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/movies")
public class OmdbController {
    RestTemplate restTemplate;

    String basePath = "http://www.omdbapi.com/?apikey=f0185faf";
    String searchBase = basePath + "&i=tt3896198&s=";
    String movieBase = basePath + "&i=";

    public OmdbController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public SearchResults searchForResults(@RequestParam String searchTerm){
        return restTemplate.getForObject(searchBase+searchTerm, SearchResults.class);
    }

    @GetMapping("/{id}")
    public OmdbMovie findById(@PathVariable String id){
        return restTemplate.getForObject( movieBase + id, OmdbMovie.class );
    }

}
