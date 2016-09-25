package com.firman.realmtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.firman.realmtest.R;
import com.firman.realmtest.adapter.AdapterArticle;
import com.firman.realmtest.helper.RealmHelper;
import com.firman.realmtest.models.DataModel;

import java.util.ArrayList;

/**
 * Created by Firman on 9/24/2016.
 */

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    private RecyclerView recyclerView;
    private RealmHelper helper;
    private ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        data = new ArrayList<>();
        helper = new RealmHelper(this);

        recyclerView = (RecyclerView) findViewById(R.id.rvArticle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
            }
        });

        setRecyclerView();
    }

    /**
     * set recyclerview with try get data from realm
     */
    public void setRecyclerView(){
        try{
            data = helper.findAllArticle();
        }catch (Exception e){
            e.printStackTrace();
        }
        AdapterArticle adapter = new AdapterArticle(data, new AdapterArticle.OnItemClickListener() {
            @Override
            public void onClick(DataModel item) {
                Intent i = new Intent(getApplicationContext(), DeleteActivity.class);
                i.putExtra("id", item.getId());
                i.putExtra("title", item.getTitle());
                i.putExtra("description", item.getDescription());
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            data = helper.findAllArticle();
        }catch (Exception e){
            e.printStackTrace();
        }

        setRecyclerView();
    }
}
