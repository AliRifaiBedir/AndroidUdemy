package com.example.realm_grafik_kaytlarnn_arayzde_gsterilmesi_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    EditText BüyükTansiyonEditText,KücükTansiyonEditText;
    Button ButonEkle;
    BarChart chart;//Bunu yapmadan önce xml de ekledik unutma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance(); // opens "örnekgrafik.realm"

        BüyükTansiyonEditText=findViewById(R.id.BüyükTansiyon);
        KücükTansiyonEditText=findViewById(R.id.KücükTansiyon);
        ButonEkle=findViewById(R.id.ButonEkle);
        chart=findViewById(R.id.barChart);

        veriEkle();
        göster();

    }


    public  void veriEkle(){
        ButonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Tansiyon tansiyon=realm.createObject(Tansiyon.class);
                        //Nesnemizi olusturduk
                        tansiyon.setBüyükTansiyon(BüyükTansiyonEditText.getText().toString());
                        tansiyon.setKücükTansiyon(KücükTansiyonEditText.getText().toString());
                    }
                });
                listele();

            }
        });

    }

    public  void listele(){
        RealmResults<Tansiyon> list=realm.where(Tansiyon.class).findAll();
        for (Tansiyon t: list){
            Log.i("Ekleme",t.toString());
        }



    }

    public  void göster(){
        RealmResults<Tansiyon> list=realm.where(Tansiyon.class).findAll();
        //Bütn verileri aldık

        Float büyükTansiyon= Float.valueOf(list.get(0).getBüyükTansiyon());
        Float kücükTansiyon= Float.valueOf(list.get(0).getKücükTansiyon());
        //Bunları böyle yaptık çünkü arraylist.add içinde float değer istiyor


        ArrayList<BarEntry> arrayList=new ArrayList<>();
        //BarEntry türünde arraylist olusturudk

        arrayList.add(new BarEntry(büyükTansiyon,0));
        arrayList.add(new BarEntry(kücükTansiyon,1));
        //Burdaki 0 ve 1 index değeri

        BarDataSet barDataSet=new BarDataSet(arrayList,"Toplam Değer");

        //Sütunlarımızı tanımladık






        ArrayList<String> sütunIsmi=new ArrayList<>();
        sütunIsmi.add("Büyük Tnasiyon");
        sütunIsmi.add("Küçük Tansiyon");

        //BarCHART SET edeceğmiz dataları set diyoruz
        BarData barData=new BarData(sütunIsmi,barDataSet);
        chart.setData(barData);


    }


}