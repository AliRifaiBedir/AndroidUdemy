package com.example.listview_kullanm_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class KullanıcıListAdapter extends BaseAdapter {
    List<KullanıcıModel> list;
    Context context;

    public KullanıcıListAdapter(List<KullanıcıModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
        //Listenin uzunlupunu alır
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
        //Sırasıyla gelen elemanı tanımlar
    }

    @Override
    public long getItemId(int position) {
        return 0;
        //Boş kalsın
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = LayoutInflater.from(context).inflate(R.layout.customlayout, parent, false);
        //Burada customlayout çağırıldı
        TextView isim = layout.findViewById(R.id.isim);
        TextView soyisim = layout.findViewById(R.id.soyisim);
        TextView yas = layout.findViewById(R.id.yas);
        TextView takım = layout.findViewById(R.id.takım);
        //Böylece tanımlamaları yapmış olduk

        isim.setText(list.get(position).getIsim());
        soyisim.setText(list.get(position).getSoyisim());
        takım.setText(list.get(position).gettakım());
        yas.setText(list.get(position).getYas());


        return layout;
    }
}
