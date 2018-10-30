package com.lee.halu.luyentap;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText edtId;
    private TextInputEditText edtName;
    private TextInputEditText edtPrice;
    private Button btnthem;
    private Button btnUpdate;
    private ListView list;
    Dao dao;
    List<Model> models = new ArrayList<>();
    Adapter adapter;
    String id, name;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        dao = new Dao(this);
        models = dao.getModelAll();
        adapter = new Adapter(MainActivity.this, models);
        list.setAdapter(adapter);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = edtId.getText().toString();
                name = edtName.getText().toString();
                price= Integer.parseInt(edtPrice.getText().toString());
                dao.insertModel(id, name, price);
                adapter.notifyDataSetChanged();
                notifydata();
                Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dao.deleteMolde(models.get(position).getId());
                adapter.notifyDataSetChanged();
                notifydata();
                Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        edtId.setText(models.get(position).getId());
        edtName.setText(models.get(position).getName());

    }
});
btnUpdate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         id= edtId.getText().toString();
        name = edtName.getText().toString();
        price= Integer.parseInt(edtPrice.getText().toString());
        dao.updateModel(id,name,price);
        adapter.notifyDataSetChanged();
        notifydata();
    }
});

    }
    public void init() {
        edtId = (TextInputEditText) findViewById(R.id.edt_id);
        edtName = (TextInputEditText) findViewById(R.id.edt_name);
        edtPrice = (TextInputEditText) findViewById(R.id.edt_price);
        btnthem = (Button) findViewById(R.id.btnthem);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        list = (ListView) findViewById(R.id.list);

    }
    public void notifydata() {
        models = dao.getModelAll();
        adapter = new Adapter(MainActivity.this, models);
        list.setAdapter(adapter);
    }
}
