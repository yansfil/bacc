package com.recipe.newcle.sidedish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    data data;
    GridView gridview;
    ArrayList<GridItem> Ndata;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        data = new data();
        ArrayList<GridItem> data1 = data.getdata1();
        ArrayList<GridItem> data2 = data.getdata2();
        ArrayList<GridItem> data3 = data.getdata3();
        Ndata = new ArrayList<>();
        Intent intent = getIntent();
        String name = intent.getStringExtra("val");
        gridview = (GridView) findViewById(R.id.list_total);
        textview = (TextView) findViewById(R.id.nothing);



        for(int i =0; i<18; i++){
            String namer = data1.get(i).getName().toString();
            if(namer.contains(name)) {
                Ndata.add(data1.get(i));
            }
        }
        for(int i =0; i<32; i++){
            if(data2.get(i).getName().contains(name))
                Ndata.add(data2.get(i));
        }
        for(int i =0; i<39; i++){
            if(data3.get(i).getName().contains(name))
                Ndata.add(data3.get(i));
        }
        if(Ndata.isEmpty()){
            textview.setText("찾으시는 요리가 없습니다ㅠㅠ");
        }
        GridviewAdapter gridviewAdapter = new GridviewAdapter(getApplicationContext(),R.layout.view_griditem,Ndata);
        gridview.setAdapter(gridviewAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getApplicationContext(), DetailActivity.class);
                it.putExtra("uri", Ndata.get(position).getUrl());
                startActivity(it);
            }
        });


    }
}
