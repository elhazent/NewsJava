package com.elhazent.education.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.elhazent.education.newsapp.adapter.NewsAdapter;
import com.elhazent.education.newsapp.dummy.DataDummy;
import com.elhazent.education.newsapp.model.NewsItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_news);

        adapter = new NewsAdapter(getApplicationContext(),getMovies());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<NewsItem> getMovies(){
        return DataDummy.generateNews();
    }
}
