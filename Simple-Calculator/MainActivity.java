package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
    }

    private boolean isInputValid() {
        if (num1.getText().toString().isEmpty() ||
                num2.getText().toString().isEmpty()) {

            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void add(View v) {
        if (!isInputValid()) return;

        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());

        result.setText("Addition Result = " + (a + b));
    }

    public void sub(View v) {
        if (!isInputValid()) return;

        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());

        result.setText("Subtraction Result = " + (a - b));
    }

    public void mul(View v) {
        if (!isInputValid()) return;   

        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());

        result.setText("Multiplication Result = " + (a * b));
    }

    public void div(View v) {
        if (!isInputValid()) return;

        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());

        if (b == 0) {
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            return;
        }

        result.setText("Division Result = " + (a / b));
    }

    public void clear(View v) {
        num1.setText("");
        num2.setText("");
        result.setText("Result cleared");
    }
}
