package com.elhazent.education.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.elhazent.education.newsapp.R;
import com.elhazent.education.newsapp.detail.DetailActivity;
import com.elhazent.education.newsapp.model.NewsItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    List<NewsItem> newsItems;


    public NewsAdapter(Context context, List<NewsItem> newsItems) {
        this.context = context;
        this.newsItems = newsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.tvjudul.setText(newsItems.get(position).getJudul());
        holder.tvpenulis.setText(newsItems.get(position).getPenulis());
        holder.tvtanggal.setText(newsItems.get(position).getTanggal());

        Glide.with(context)
                .load(newsItems.get(position).getImages())
                .override(600, 200)
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsItem data = newsItems.get(position);
                Intent intent = new Intent(context, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(DetailActivity.EXTRA_DATA,data);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvjudul;
        TextView tvtanggal;
        TextView tvpenulis;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvjudul = itemView.findViewById(R.id.tvJudulBerita);
            tvpenulis = itemView.findViewById(R.id.tvPenulis);
            tvtanggal = itemView.findViewById(R.id.tvTglTerbit);
            image = itemView.findViewById(R.id.ivGambar);

        }
    }
}
