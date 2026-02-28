package com.example.implicitbrowser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button browserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browserButton = findViewById(R.id.btnBrowser);

        browserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Implicit Intent to open browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);

                // Website URL
                browserIntent.setData(Uri.parse("https://www.google.com"));

                // Start browser
                startActivity(browserIntent);
            }
        });
    }
}
