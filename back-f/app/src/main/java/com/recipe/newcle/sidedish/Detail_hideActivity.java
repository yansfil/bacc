package com.recipe.newcle.sidedish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail_hideActivity extends AppCompatActivity {
    ImageView picture;
    TextView prepare_text;
    TextView url_text;
    TextView oreder_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hide);
        picture = (ImageView) findViewById(R.id.picture);
        prepare_text = (TextView) findViewById(R.id.text_prepare);
        url_text = (TextView) findViewById(R.id.text_url);
        oreder_text = (TextView) findViewById(R.id.text_order);
    }
}
