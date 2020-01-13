package com.example.movies.UI.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.movies.UI.main.DetailedScreen;
import com.example.movies.pojo.ResultsModel;
import com.squareup.picasso.Callback;

import androidx.annotation.NonNull;

import com.example.movies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<ResultsModel> {

    private static Context context;
    private List<ResultsModel> movies = new ArrayList<>();


    public MovieAdapter(@NonNull Context context) {
        super(context, R.layout.one_item_in_grid);
        this.context = context;

    }
    public void setMovies(List<ResultsModel> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public ResultsModel getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ResultsModel product = getItem(i);
        final ProductViewHolder holder;

        if (view == null) {
            view = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
            assert vi != null;
            view = vi.inflate(R.layout.one_item_in_grid, null, false);

            holder = new ProductViewHolder();
            holder.img = (ImageView)view.findViewById(R.id.imageView);


            view.setTag(holder);
        }
        else{
            holder = (ProductViewHolder) view.getTag();
        }

        holder.populate(product,i);

        return view;
    }

    static class ProductViewHolder {
        public ImageView img;
        private String Img_URL = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";

        void populate(final ResultsModel model, final int i) {

                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent out = new Intent(context, DetailedScreen.class);
                        out.putExtra("title", model.getTitle() );
                        out.putExtra("vote_average", model.getVote_average());
                        out.putExtra("img", Img_URL+model.getPoster_path() );
                        out.putExtra("release_date", model.getRelease_date() );
                        out.putExtra("overview", model.getOverview() );
                        context.startActivity(out);
                    }
                });


                Picasso.get().load(Uri.parse(Img_URL+model.getPoster_path())).fit().into(img, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

        }


    }

}
