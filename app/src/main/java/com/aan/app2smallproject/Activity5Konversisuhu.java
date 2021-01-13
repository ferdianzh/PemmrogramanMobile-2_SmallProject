package com.aan.app2smallproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity5Konversisuhu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5_konversisuhu);

        final Spinner spinSuhu1 = (Spinner) findViewById(R.id.spin_suhu1);
        final Spinner spinSuhu2 = (Spinner) findViewById(R.id.spin_suhu2);
        final EditText editSuhu1 = (EditText) findViewById(R.id.edit_suhu1);
        final TextView textSuhu2 = (TextView) findViewById(R.id.text_suhu2);

        spinSuhu1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editSuhu1.setText("");
                textSuhu2.setText("");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinSuhu2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editSuhu1.setText("");
                textSuhu2.setText("");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        editSuhu1.addTextChangedListener(new TextWatcher() {
            String before;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editSuhu1.getText().toString().trim().length()>0) {
                    before = editSuhu1.getText().toString();
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editSuhu1.getText().toString().trim().length()>0) {
                    if (editSuhu1.getText().toString().trim().length() > 3) {
                        Toast.makeText(Activity5Konversisuhu.this, "Panjang max 3", Toast.LENGTH_SHORT).show();
                        editSuhu1.setText(before);
                        editSuhu1.setSelection(editSuhu1.getText().length());
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editSuhu1.getText().toString().trim().length()>0) {
                    String unitSuhu1 = spinSuhu1.getSelectedItem().toString();
                    String unitSuhu2 = spinSuhu2.getSelectedItem().toString();
                    double suhu1 = Double.parseDouble(editSuhu1.getText().toString());
                    String hasil="";
                    if (unitSuhu1.equals("Celcius"))
                        hasil = konvCelcius(suhu1, unitSuhu2);
                    else if (unitSuhu1.equals("Fahrenheit"))
                        hasil = konvFahrenheit(suhu1, unitSuhu2);
                    else if (unitSuhu1.equals("Kelvin"))
                        hasil = konvFahrenheit(suhu1, unitSuhu2);
                    textSuhu2.setText(hasil);
                }
                else {
                    textSuhu2.setText("");
                }
            }
        });

    }

    private String konvCelcius (double suhu, String unitHasil) {
        double hasil=0;
        if (unitHasil.equals("Celcius"))
            hasil = suhu;
        else if (unitHasil.equals("Fahrenheit"))
            hasil = (1.8*suhu)+32;
        else if (unitHasil.equals("Kelvin"))
            hasil = suhu+273;
        return String.format("%.2f", hasil);
    }
    private String konvFahrenheit (double suhu, String unitHasil) {
        double hasil=0;
        if (unitHasil.equals("Celcius"))
            hasil = (suhu-32)*0.55;
        else if (unitHasil.equals("Fahrenheit"))
            hasil = suhu;
        else if (unitHasil.equals("Kelvin"))
            hasil = (suhu-32)*0.55 + 273.15;
        return String.format("%.2f", hasil);
    }
    private String konvKelvin (double suhu, String unitHasil) {
        double hasil=0;
        if (unitHasil.equals("Celcius"))
            hasil = suhu-273.15;
        else if (unitHasil.equals("Fahrenheit"))
            hasil = (suhu-273.15)*1.8 + 32;
        else if (unitHasil.equals("Kelvin"))
            hasil = suhu;
        return String.format("%.2f", hasil);
    }

}