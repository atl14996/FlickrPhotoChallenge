package com.example.week4day3homework.datasource.remote;

import com.example.week4day3homework.URLConstants;
import com.example.week4day3homework.model.photos.PhotoResponse;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week4day3homework.URLConstants.API_KEY_PATH;
import static com.example.week4day3homework.URLConstants.BASE_URL;
import static com.example.week4day3homework.URLConstants.QUERY_GET_RECENT;
import static com.example.week4day3homework.URLConstants.RESPONSE_FORMAT;

public class RetrofitHelper {

    private static OkHttpClient getOkHttpClientWithInterceptor(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();


    }

    private static Retrofit getRetrofit() {

        return new Retrofit.Builder().baseUrl(BASE_URL).client(getOkHttpClientWithInterceptor()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

    }

    private ObservableInterface getPhotoResponseInterface() {

        return getRetrofit().create(ObservableInterface.class);

    }


    public Observable<PhotoResponse> getPhotoResponseObservable(String returnedstring, String apiKey, String responseFormat) {

        return getPhotoResponseInterface().getPhotoResponseObservable(returnedstring, apiKey, responseFormat);


    }

    private interface ObservableInterface {
        @GET(URLConstants.PATH)
        Observable<PhotoResponse> getPhotoResponseObservable(@Query(QUERY_GET_RECENT) String returnedString, @Query(API_KEY_PATH) String apiKey, @Query(RESPONSE_FORMAT) String responseFormat);

    }
}
