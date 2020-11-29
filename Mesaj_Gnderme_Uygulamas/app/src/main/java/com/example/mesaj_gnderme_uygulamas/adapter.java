package com.example.mesaj_gnderme_uygulamas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {
    List<model> modelList;
    Context context;
    Activity activity;

    public adapter(List<model> modelList, Context context, Activity activity) {
        this.modelList = modelList;
        this.context = context;
        this.activity=activity;

    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.custom_layout,parent,false);
        final EditText Mesajİcerik=convertView.findViewById(R.id.Mesajİcerik);
        TextView  İsim=convertView.findViewById(R.id.İsim);
        TextView  Tel=convertView.findViewById(R.id.Tel);
        Button Buton=convertView.findViewById(R.id.Buton);


        Tel.setText(modelList.get(position).getTel());
        İsim.setText(modelList.get(position).getIsim());

        final String telno=(modelList.get(position).getTel());


        Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mesajımız=Mesajİcerik.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+telno));
                intent.putExtra("sms body",mesajımız);
                activity.startActivity(intent);



            }
        });






        return null;
    }
}
