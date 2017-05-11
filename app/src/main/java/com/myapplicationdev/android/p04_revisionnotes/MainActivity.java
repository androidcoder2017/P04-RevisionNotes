package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShow;
    EditText etNote;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnShow = (Button)findViewById(R.id.buttonShowList);
        etNote = (EditText) findViewById(R.id.editTextNote);

        rg = (RadioGroup) findViewById(R.id.radioGroupStars);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectedRadioId);

                DBHelper db = new DBHelper(MainActivity.this);

                // get the text written from the EditTextNote
                String noteContent = etNote.getText().toString();
                // get the radio button selected and convert it to an Integer in a form of a String
                // that can be read
                int rbSelected = Integer.parseInt(rb.getText().toString());

                // insert the note
                db.insertNote(noteContent, rbSelected);

                Toast.makeText(MainActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                db.close();

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
