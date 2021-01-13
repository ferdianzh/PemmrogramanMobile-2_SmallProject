package com.aan.app2smallproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3Bangundatar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_bangundatar);

        final Spinner spinBangun = (Spinner) findViewById(R.id.spin_bangundatar);
        final EditText editPanjang1 = (EditText) findViewById(R.id.edit_panjang1);
        final EditText editPanjang2 = (EditText) findViewById(R.id.edit_panjang2);
        final Button btnHitung = (Button) findViewById(R.id.btn_hitung);
        final TextView textLuas = (TextView) findViewById(R.id.text_luas);

        spinBangun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String bangun = spinBangun.getSelectedItem().toString();
                if (bangun.equals("Persegi")) {
                    editPanjang1.setVisibility(View.VISIBLE);
                    editPanjang2.setVisibility(View.VISIBLE);
                    editPanjang1.setHint("Panjang");
                    editPanjang2.setHint("Lebar");
                    editPanjang1.getText().clear();
                    editPanjang2.getText().clear();
                    textLuas.setText("");
                } else if (bangun.equals("Segitiga")) {
                    editPanjang1.setVisibility(View.VISIBLE);
                    editPanjang2.setVisibility(View.VISIBLE);
                    editPanjang1.setHint("Alas");
                    editPanjang2.setHint("Tinggi");
                    editPanjang1.getText().clear();
                    editPanjang2.getText().clear();
                    textLuas.setText("");
                } else if (bangun.equals("Lingkaran")) {
                    editPanjang1.setVisibility(View.VISIBLE);
                    editPanjang2.setVisibility(View.GONE);
                    editPanjang1.setHint("Jari-jari");
                    editPanjang1.getText().clear();
                    editPanjang2.setText("0");
                    textLuas.setText("");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        editPanjang1.addTextChangedListener(new TextWatcher() {
            String before;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editPanjang1.getText().toString().trim().length()>0) {
                    before = editPanjang1.getText().toString();
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editPanjang1.getText().toString().trim().length()>0) {
                    if (editPanjang1.getText().toString().trim().length() > 4) {
                        Toast.makeText(Activity3Bangundatar.this, "Panjang max 4", Toast.LENGTH_SHORT).show();
                        editPanjang1.setText(before);
                        editPanjang1.setSelection(editPanjang1.getText().length());
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        editPanjang2.addTextChangedListener(new TextWatcher() {
            String before;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editPanjang2.getText().toString().trim().length()>0) {
                    before = editPanjang2.getText().toString();
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editPanjang2.getText().toString().trim().length()>0) {
                    if (editPanjang2.getText().toString().trim().length() > 4) {
                        Toast.makeText(Activity3Bangundatar.this, "Panjang max 4", Toast.LENGTH_SHORT).show();
                        editPanjang2.setText(before);
                        editPanjang2.setSelection(editPanjang2.getText().length());
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editPanjang1.getText().toString().trim().length()>0 &&
                        editPanjang2.getText().toString().trim().length()>0) {
                    String bangun = spinBangun.getSelectedItem().toString();
                    double panjang1, panjang2;
                    String hasil="";
                    panjang1 = Double.parseDouble(editPanjang1.getText().toString());
                    panjang2 = Double.parseDouble(editPanjang2.getText().toString());

                    if (bangun.equals("Persegi")) {
                        hasil = luasPersegi(panjang1, panjang2);
                    } else if (bangun.equals("Segitiga")) {
                        hasil = luasSegitiga(panjang1, panjang2);
                    } else if (bangun.equals("Lingkaran")) {
                        hasil = luasLingkaran(panjang1);
                    }
                    textLuas.setText(hasil);
                } else {
                    textLuas.setText("");
                }
            }
        });

    }

    private String luasPersegi (double panjang, double lebar) {
        return String.format("%.2f", (panjang*lebar));
    }
    private String luasSegitiga (double alas, double tinggi) {
        return String.format("%.2f", (0.5*alas*tinggi));
    }
    private String luasLingkaran (double jari) {
        return String.format("%.2f", (Math.PI*jari*jari));
    }
}