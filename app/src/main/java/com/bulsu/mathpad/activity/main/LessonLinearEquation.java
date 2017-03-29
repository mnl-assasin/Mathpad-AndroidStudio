package com.bulsu.mathpad.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.lesson.linearequation.LinearEquationActivity;
import com.bulsu.mathpad.activity.lesson.linearequation.WordProblemActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LessonLinearEquation extends AppCompatActivity {

    @Bind(R.id.btnSystemLinear)
    Button btnSystemLinear;

    @Bind(R.id.btnWordProblems)
    Button btnWordProblems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_linear_equation);
        ButterKnife.bind(this);

        setTitle("System of Linear Equation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick({ R.id.btnSystemLinear, R.id.btnWordProblems})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnSystemLinear:
                startActivity(new Intent(getApplicationContext(), LinearEquationActivity.class));
                break;

            case R.id.btnWordProblems:
                startActivity(new Intent(getApplicationContext(), WordProblemActivity.class));
                break;
        }
    }
}
