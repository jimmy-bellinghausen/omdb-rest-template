package com.galvanize.controllers;

import com.galvanize.model.SearchResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/movies")
public class OmdbController {
    RestTemplate restTemplate;

    String basePath = "http://www.omdbapi.com/?i=tt3896198&apikey=f0185faf";
    String searchBase = basePath + "&s=";

    public OmdbController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public SearchResults searchForResults(@RequestParam String searchTerm){
        return restTemplate.getForObject(searchBase+searchTerm, SearchResults.class);
    }

}
