package com.example.retrofitktphanesinikurulumu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.retrofitktphanesinikurulumu.Models.Bilgiler;

import java.util.List;

public class adapter extends BaseAdapter {
    List<Bilgiler> list;
    Context context;

    public adapter(List<Bilgiler> list, Context context) {
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
        convertView= LayoutInflater.from(context).inflate(R.layout.custom_listview,parent,false);
        TextView userid=convertView.findViewById(R.id.userİd);
        TextView id=convertView.findViewById(R.id.İd);
        TextView title=convertView.findViewById(R.id.userTitle);
        TextView body=convertView.findViewById(R.id.body);

        userid.setText(""+list.get(position).getUserId());
        id.setText(""+list.get(position).getId());
        title.setText(""+list.get(position).getTitle());
        body.setText(""+list.get(position).getBody());

        return convertView;
    }
}
