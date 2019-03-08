package com.example.week4day3homework.View.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4day3homework.R;
import com.example.week4day3homework.model.photos.Photo;
import com.example.week4day3homework.model.photos.PhotoResponse;
import com.example.week4day3homework.model.photos.Photos;

import java.util.List;

import retrofit2.adapter.rxjava2.Result;

public class PhotoRecyclerViewAdapter extends RecyclerView.Adapter<PhotoRecyclerViewAdapter.ViewHolder> {
List<Photo> photoList;
    @NonNull
    @Override
    public PhotoRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoRecyclerViewAdapter.ViewHolder viewHolder, int i) {
        Photo photo = photoList.get(i);


        viewHolder.tvTitle.setText(photo.getTitle());
        Glide.with(viewHolder.itemView.getContext()).load("https://" + photo.getFarm() + "staticflickr.com/" + photo.getServer() + "/" + photo.getSecret() + ".jpg").into(viewHolder.imgImage);

    }
    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgImage;
        TextView tvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgImage = itemView.findViewById(R.id.imgImageView);
            tvTitle = itemView.findViewById(R.id.tvImageTitle);
        }
    }
}
