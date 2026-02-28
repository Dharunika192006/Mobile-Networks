package com.example.menusstudstaff;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView title, details;
    LinearLayout studentLayout, staffLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        details = findViewById(R.id.details);
        studentLayout = findViewById(R.id.studentLayout);
        staffLayout = findViewById(R.id.staffLayout);
    }

    // Show Students
    public void showStudents(View v) {
        title.setText("Students List");
        studentLayout.setVisibility(View.VISIBLE);
        staffLayout.setVisibility(View.GONE);
        details.setText("Click a student to view details");
    }

    // Show Staff Advisors
    public void showStaff(View v) {
        title.setText("Staff Advisors");
        staffLayout.setVisibility(View.VISIBLE);
        studentLayout.setVisibility(View.GONE);
        details.setText("Click a staff advisor to view details");
    }

    // Student Details
    public void studentArun(View v) {
        details.setText(
                "Name: Arun\n" +
                        "Department: IT\n" +
                        "Year: 3rd Year\n" +
                        "Advisor: Dr. Kumar"
        );
    }

    public void studentDivya(View v) {
        details.setText(
                "Name: Divya\n" +
                        "Department: IT\n" +
                        "Year: 2nd Year\n" +
                        "Advisor: Dr. Meena"
        );
    }

    // Staff Details
    public void staffKumar(View v) {
        details.setText(
                "Name: Dr. Kumar\n" +
                        "Designation: Staff Advisor\n\n" +
                        "Students:\n• Arun\n• Bala\n• Charan"
        );
    }

    public void staffMeena(View v) {
        details.setText(
                "Name: Dr. Meena\n" +
                        "Designation: Staff Advisor\n\n" +
                        "Students:\n• Divya\n• Ezhil"
        );
    }
}
