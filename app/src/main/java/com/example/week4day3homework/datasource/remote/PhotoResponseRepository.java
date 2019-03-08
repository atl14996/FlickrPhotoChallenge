package com.example.week4day3homework.datasource.remote;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class PhotoResponseRepository {

    private RetrofitHelper retrofitHelper;


    public PhotoResponseRepository(){

        this.retrofitHelper = new RetrofitHelper();
    }

    public void getPhotoResponse(String returnedString, String apiKey, String format, PhotoResponseCallback photoResponseCallback){


        retrofitHelper.getPhotoResponseObservable(returnedString, apiKey, format).observeOn(AndroidSchedulers.mainThread()).subscribe(new PhotoResponseObserver(photoResponseCallback));
    }
}
