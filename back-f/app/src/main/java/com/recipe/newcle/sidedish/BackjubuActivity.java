package com.recipe.newcle.sidedish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class BackjubuActivity extends AppCompatActivity {
    private data datas;
    private ArrayList<GridItem> data3;
    private GridView list_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backjubu);
        datas = new data();
        data3 = datas.getdata3();
        list_back = (GridView) findViewById(R.id.list_back);
        GridviewAdapter listviewAdapter = new GridviewAdapter(getApplicationContext(),R.layout.row_girdview,data3);
        list_back.setAdapter(listviewAdapter);
        list_back.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getApplicationContext(),DetailActivity.class);
                it.putExtra("uri",data3.get(position).getUrl());
                startActivity(it);
            }
        });

    }
}
