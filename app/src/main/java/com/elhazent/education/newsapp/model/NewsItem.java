package com.elhazent.education.newsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsItem implements Parcelable {

    String id;
    int images;
    String penulis;
    String judul;
    String content;
    String tanggal;

    public NewsItem(String id, int images, String penulis, String judul, String content, String tanggal) {
        this.id = id;
        this.images = images;
        this.penulis = penulis;
        this.judul = judul;
        this.content = content;
        this.tanggal = tanggal;
    }

    public NewsItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeInt(this.images);
        dest.writeString(this.penulis);
        dest.writeString(this.judul);
        dest.writeString(this.content);
        dest.writeString(this.tanggal);
    }

    protected NewsItem(Parcel in) {
        this.id = in.readString();
        this.images = in.readInt();
        this.penulis = in.readString();
        this.judul = in.readString();
        this.content = in.readString();
        this.tanggal = in.readString();
    }

    public static final Parcelable.Creator<NewsItem> CREATOR = new Parcelable.Creator<NewsItem>() {
        @Override
        public NewsItem createFromParcel(Parcel source) {
            return new NewsItem(source);
        }

        @Override
        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };
}
