package com.example.knportal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * COURSES SCREEN.
 * Displays a simple ListView of demonstration course names for this
 * practical assessment. A plain ListView + ArrayAdapter is used here
 * instead of a RecyclerView because it is easier for a beginner to
 * understand and explain.
 */
public class CoursesActivity extends AppCompatActivity {

    // DEMONSTRATION course data only - not an official/verified course list.
    private final String[] courses = {
            "Diploma in ICT",
            "Diploma in Business Management",
            "Diploma in Accountancy",
            "Diploma in Electrical Engineering",
            "Diploma in Building Technology"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ListView lvCourses = findViewById(R.id.lvCourses);

        // ArrayAdapter connects our String array to the ListView.
        // android.R.layout.simple_list_item_1 is a built-in Android layout
        // that draws one line of text per row - no custom XML needed.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                courses);

        lvCourses.setAdapter(adapter);
    }
}
