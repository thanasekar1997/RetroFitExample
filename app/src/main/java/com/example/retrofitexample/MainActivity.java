package com.example.retrofitexample;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofitexample.model.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {
    interface RequestUser{
        @GET("/api/users/{uid}")
        Call<UserData> getUser(@Path("uid") String uid);

    }
    TextView fName,lName,url,email,url2;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        fName = findViewById(R.id.firstName);
        lName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        url = findViewById(R.id.url);
        image = findViewById(R.id.image);
        url2 = findViewById(R.id.someText);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestUser ru = retrofit.create(RequestUser.class);
        ru.getUser("3").enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(@NonNull Call<UserData> call, @NonNull Response<UserData> response) {
                assert response.body() != null;
                fName.setText(response.body().data.first_name);
                lName.setText(response.body().data.last_name);
                email.setText(response.body().data.email);
                url.setText(response.body().support.url);
                url2.setText(response.body().data.avatar);

                Log.d(this.getClass().getSimpleName(), response.body().data.toString());
                Glide.with(MainActivity.this)
                        .load(response.body().data.avatar)
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.ic_launcher_foreground)
                                .error(R.drawable.ic_launcher_background)
                                .diskCacheStrategy(DiskCacheStrategy.ALL))
                        .into(image);

            }

            @Override
            public void onFailure(Call<UserData> call, Throwable throwable) {
                fName.setText(throwable.getMessage());
            }
        });
    }
}