package com.example.feedbackapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThankYouActivity extends AppCompatActivity {

    TextView txtThanks;
    Button btnResubmit, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        txtThanks = findViewById(R.id.txtThanks);
        btnResubmit = findViewById(R.id.btnResubmit);
        btnExit = findViewById(R.id.btnExit);

        float rating = getIntent().getFloatExtra("rating", 0);

        if (rating == 5) {
            txtThanks.setText("🎉 Congratulations!\nYou loved our service!\n⭐⭐⭐⭐⭐");
        } else {
            txtThanks.setText(" Thank you for your feedback!\nWe will improve.");
        }

        // Re-Submit Feedback (Explicit Intent)
        btnResubmit.setOnClickListener(v -> {
            Intent intent = new Intent(ThankYouActivity.this, FeedbackActivity.class);
            startActivity(intent);
            finish();
        });

        // Exit App
        btnExit.setOnClickListener(v -> {
            finishAffinity(); // closes entire app
        });
    }
}
