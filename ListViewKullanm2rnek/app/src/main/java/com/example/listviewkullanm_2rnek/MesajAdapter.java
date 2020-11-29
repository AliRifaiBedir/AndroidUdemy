package com.example.listviewkullanm_2rnek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MesajAdapter extends BaseAdapter {
    List<MesajModel> liste;
    Context context;

    public MesajAdapter(List<MesajModel> liste, Context context) {
        this.liste = liste;
        this.context = context;
    }

    @Override
    public int getCount() {
        return liste.size();
        //Böylece LİSTENİN kaç defa  döneceği belli olur
    }

    @Override
    public Object getItem(int position) {
        return liste.get(position);
        //Sırasıyla gelen eleman
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout= LayoutInflater.from(context).inflate(R.layout.customlayout,parent,false);
        ImageView img=layout.findViewById(R.id.KisiResmi);
        TextView Kisiİsmi=layout.findViewById(R.id.Kisiİsmi);
        TextView KisiMesaj=layout.findViewById(R.id.Mesaj);

        img.setImageResource(liste.get(position).getResimId());
        Kisiİsmi.setText(liste.get(position).getKisi());
        KisiMesaj.setText(liste.get(position).getMesajIcerik());


        return layout;
    }
}
