package com.example.movies.API;

import com.example.movies.pojo.MoviesModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.time.chrono.ThaiBuddhistChronology.INSTANCE;

public class MovieDB {


    public static final String BASE_URL         =   "https://api.themoviedb.org/3/";
    public static final String API_KEY          =   "e1e34c80b3bf7742f07ffce0f5213a15";
    public static final String popular_movies   =   BASE_URL +"movie/popular?api_key="+API_KEY+"&language=en-US";
    public static MovieDB INSTANCE;
    public MovieInterface movieInterface;

    public MovieDB() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieInterface = retrofit.create(MovieInterface.class);
    }
    public static MovieDB getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new MovieDB();
        }
        return INSTANCE;
    }

    public Call<MoviesModel> getMovies(String pageNum){
        return movieInterface.getPopularMovies(pageNum);
    }
}