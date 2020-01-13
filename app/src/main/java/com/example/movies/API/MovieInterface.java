package com.example.movies.API;

import android.graphics.Movie;

import com.example.movies.pojo.MoviesModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieInterface {

    @GET( MovieDB.popular_movies )
    Call<MoviesModel> getPopularMovies(@Query("page") String pageNum);

}
