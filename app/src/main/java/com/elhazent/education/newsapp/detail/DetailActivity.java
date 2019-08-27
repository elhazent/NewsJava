package com.elhazent.education.newsapp.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.elhazent.education.newsapp.R;
import com.elhazent.education.newsapp.model.NewsItem;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_DATA = "data";
    TextView detailjudul;
    TextView detailpenulis;
    TextView detailtanggal;
    TextView detailcontent;
    ImageView detailimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        NewsItem data = getIntent().getParcelableExtra(EXTRA_DATA);

        detailjudul = findViewById(R.id.newsTitleDetail);
        detailcontent = findViewById(R.id.newsContentDetail);
        detailtanggal = findViewById(R.id.newsDateDetail);
        detailpenulis = findViewById(R.id.newsWriterDetail);
        detailimage = findViewById(R.id.newsImageDetail);

        detailjudul.setText(data.getJudul());
        detailcontent.setText(data.getContent());
        detailtanggal.setText(data.getTanggal());
        detailpenulis.setText("Oleh : "+data.getPenulis());

        Glide.with(this)
                .load(data.getImages())
                .override(600, 200)
                .into(detailimage);


    }
    
}
