package com.example.movies.UI.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movies.API.MovieDB;
import com.example.movies.pojo.MoviesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    public MutableLiveData<MoviesModel> moviepostmutableLiveData = new MutableLiveData<>();

    public void getPopularMovies(String pageNum) {
            MovieDB.getINSTANCE().getMovies(pageNum).enqueue(new Callback<MoviesModel>() {
                @Override
                public void onResponse(Call<MoviesModel> call, Response<MoviesModel> response) {
                    moviepostmutableLiveData.setValue(response.body());
                }

                @Override
                public void onFailure(Call<MoviesModel> call, Throwable t) {
                    System.out.println("there is error : " + t);
                }
            });

    }
}
