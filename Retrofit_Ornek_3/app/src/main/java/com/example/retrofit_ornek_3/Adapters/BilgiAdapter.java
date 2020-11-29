package com.example.retrofit_ornek_3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofit_ornek_3.Models.Bilgi;
import com.example.retrofit_ornek_3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {
    List<Bilgi>  list;
    Context  context;

    public BilgiAdapter(List<Bilgi> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.custom_layout,parent,false);
        TextView albumId,id,title,url;
        albumId=convertView.findViewById(R.id.albumId);
        id=convertView.findViewById(R.id.id);
        title=convertView.findViewById(R.id.title);
        url=convertView.findViewById(R.id.url);

        albumId.setText(""+list.get(position).getAlbumId());
        id.setText(""+list.get(position).getId());
        title.setText(list.get(position).getTitle());
        url.setText(list.get(position).getUrl());

        ImageView imageView=convertView.findViewById(R.id.thumbnailUrl);
        Picasso.get().load(list.get(position).getThumbnailUrl()).into(imageView);
        //Resimleri aldık

        return convertView;
    }
}
