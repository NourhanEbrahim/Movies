package com.example.movies.UI.main;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movies.R;
import com.github.akashandroid90.imageletter.MaterialLetterIcon;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailedScreen extends AppCompatActivity {

    double vote_average;
    String imgUrl, title, overview, release_date;
    Bundle bundle;

    //Butterknife
    @BindView(R.id.vote_average)
    MaterialLetterIcon voteAverage;
    @BindView(R.id.title)
    TextView Title;
    @BindView(R.id.release_date)
    TextView releaseDate;
    @BindView(R.id.overview)
    TextView Overview;
    @BindView(R.id.movie_image)
    ImageView MovieImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_screen);
        ButterKnife.bind(this);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.get("vote_average") != null)
                vote_average = (double) bundle.get("vote_average") * 10;
            if (bundle.get("title") != null)
                title = bundle.get("title").toString();
            if (bundle.get("img") != null)
                imgUrl = bundle.get("img").toString();
            if (bundle.get("release_date") != null)
                release_date = bundle.get("release_date").toString();
            if (bundle.get("overview") != null)
                overview = bundle.get("overview").toString();
        }

        Picasso.get().load(Uri.parse(imgUrl)).fit().into(MovieImage, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

        voteAverage.setLetter(vote_average + "%");
        Title.setText(title);
        releaseDate.setText(release_date);
        Overview.setText(overview);
    }
}
