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

public class Activity4Bangunruang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_bangunruang);

        final Spinner spinBangun = (Spinner) findViewById(R.id.spin_bangunruang);
        final EditText editPanjang1 = (EditText) findViewById(R.id.edit_pjg1);
        final EditText editPanjang2 = (EditText) findViewById(R.id.edit_pjg2);
        final EditText editPanjang3 = (EditText) findViewById(R.id.edit_pjg3);
        final Button btnHitung = (Button) findViewById(R.id.btn_htng);
        final TextView textVolume = (TextView) findViewById(R.id.text_volume);

        spinBangun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String bangun = spinBangun.getSelectedItem().toString();
                if (bangun.equals("Balok")) {
                    editPanjang1.setVisibility(View.VISIBLE);
                    editPanjang2.setVisibility(View.VISIBLE);
                    editPanjang3.setVisibility(View.VISIBLE);
                    editPanjang1.setHint("Panjang");
                    editPanjang2.setHint("Lebar");
                    editPanjang3.setHint("Tinggi");
                    editPanjang1.getText().clear();
                    editPanjang2.getText().clear();
                    editPanjang3.getText().clear();
                    textVolume.setText("");
                } else if (bangun.equals("Tabung")) {
                    editPanjang1.setVisibility(View.VISIBLE);
                    editPanjang2.setVisibility(View.VISIBLE);
                    editPanjang3.setVisibility(View.INVISIBLE);
                    editPanjang1.setHint("Jari-jari");
                    editPanjang2.setHint("Tinggi");
                    editPanjang1.getText().clear();
                    editPanjang2.getText().clear();
                    editPanjang3.setText("0");
                    textVolume.setText("");
                } else if (bangun.equals("Bola")) {
                    editPanjang1.setVisibility(View.VISIBLE);
                    editPanjang2.setVisibility(View.GONE);
                    editPanjang3.setVisibility(View.GONE);
                    editPanjang1.setHint("Jari-jari");
                    editPanjang1.getText().clear();
                    editPanjang2.setText("0");
                    editPanjang3.setText("0");
                    textVolume.setText("");
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
                        Toast.makeText(Activity4Bangunruang.this, "Panjang max 4", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(Activity4Bangunruang.this, "Panjang max 4", Toast.LENGTH_SHORT).show();
                        editPanjang2.setText(before);
                        editPanjang2.setSelection(editPanjang2.getText().length());
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        editPanjang3.addTextChangedListener(new TextWatcher() {
            String before;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editPanjang3.getText().toString().trim().length()>0) {
                    before = editPanjang3.getText().toString();
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editPanjang3.getText().toString().trim().length()>0) {
                    if (editPanjang3.getText().toString().trim().length() > 4) {
                        Toast.makeText(Activity4Bangunruang.this, "Panjang max 4", Toast.LENGTH_SHORT).show();
                        editPanjang3.setText(before);
                        editPanjang3.setSelection(editPanjang3.getText().length());
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
                        editPanjang2.getText().toString().trim().length()>0 &&
                        editPanjang3.getText().toString().trim().length()>0 ) {
                    String bangun = spinBangun.getSelectedItem().toString();
                    double panjang1, panjang2, panjang3;
                    String hasil="";
                    panjang1 = Double.parseDouble(editPanjang1.getText().toString());
                    panjang2 = Double.parseDouble(editPanjang2.getText().toString());
                    panjang3 = Double.parseDouble(editPanjang3.getText().toString());

                    if (bangun.equals("Balok")) {
                        hasil = volumeBalok(panjang1, panjang2, panjang3);
                    } else if (bangun.equals("Tabung")) {
                        hasil = volumeTabung(panjang1, panjang2);
                    } else if (bangun.equals("Bola")) {
                        hasil = volumeBola(panjang1);
                    }
                    textVolume.setText(hasil);
                } else {
                    textVolume.setText("");
                }
            }
        });

    }

    private String volumeBalok (double panjang, double lebar, double tinggi) {
        return String.format("%.2f", (panjang*lebar*tinggi));
    }
    private String volumeTabung (double jari, double tinggi) {
        return String.format("%.2f", ((Math.PI*jari*jari)*tinggi));
    }
    private String volumeBola (double jari) {
        return String.format("%.2f", (Math.PI*jari*jari*jari));
    }

}