package com.aan.app2smallproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2Nilaiakhir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_nilaiakhir);

        final EditText editNilai = (EditText) findViewById(R.id.edit_nilai);
        final TextView textNilai = (TextView) findViewById(R.id.text_nilai);

        editNilai.addTextChangedListener(new TextWatcher() {
            String before;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editNilai.getText().toString().trim().length()>0) {
                    before = editNilai.getText().toString();
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editNilai.getText().toString().trim().length()>0) {
                    double nilai = Double.parseDouble(editNilai.getText().toString());
                    if (nilai > 4) {
                        Toast.makeText(Activity2Nilaiakhir.this, "Nilai Max 4", Toast.LENGTH_SHORT).show();
                        editNilai.setText(before);
                        editNilai.setSelection(editNilai.getText().length());
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editNilai.getText().toString().trim().length()>0) {
                    double nilai = Double.parseDouble(editNilai.getText().toString());
                    String huruf;
                    if (nilai < 1) {
                        huruf = "E";
                    } else if (nilai < 2 ) {
                        huruf = "D";
                    } else if (nilai < 2.33 ) {
                        huruf = "C";
                    } else if (nilai < 2.67 ) {
                        huruf = "C+";
                    } else if (nilai < 3 ) {
                        huruf = "B-";
                    } else if (nilai < 3.33) {
                        huruf = "B";
                    } else if (nilai < 3.67) {
                        huruf = "B+";
                    } else if (nilai < 4) {
                        huruf = "A-";
                    } else {
                        huruf = "A";
                    }
                    textNilai.setText(huruf);
                }
                else {
                    textNilai.setText("");
                }
            }
        });
    }
}