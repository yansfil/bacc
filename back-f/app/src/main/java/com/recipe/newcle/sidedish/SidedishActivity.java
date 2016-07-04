package com.recipe.newcle.sidedish;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TabHost;

import java.util.ArrayList;

public class SidedishActivity extends TabActivity {
    private TabHost mTabHost;
    private data datas;
    private ArrayList<GridItem> data1;
    private ArrayList<GridItem> data2;
    private GridView list_simple;
    private GridView list_tasty;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidedish);
        list_simple = (GridView) findViewById(R.id.list_simple);
        list_tasty = (GridView) findViewById(R.id.list_tasty);
        mTabHost = getTabHost();
        datas = new data();
        data1 = datas.getdata1();
        data2 = datas.getdata2();
        GridviewAdapter listviewAdapter = new GridviewAdapter(getApplicationContext(),R.layout.row_girdview,data1);
        GridviewAdapter listviewAdapter2 = new GridviewAdapter(getApplicationContext(),R.layout.row_girdview,data2);

        // 탭 1, 2, 3 을 추가하면서 태그를 달아주고, 제목(또는 아이콘)을 설정한다.
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setContent(R.id.tab1).setIndicator(getString(R.string.tab1)));
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setContent(R.id.tab2).setIndicator(getString(R.string.tab2)));

        list_simple.setAdapter(listviewAdapter);
        list_simple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String uri = data1.get(position).getUrl();
                Intent it = new Intent(getApplicationContext(),DetailActivity.class);
                it.putExtra("uri",uri);
                startActivity(it);
            }
        });
        list_tasty.setAdapter(listviewAdapter2);
        list_tasty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String uri = data2.get(position).getUrl();
                Intent it = new Intent(getApplicationContext(),DetailActivity.class);
                it.putExtra("uri",uri);
                startActivity(it);
            }
        });


    }



}