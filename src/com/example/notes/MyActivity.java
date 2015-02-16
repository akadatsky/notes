package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {

    public static final int REQUEST_CODE_GET_TEXT = 1;
    public static final int REQUEST_CODE_GET_IMAGE = 2;

    List<String> list = new ArrayList<String>();

    private LinearLayout listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = (LinearLayout) findViewById(R.id.listView);

        ImageView imagePlus = (ImageView) findViewById(R.id.imagePlus);
        imagePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, DetailsActivity.class);
                intent.putExtra("list_size", list.size());
                startActivityForResult(intent, REQUEST_CODE_GET_TEXT);
            }
        });

        Button sort = (Button) findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO choose sort
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_GET_TEXT){
            list.add(data.getStringExtra("text"));
            Log.i("MyTag", "Result: " + data.getStringExtra("text"));
            refreshList();
        }
    }

    private void refreshList() {
        listView.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            TextView text = new TextView(this);
            text.setText(list.get(i));
            listView.addView(text);
        }
    }
}
