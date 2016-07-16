package com.recipe.newcle.sidedish.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.recipe.newcle.sidedish.R;

/**
 * Created by hoyun on 2016-06-23.
 */
public class RecipesActivity extends AppCompatActivity implements View.OnClickListener{

    private Button dishes;
    private Button cooks;
    private Button back_dishes;
    private Button back_cooks;
    private Button onself_foods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        dishes = (Button)findViewById(R.id.dishes);
        cooks = (Button)findViewById(R.id.cooks);
        back_dishes = (Button)findViewById(R.id.back_dishes);
        back_cooks = (Button)findViewById(R.id.back_cooks);
        onself_foods = (Button)findViewById(R.id.oneself_cooks);
        dishes.setOnClickListener(this);
        cooks.setOnClickListener(this);
        back_dishes.setOnClickListener(this);
        back_cooks.setOnClickListener(this);
        onself_foods.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,ListActivity.class) ;
        switch(v.getId()){
            case R.id.dishes:
                intent.putExtra("type",1);
                break;
            case R.id.cooks:
                intent.putExtra("type",2);
                break;
            case R.id.back_dishes:
                intent.putExtra("type",3);
                break;
            case R.id.back_cooks:
                intent.putExtra("type",4);
                break;
            case R.id.oneself_cooks:
                intent.putExtra("type",5);
                break;
        }
        startActivity(intent);
    }
}
