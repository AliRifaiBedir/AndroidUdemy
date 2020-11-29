package com.example.receyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.tanimla> {
    //Burada farklı olarak  "tanimla" adlı class olusturup ona göre işlem yapıyoruz
    //Bundan dolayı adapter.tanimla adlı bir şey var yuakrıda
    Context context;
    List<MesajmModel> liste;

    public adapter(Context context, List<MesajmModel> liste) {
        this.context = context;
        this.liste = liste;
    }

    @NonNull
    @Override
    public tanimla onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Burada biz Layout yani view olusturcaz
        View view= LayoutInflater.from(context).inflate(R.layout.customlayout,parent,false);
        return  new tanimla(view);
        //tanimla adlı class içinde olusturcağımız viewlere burdan ulasacağız
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull tanimla holder, int position) {
        //Burada tanimla nesnesi ile sırasıyla gelen elemaın değerleri set edildi
        holder.kisi.setText(liste.get(position).getKisi());
        holder.mesaj.setText(liste.get(position).getMesajIcerik());
        holder.img.setImageResource(liste.get(position).getResimId());

        //Aşagıda şimdi ise resimlere tıklayınca Toast mesajı yayınlayacaz

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,liste.get(position).getKisi(),Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        //Kaç defa dönecek
        return liste.size();
    }

    public  class tanimla extends RecyclerView.ViewHolder{
        ImageView img;
        TextView kisi;
        TextView mesaj;

        public tanimla(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.KisiResmi);
            kisi=itemView.findViewById(R.id.Kisiİsmi);
            mesaj=itemView.findViewById(R.id.Mesaj);
        }
    }

}
