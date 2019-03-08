package com.example.week4day3homework.datasource.remote;

import com.example.week4day3homework.model.photos.PhotoResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PhotoResponseObserver implements Observer<PhotoResponse> {
 PhotoResponse returnPhotoResponse;
 PhotoResponseCallback photoResponseCallback;

    public PhotoResponseObserver(PhotoResponseCallback photoResponseCallback) {
        this.photoResponseCallback = photoResponseCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(PhotoResponse photoResponse) {
returnPhotoResponse = photoResponse;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

        photoResponseCallback.Onsuccess(returnPhotoResponse);
    }
}
