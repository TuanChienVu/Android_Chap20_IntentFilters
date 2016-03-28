package com.vutuanchien.android_chap20_intentfilters;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendEmail(View view) {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("message/rfc822");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jbtuanchien.11@gmail.com"});
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Intent Filters Demo");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is Vu Tuan Chien, long time no see...");
        startActivity(Intent.createChooser(sendIntent, "Choose mail app..."));
    }

    public void makePhoneCall(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("123456789"));
        PackageManager packageManager = getPackageManager();
        ComponentName componentName = callIntent.resolveActivity(packageManager);
        if (componentName != null) {
            startActivity(callIntent);
        } else {
            Toast.makeText(MainActivity.this, "No activity available for request", Toast.LENGTH_SHORT).show();
        }
    }

}
