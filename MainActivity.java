package com.example.akpinar.odev1;

import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.text.Editable;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SIRALA(View view) {
        EditText etAd =(EditText) findViewById(R.id.etAd);
        EditText etSoyad =(EditText) findViewById(R.id.etSoyad);
        TextView tvSonuc =(TextView) findViewById(R.id.tvSonuc);

        String ad=etAd.getText().toString().trim().toLowerCase();
        while (ad != ad.replace("  ", " ") ) {
            ad = ad.replace("  ", " ");
        }
        String soyad=etSoyad.getText().toString().trim().toUpperCase();
        String[] sıra;

        if(!ad.isEmpty()&&!soyad.isEmpty())
        {
            if (ad.indexOf(" ")>0)
            {
                sıra =ad.split(" ");
                String temp;
                for (int i=1; i<sıra.length; i++)
                {
                    for(int j=0; j<sıra.length-i; j++)
                    {
                        if (sıra[j].toString().compareTo(sıra[j+1].toString())>0)
                        {
                            temp = sıra[j];
                            sıra[j] = sıra [j+1];
                            sıra[j+1] = temp;
                        }
                    }
                }

                ad=sıra[0].substring(0,1).toUpperCase() + sıra[0].substring(1,sıra[0].length()) ;
                for (int i=1; i<sıra.length; i++) {
                    sıra[i] = sıra[i].substring(0,1).toUpperCase()+".";

                    ad=ad+" "+sıra[i].toString();
                }
                tvSonuc.setText(ad+" "+soyad);
            }

        }
    }
}
