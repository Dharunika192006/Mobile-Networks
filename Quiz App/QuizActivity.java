package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    TextView tvQuestion, tvTimer;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4;
    Button btnNext;

    int currentQuestion = 0;
    int score = 0;

    String[] questions = {
            "Which keyword is used to inherit a class in Java?",
            "Which method is entry point of Java?",
            "Which keyword is used to create object?",
            "Which of these is not primitive type?",
            "Which package contains Scanner class?",
            "Which loop executes at least once?",
            "Which keyword is used for abstraction?",
            "Which symbol is used for comments?",
            "Which exception is unchecked?",
            "Which operator is used for comparison?"
    };

    String[][] options = {
            {"implements", "extends", "import", "this"},
            {"start()", "main()", "run()", "init()"},
            {"new", "create", "make", "object"},
            {"int", "float", "String", "double"},
            {"java.io", "java.util", "java.lang", "java.net"},
            {"for", "while", "do-while", "switch"},
            {"abstract", "final", "static", "private"},
            {"//", "/* */", "#", "<!-- -->"},
            {"IOException", "NullPointerException", "SQLException", "FileNotFoundException"},
            {"=", "==", "!=", "&&"}
    };

    int[] correctAnswers = {1,1,0,2,1,2,0,0,1,1};

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvTimer = findViewById(R.id.tvTimer);
        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        btnNext = findViewById(R.id.btnNext);

        loadQuestion();
        startTimer();

        btnNext.setOnClickListener(v -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) return;

            RadioButton selected = findViewById(selectedId);
            int selectedIndex = radioGroup.indexOfChild(selected);

            if (selectedIndex == correctAnswers[currentQuestion]) {
                score++;   // 🔥 THIS LINE IS IMPORTANT
            }

            currentQuestion++;

            if (currentQuestion < questions.length) {
                loadQuestion();
                radioGroup.clearCheck();
            } else {
                timer.cancel();
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questions.length);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadQuestion() {
        tvQuestion.setText(questions[currentQuestion]);
        rb1.setText(options[currentQuestion][0]);
        rb2.setText(options[currentQuestion][1]);
        rb3.setText(options[currentQuestion][2]);
        rb4.setText(options[currentQuestion][3]);
    }

    private void startTimer() {
        timer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Time Left: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questions.length);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}
