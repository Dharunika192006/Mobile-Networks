package com.example.feedbackapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    RatingBar ratingBar;
    EditText edtMessage;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ratingBar = findViewById(R.id.ratingBar);
        edtMessage = findViewById(R.id.edtMessage);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            float rating = ratingBar.getRating();

            if (rating == 0) {
                Toast.makeText(this, "Please give a rating", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(FeedbackActivity.this, ThankYouActivity.class);
            intent.putExtra("rating", rating);
            startActivity(intent);
            finish();
        });
    }
}
