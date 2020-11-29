package Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.retrofit_ornek_4_parametreli_stek.MainActivity2;
import com.example.retrofit_ornek_4_parametreli_stek.Models.Bilgi;
import com.example.retrofit_ornek_4_parametreli_stek.R;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {
    List<Bilgi> list;
    Context context;
    Activity activity;

    public BilgiAdapter(List<Bilgi> list, Context context, Activity activity) {
        this.list = list;
        this.activity = activity;
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
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false);
        TextView postId, id, email, body, name;
        LinearLayout layout;//layout için tıklama özewlliği vermek için yaptık bunu

        layout = convertView.findViewById(R.id.custom_layout);

        postId = convertView.findViewById(R.id.postId);
        id = convertView.findViewById(R.id.id);
        email = convertView.findViewById(R.id.email);
        body = convertView.findViewById(R.id.body);
        name = convertView.findViewById(R.id.name);

        postId.setText("" + list.get(position).getPostId());
        id.setText("" + list.get(position).getId());
        email.setText(list.get(position).getEmail());
        body.setText(list.get(position).getBody());
        name.setText(list.get(position).getName());

        final String post = "" + list.get(position).getPostId();
        final String ıd = "" + list.get(position).getId();

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MainActivity2.class);
                //İkinci Akitiviteye gidiecek
                intent.putExtra("post_id", post);
                intent.putExtra("id",ıd);
                activity.startActivity(intent);

            }
        });


        return convertView;
    }
}
