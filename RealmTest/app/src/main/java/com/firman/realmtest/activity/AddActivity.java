package com.firman.realmtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firman.realmtest.R;
import com.firman.realmtest.helper.RealmHelper;

/**
 * Created by Firman on 9/24/2016.
 */

public class AddActivity extends AppCompatActivity {

    private RealmHelper realmHelper;
    private EditText inputDescription;
    private EditText inputTitle;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        realmHelper = new RealmHelper(this);

        inputTitle = (EditText) findViewById(R.id.inputTitle);
        inputDescription = (EditText) findViewById(R.id.inputDescription);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, description;
                title = inputTitle.getText().toString();
                description = inputDescription.getText().toString();
                realmHelper.addArticle(title, description);

            }
        });
    }
}
