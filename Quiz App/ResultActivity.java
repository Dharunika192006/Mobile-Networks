package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnReattempt, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tvResult);
        btnReattempt = findViewById(R.id.btnReattempt);
        btnExit = findViewById(R.id.btnExit);

        int score = getIntent().getIntExtra("score",0);
        int total = getIntent().getIntExtra("total",0);

        tvResult.setText("Your Score: " + score + " / " + total);

        if(score == total){
            new AlertDialog.Builder(this)
                    .setTitle("🎉 CONGRATULATIONS!")
                    .setMessage("You answered ALL questions correctly!\nYou are a Java Master!")
                    .setPositiveButton("Awesome!", null)
                    .show();
        }

        // REATTEMPT
        btnReattempt.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        // EXIT
        btnExit.setOnClickListener(v -> {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });
    }
}
