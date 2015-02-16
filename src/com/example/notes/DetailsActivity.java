package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

public class DetailsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        TextView header = (TextView) findViewById(R.id.header);
        String listSize = String.valueOf(getIntent().getExtras().getInt("list_size", 0));
        header.setText(getString(R.string.item_number) + listSize);

        final EditText text = (EditText) findViewById(R.id.text);

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("text", text.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
