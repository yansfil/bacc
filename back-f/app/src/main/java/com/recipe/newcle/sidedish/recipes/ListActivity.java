package com.recipe.newcle.sidedish.recipes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.recipe.newcle.sidedish.R;
import com.recipe.newcle.sidedish.datas.ListItem;
import com.recipe.newcle.sidedish.manager.NetworkManager;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Request;

/**
 * Created by lee on 2016. 7. 6..
 */
public class ListActivity extends AppCompatActivity{
    private int type;
    RecyclerView recyclerView;
    Myadapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        Intent intent = getIntent();
        type = intent.getIntExtra("type",-1);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mAdapter = new Myadapter();
        mAdapter.setOnItemClickListener(new Myadapter.onItemClickListener() {
            @Override
            public <T> void onItemClick(View view, T result) {
                Intent intent = new Intent(getApplicationContext(),ListDetailActivity.class);
                intent.putExtra("uri",((ListItem)result).getUrl());
                startActivity(intent);
            }
        });



        mAdapter.setOnItemLongClickLitsener(new Myadapter.onItemLongClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                AlertDialog.Builder b = new AlertDialog.Builder(view.getContext());
                b.setTitle("백주부");
                String[] types = {"잘했어용", "크쿄쿄"};
                b.setItems(types, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                        switch(which){
                            case 0:
                                Toast.makeText(getApplicationContext(),"1번 클릭 +"+position +"번째 클릭",Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(getApplicationContext(),"2번 클릭 +"+position +"번째 클릭",Toast.LENGTH_LONG).show();
                                break;
                        }
                    }

                });
                b.show();
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getBaseContext(),3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public void onResume() {
        super.onResume();
        getData(type);
    }

    private void getData(int type){
        if(type == -1){
            return ;
        }
        NetworkManager.getInstance(getApplicationContext()).getList(type, new NetworkManager.OnResultListener<ArrayList<ListItem>>() {
            @Override
            public void onSuccess(Request request, ArrayList<ListItem> result) {
                mAdapter.clear();
                mAdapter.add((ArrayList<ListItem>)result);
                recyclerView.setAdapter(mAdapter);
                Log.e("SETADAPTER","OK");
            }

            @Override
            public void onFail(Request request, IOException exception) {
                Toast.makeText(getApplicationContext(),"exception :"+ exception,Toast.LENGTH_LONG).show();
            }
        });
    }
}
