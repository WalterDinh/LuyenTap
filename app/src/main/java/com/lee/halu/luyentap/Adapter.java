package com.lee.halu.luyentap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    Context context;
    List<Model> models;

    public Adapter(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.item_list,null);
        TextView textView=view.findViewById(R.id.id);
        TextView textView1=view.findViewById(R.id.name);
        TextView textView2=view.findViewById(R.id.price);
        ImageView imageView=view.findViewById(R.id.img);

        textView.setText(models.get(position).id);
        textView1.setText(models.get(position).name);
       textView2.setText(""+models.get(position).price);
        imageView.setImageResource(R.drawable.de);
        return view;
    }
}
