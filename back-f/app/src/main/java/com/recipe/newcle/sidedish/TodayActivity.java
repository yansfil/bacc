package com.recipe.newcle.sidedish;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TodayActivity extends AppCompatActivity {
    int random_num;
    TextView textView;
    Button recipe_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        random_num = (int) Math.round(Math.random() * 89);
        textView = (TextView) findViewById(R.id.text_today);
        recipe_btn = (Button) findViewById(R.id.recipe_btn);
        CheckTypesTask task = new CheckTypesTask();
        task.execute();
    }


    private class CheckTypesTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog asyncDialog = new ProgressDialog(
                TodayActivity.this);

        @Override
        protected void onPreExecute() {
            asyncDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            asyncDialog.setMessage("오늘에 걸맞는 요리를 찾고있습니다!");

            // show dialog
            asyncDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                for (int i = 0; i < 100; i++) {
                    asyncDialog.setProgress(i);
                    Thread.sleep(30);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            asyncDialog.dismiss();
            String Name;
            final String uri;
            if (random_num < 18) {
                data data = new data();
                ArrayList<GridItem> data1 = data.getdata1();
                Name = data1.get(random_num).getName();
                uri = data1.get(random_num).getUrl();
            } else if (random_num < 50) {
                data data = new data();
                ArrayList<GridItem> data2 = data.getdata2();
                Name = data2.get(random_num-18).getName();
                uri = data2.get(random_num-18).getUrl();
            } else {
                data data = new data();
                ArrayList<GridItem> data3 = data.getdata3();
                Name ="백종원의 " + data3.get(random_num-50).getName();
                uri = data3.get(random_num-50).getUrl();
            }
            textView.setText(Name);
            recipe_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                    intent.putExtra("uri",uri);
                    startActivity(intent);
                }
            });





            super.onPostExecute(result);
        }
    }
}
