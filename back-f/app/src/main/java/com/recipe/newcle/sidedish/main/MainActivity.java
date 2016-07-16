package com.recipe.newcle.sidedish.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.recipe.newcle.sidedish.R;
import com.recipe.newcle.sidedish.SearchActivity;
import com.recipe.newcle.sidedish.TodayActivity;
import com.recipe.newcle.sidedish.recipes.RecipesActivity;

public class MainActivity extends AppCompatActivity {


    private AlertDialog alert;
    private Button recipe_btn;
    private Button today_btn;
    private Button search_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        recipe_btn = (Button) findViewById(R.id.recipes_btn);
        today_btn = (Button) findViewById(R.id.today_btn);
        search_btn = (Button) findViewById(R.id.search_btn);

        recipe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), RecipesActivity.class);
                startActivity(intent1);
            }
        });

        today_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TodayActivity.class);
                startActivity(intent);
            }
        });
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle("반찬 검색!!!");
                alert.setMessage("입력");

                // Set an EditText view to get user input
                final EditText input = new EditText(MainActivity.this);
                alert.setView(input);

                alert.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.cancel();
                            }
                        });

                alert.setPositiveButton("찾기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = input.getText().toString();
                        Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
                        intent.putExtra("val",value);
                        startActivity(intent);
                    }
                });

                alert.create();
                alert.show();

            }
        });

    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setMessage("앱을 종료하시겠습니까?").setCancelable(
                false).setPositiveButton("네",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                }).setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        alert = alt_bld.create();
        alert.setTitle("주의");
        alert.show();
    }



}
