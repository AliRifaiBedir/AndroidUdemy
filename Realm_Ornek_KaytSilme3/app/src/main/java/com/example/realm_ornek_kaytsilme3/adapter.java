package com.example.realm_ornek_kaytsilme3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {
    List<KisiBilgileri> list;

    public adapter(List<KisiBilgileri> list, Context context) {
        this.list = list;
        this.context = context;
    }

    Context context;
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
        TextView isim=convertView.findViewById(R.id.İsimCustomText);
        TextView sifre=convertView.findViewById(R.id.SifreCustomText);
        TextView kullanıcı=convertView.findViewById(R.id.KullanıcıCustomText);
        TextView cinsiyet=convertView.findViewById(R.id.CinsiyetCustomText);
        //Viewlere ulaştık

        isim.setText(list.get(position).getIsim());
        sifre.setText(list.get(position).getSifre());
        kullanıcı.setText(list.get(position).getKullanıcı());
        cinsiyet.setText(list.get(position).getCinsiyet());
        //Viewlere değerleri atadık lsiteden




        return convertView;
    }
}
