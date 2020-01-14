package com.example.movies.UI.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.GridView;

import com.example.movies.R;
import com.example.movies.UI.Adapter.MovieAdapter;
import com.example.movies.UI.ViewModel.MovieViewModel;
import com.example.movies.pojo.MoviesModel;
import com.example.movies.pojo.ResultsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    MovieViewModel movieViewModel;
    List<ResultsModel> allPages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

        movieViewModel.getPopularMovies();

        final MovieAdapter movieAdapter = new MovieAdapter(this);
        gridView.setAdapter(movieAdapter);

        movieViewModel.moviepostmutableLiveData.observe(this, new Observer<MoviesModel>() {
            @Override
            public void onChanged(MoviesModel moviesModels) {
                    allPages.addAll(moviesModels.getResults());
                    movieAdapter.setMovies(allPages);

            }
        });
    }
}
