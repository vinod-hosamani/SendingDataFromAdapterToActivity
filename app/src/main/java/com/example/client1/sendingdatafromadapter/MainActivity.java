package com.example.client1.sendingdatafromadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomAdapter.passingDataToActivity {
    RecyclerView recyclerView;
    List<Model> modelList;
    TextView f, l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f = (TextView) findViewById(R.id.fn);
        l = (TextView) findViewById(R.id.ln);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Model> ll = prepareData();
        CustomAdapter customAdapter = new CustomAdapter(ll, this);
        recyclerView.setAdapter(customAdapter);


    }

    public List<Model> prepareData() {
        modelList = new ArrayList<>();

        Model list;

        list = new Model();
        list.firstName = "vond";
        list.lastName = "bosa";
        modelList.add(list);

        list = new Model();
        list.firstName = "pramod";
        list.lastName = "balalri";
        modelList.add(list);

        return modelList;

    }

    @Override
    public void passingDataToActivity(View View, int position, Model model) {
        f.setText(model.firstName);
        l.setText(model.lastName);
    }

}
