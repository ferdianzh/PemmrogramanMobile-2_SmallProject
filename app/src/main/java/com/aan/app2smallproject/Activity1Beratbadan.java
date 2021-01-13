package com.aan.app2smallproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1Beratbadan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_beratbadan);

        final EditText editTinggi = (EditText) findViewById(R.id.edit_tinggi);
        final TextView textBerat = (TextView) findViewById(R.id.text_berat);

        editTinggi.addTextChangedListener(new TextWatcher() {
            String before;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editTinggi.getText().toString().trim().length()>0) {
                    before = editTinggi.getText().toString();
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editTinggi.getText().toString().trim().length()>0) {
                    int tinggi = Integer.parseInt(editTinggi.getText().toString());
                    if (tinggi > 300) {
                        Toast.makeText(Activity1Beratbadan.this, "Tinggi Max 300", Toast.LENGTH_SHORT).show();
                        editTinggi.setText(before);
                        editTinggi.setSelection(editTinggi.getText().length());
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editTinggi.getText().toString().trim().length()>0) {
                    int tinggi = Integer.parseInt(editTinggi.getText().toString());
                    int berat = (int) ((tinggi-100) - ((tinggi-100)*0.1));
                    textBerat.setText(Integer.toString(berat));
                }
                else {
                    textBerat.setText("");
                }
            }
        });
    }

}