package com.example.data_product_retrofit_project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataModelClas>ProductList=new ArrayList<>();
    ArrayList<Model_Class>ModelList=new ArrayList<>();
    Recyclerview_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        adapter=new Recyclerview_Adapter(MainActivity.this,ModelList);

        Instance_Class.CallAPI().ShowProduct().enqueue(new Callback<List<DataModelClas>>() {
            @Override
            public void onResponse(Call<List<DataModelClas>> call, Response<List<DataModelClas>> response) {
                Log.d("AAA", "onResponse: "+response.body().get(0).getTitle().toString());
                ProductList=response.body();
                for (int i=0;i<ProductList.size();i++)
                {

                    String title=response.body().get(i).getTitle();
                  String completed= String.valueOf(response.body().get(i).getCompleted());

                    Model_Class model=new Model_Class(title,completed);
                    Log.d("TTT", "onResponse: "+title);
                    ModelList.add(model);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<DataModelClas>> call, Throwable t) {
                Log.e("AAA", "onFailure: Error"+t.getLocalizedMessage() );
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });




    }
}