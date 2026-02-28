package com.example.agecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView txtAge, txtYearWise;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🔹 Proper initialization
        datePicker = findViewById(R.id.datePicker);
        txtAge = findViewById(R.id.txtAge);
        txtYearWise = findViewById(R.id.txtYearWise);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> calculateAge());
    }

    private void calculateAge() {

        int birthDay = datePicker.getDayOfMonth();
        int birthMonth = datePicker.getMonth();
        int birthYear = datePicker.getYear();

        Calendar today = Calendar.getInstance();

        int currentDay = today.get(Calendar.DAY_OF_MONTH);
        int currentMonth = today.get(Calendar.MONTH);
        int currentYear = today.get(Calendar.YEAR);

        int age = currentYear - birthYear;

        if (currentMonth < birthMonth ||
                (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }

        txtAge.setText(" Your Current Age: " + age + " years");

        StringBuilder builder = new StringBuilder();
        builder.append(" Your Age Journey:\n\n");

        for (int year = birthYear; year <= currentYear; year++) {
            builder.append(year)
                    .append(" → ")
                    .append(year - birthYear)
                    .append(" years old\n");
        }

        txtYearWise.setText(builder.toString());
    }
}
