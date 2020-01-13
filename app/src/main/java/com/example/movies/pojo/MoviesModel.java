package com.example.movies.pojo;

import java.util.ArrayList;
import java.util.List;

public class MoviesModel {

    List<ResultsModel> results = new ArrayList<>();

    public List<ResultsModel> getResults() {
        return results;
    }

    public void setResults(List<ResultsModel> results) {
        this.results = results;
    }
}
