package com.example.retrofit_ornek_2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.retrofit_ornek_2.Models.Bilgi;
import com.example.retrofit_ornek_2.R;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {
    List<Bilgi> bilgiList;
    Context context;

    public BilgiAdapter(List<Bilgi> bilgiList, Context context) {
        this.bilgiList = bilgiList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bilgiList.size();
    }

    @Override
    public Object getItem(int position) {
        return bilgiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.custom_layout,parent,false);
        TextView userId=convertView.findViewById(R.id.userId);
        TextView id=convertView.findViewById(R.id.id);
        TextView title=convertView.findViewById(R.id.Gelentitle);
        CheckBox complatedCheckbox=convertView.findViewById(R.id.completed);

        userId.setText(userId.getText()+""+bilgiList.get(position).getUserId());
        id.setText(id.getText()+""+bilgiList.get(position).getId());
        title.setText(title.getText()+""+bilgiList.get(position).getTitle());

        Boolean deger=bilgiList.get(position).getCompleted();
        if (deger== true){
            complatedCheckbox.setChecked(true);

        }
        else{
            complatedCheckbox.setChecked(false);

        }



        return convertView;
    }
}
