package com.kimsutto.sujinmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<MusicData> music;

    public MusicAdapter(Context context, ArrayList<MusicData> data) {
        mContext = context;
        music = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return music.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public MusicData getItem(int position) {
        return music.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.item, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.poster);
        TextView movieName = (TextView)view.findViewById(R.id.movieName);
        TextView grade = (TextView)view.findViewById(R.id.grade);

        imageView.setImageResource(music.get(position).getPoster());
        movieName.setText(music.get(position).getMovieName());
        grade.setText(music.get(position).getGrade());

        return view;
    }
}