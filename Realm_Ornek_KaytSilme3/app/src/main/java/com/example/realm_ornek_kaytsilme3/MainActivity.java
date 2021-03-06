package com.example.realm_ornek_kaytsilme3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity {

    /*
    1) İlk olarak MyApplciaton sınfını tanımladık
    2)KisiBilgileri sınıfını tanımladık ve RealmObject ile kalıtım aldık
    3)XML deki viewlere ulaştık ve Realm sınfından nesne ürettik
    4)yaz() fonksiyonu ile veritabanına verileri kaydettik
    5)Butona basınca kaydetme işlemini yani yaz() fonkisyonunu çağırdık
    6)SOn olarak customlayout ile listVİEW Yapısı için tasarım yaptık
    7)ActiviitMnain XML'DE listview tanımladık
    8)Adapterkullanmk için adapter class oluturudk
    9)Son olarak ListVİEW içinw set ettik adapterı
  */

    // İkinci aşama olarak Listview hangi elemanını tıklarsak silelim
    //İlk olarak pozisyon_bul fonksiyonu ile listciewda tıkalnan elemanın pozisyonunu bulcaz
    //xml de Listview için android:clickable="true" tanımla


    EditText EditTextKullanıcı, EditTextİsim, EditTextSifre;
    Button ButonKaydet;
    RadioGroup GrupRadio;
    Realm realm;
    Context context = this;
    ListView ListVİEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();//Realm tanımladık
        EditTextİsim = findViewById(R.id.EditTextİsim);
        EditTextKullanıcı = findViewById(R.id.EditTextKullanıcı);
        EditTextSifre = findViewById(R.id.EditTextSifre);
        GrupRadio = findViewById(R.id.GrupRadio);
        ButonKaydet = findViewById(R.id.ButonKaydet);
        ListVİEW = findViewById(R.id.ListVİEW);


        //Butona basınca databese veri kaydettik
        ButonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String textİsim = EditTextİsim.getText().toString();
                final String textKullanıcı = EditTextKullanıcı.getText().toString();
                final String textSifre = EditTextSifre.getText().toString();
                //Edt verilerini aldık

                Integer id = GrupRadio.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(id);
                final String textCinsiyet = radioButton.getText().toString();
                //Radio Butona ulaşştık

                yaz(textİsim, textSifre, textKullanıcı, textCinsiyet);

                EditTextİsim.setText("");
                EditTextKullanıcı.setText("");
                EditTextSifre.setText("");


            }
        });


        listview_göster(); //ListView görünecek
        pozisyon_bul();



    }


    public void yaz(final String isim, final String Sifre, final String Kullanıcı, final String Cinsiyet) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //Ekleme işlemlerini yapacağımız yer
                KisiBilgileri kisiBilgileri = realm.createObject(KisiBilgileri.class);
                //KişiBilgileri classını böyle tanımlıyoruz
                kisiBilgileri.setCinsiyet(Cinsiyet);
                kisiBilgileri.setSifre(Sifre);
                kisiBilgileri.setKullanıcı(Kullanıcı);
                kisiBilgileri.setIsim(isim);


            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                //Başarılı Ekleme olması durumu
                Toast.makeText(context, "Başarışı bir şekilde kaydedildi", Toast.LENGTH_LONG).show();
                listview_göster();//Başarılı ekleme sonrası da göster

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                //Başarısız Ekleme Drumu
                Toast.makeText(context, "Kayıt İşlemi Başarısız", Toast.LENGTH_LONG).show();


            }
        });
    }


    public void listview_göster() {
        RealmResults<KisiBilgileri> kisiBilgileris = realm.where(KisiBilgileri.class).findAll();
        if (kisiBilgileris.size() > 0) {

            adapter adapter = new adapter(kisiBilgileris, getApplicationContext());
            ListVİEW.setAdapter(adapter);


        }


    }

    public void pozisyon_bul() {
        //BUrdaki amaç Listview tıklanan elemana ulaşmak
        //xml de Listview için android:clickable="true" tanımla

        ListVİEW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //Burada pozisyonuyla gelen elemanı silme işlemi yaptık
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               tablodan_sil(position);




            }
        });

    }

    public void tablodan_sil(final int position) {
        final RealmResults<KisiBilgileri> gelenTablo = realm.where(KisiBilgileri.class).findAll();
        //Böylece tablodaki tüm veriler alıoğ gelenTablo listesine atadık


        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                KisiBilgileri gelenkisi = gelenTablo.get(position);
                //tıklanan ksiiyi gelenkisi adlı değişkene attık
                gelenkisi.deleteFromRealm();
                //Veriyi sildik
                listview_göster();//Bunu bvurda çağırdık ki silince listenin son hali görülsün

            }
        });


    }






   /* public void aler_ac(final int position) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.alert_layout, null);
        //Layout çağırdık

        Button butonEvet = findViewById(R.id.butonEvet);
        Button butonHayır = findViewById(R.id.butonHayır);
        //Butonları tanımladık

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        //AlerDialog tanımladık


        alert.setView(alertLayout);//Layout set ettik
        alert.setCancelable(false);

        final AlertDialog dialog = alert.create();
        //AlertDialog yarattık

        butonEvet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tablodan_sil(position);
                dialog.cancel();//Silmeden sonra dialog kapanısn


            }
        });


        butonHayır.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();



    }*/
}

