package com.example.android.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.weather.model.Example;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText search;
    TextView content;
    String city;
    String data;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search=findViewById(R.id.search);
        show=findViewById(R.id.show);
        content=findViewById(R.id.content);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Api api=retrofit.create(Api.class);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city=String.valueOf(search.getText());
                Call<Example> call=api.getByCity(city,BuildConfig.Api_Key);
                call.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if(response.isSuccessful()){
                        Toast.makeText(MainActivity.this,"data fetched",Toast.LENGTH_LONG).show();
                        Example example=response.body();
                        data="City name: "+example.getName();
                        data+="\nTemperature: "+example.getMain().getTemp()+"°C";
                        data+="\nCountry: "+example.getSys().getCountry();
                        content.setText(data);
                        }
                        else
                            {
                            int statusCode=response.code();
                            String message=response.message();
                            Toast.makeText(MainActivity.this,statusCode+"",Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                            t.printStackTrace();
                        Toast.makeText(MainActivity.this,"fail",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }
}
