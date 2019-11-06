package com.e_monsite.nazim_app.binazim;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends Activity {

Button convert=null,arithmetic=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView adView;

        MobileAds.initialize(this, "ca-app-pub-2561306222851578~6051922448");

        adView=(AdView)findViewById(R.id.ad_view);


        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        convert=(Button)findViewById(R.id.conversion);
        arithmetic=(Button)findViewById(R.id.arith);

           convert.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   startActivity(new Intent(MainActivity.this,Beta.class));
               }
           });

        arithmetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Arithmetic.class));
            }
        });

       FloatingActionButton fb=(FloatingActionButton)findViewById(R.id.fab);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("market://details?id=com.e_monsite.nazim_app.binazim"));
                if (!MyStartActivity(intent)) {

                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.e_monsite.nazim_app.binazim"));
                    if (!MyStartActivity(intent)) {

                        Toast.makeText(MainActivity.this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    private boolean MyStartActivity(Intent aIntent) {
        try
        {
            startActivity(aIntent);
            return true;
        }
        catch (ActivityNotFoundException e)
        {
            return false;
        }
    }

}
