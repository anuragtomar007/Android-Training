package com.railsfactory.anurag.androidlibrarytutorials;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity_CheckRetrofit extends AppCompatActivity {

    private ListView listView;
    private String[] AndroidDevelopers = {"Rajeev","Raja","Kalpesh","Anurag","Kumaresh","Naren"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_checkretrofit);
        listView = (ListView) findViewById(R.id.checklistViewHeroes);
        getApi();
    }

    private void getApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiCheck.BASE_URL_CHECK)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCheck apiCheck = retrofit.create(ApiCheck.class);
        Call<List<Check>> call = apiCheck.getApi();
        call.enqueue(new Callback<List<Check>>() {
            @Override
            public void onResponse(Call<List<Check>> call, Response<List<Check>> response) {
                List<Check> checkList = response.body();
                String[] checkApi = new String[checkList.size()];
                for (int i = 0; i < checkList.size(); i++) {
                    checkApi[i] = checkList.get(i).getSensorId();
                    Log.v("New Log to Check", "Check Id :" + checkApi[i]);
                }
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,checkApi));
            }

            @Override
            public void onFailure(Call<List<Check>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
