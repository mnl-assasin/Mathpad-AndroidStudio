package com.bulsu.mathpad.activity.quiz;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bulsu.mathpad.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizDeterminants1Activity extends AppCompatActivity {

    @Bind(R.id.rb1a)
    RadioButton rb1a;
    @Bind(R.id.rb1b)
    RadioButton rb1b;
    @Bind(R.id.rb1c)
    RadioButton rb1c;
    @Bind(R.id.rb1d)
    RadioButton rb1d;
    @Bind(R.id.rb2a)
    RadioButton rb2a;
    @Bind(R.id.rb2b)
    RadioButton rb2b;
    @Bind(R.id.rb2c)
    RadioButton rb2c;
    @Bind(R.id.rb2d)
    RadioButton rb2d;
    @Bind(R.id.rb3a)
    RadioButton rb3a;
    @Bind(R.id.rb3b)
    RadioButton rb3b;
    @Bind(R.id.rb3c)
    RadioButton rb3c;
    @Bind(R.id.rb3d)
    RadioButton rb3d;
    @Bind(R.id.rb4a)
    RadioButton rb4a;
    @Bind(R.id.rb4b)
    RadioButton rb4b;
    @Bind(R.id.rb4c)
    RadioButton rb4c;
    @Bind(R.id.rb4d)
    RadioButton rb4d;
    @Bind(R.id.rb5a)
    RadioButton rb5a;
    @Bind(R.id.rb5b)
    RadioButton rb5b;
    @Bind(R.id.rb5c)
    RadioButton rb5c;
    @Bind(R.id.rb5d)
    RadioButton rb5d;
    @Bind(R.id.rb6a)
    RadioButton rb6a;
    @Bind(R.id.rb6b)
    RadioButton rb6b;
    @Bind(R.id.rb6c)
    RadioButton rb6c;
    @Bind(R.id.rb6d)
    RadioButton rb6d;
    @Bind(R.id.rb7a)
    RadioButton rb7a;
    @Bind(R.id.rb7b)
    RadioButton rb7b;
    @Bind(R.id.rb7c)
    RadioButton rb7c;
    @Bind(R.id.rb7d)
    RadioButton rb7d;
    @Bind(R.id.rb8a)
    RadioButton rb8a;
    @Bind(R.id.rb8b)
    RadioButton rb8b;
    @Bind(R.id.rb8c)
    RadioButton rb8c;
    @Bind(R.id.rb8d)
    RadioButton rb8d;
    @Bind(R.id.rb9a)
    RadioButton rb9a;
    @Bind(R.id.rb9b)
    RadioButton rb9b;
    @Bind(R.id.rb9c)
    RadioButton rb9c;
    @Bind(R.id.rb9d)
    RadioButton rb9d;
    @Bind(R.id.rb10a)
    RadioButton rb10a;
    @Bind(R.id.rb10b)
    RadioButton rb10b;
    @Bind(R.id.rb10c)
    RadioButton rb10c;
    @Bind(R.id.rb10d)
    RadioButton rb10d;
    @Bind(R.id.btnSubmit)
    Button btnSubmit;
    @Bind(R.id.activity_quiz_determinants1)
    LinearLayout activityQuizDeterminants1;
    @Bind(R.id.tvQuestion1)
    TextView tvQuestion1;
    @Bind(R.id.tvQuestion2)
    TextView tvQuestion2;
    @Bind(R.id.tvQuestion3)
    TextView tvQuestion3;
    @Bind(R.id.tvQuestion4)
    TextView tvQuestion4;
    @Bind(R.id.tvQuestion5)
    TextView tvQuestion5;
    @Bind(R.id.tvQuestion6)
    TextView tvQuestion6;
    @Bind(R.id.tvQuestion7)
    TextView tvQuestion7;
    @Bind(R.id.tvQuestion8)
    TextView tvQuestion8;
    @Bind(R.id.tvQuestion9)
    TextView tvQuestion9;
    @Bind(R.id.tvQuestion10)
    TextView tvQuestion10;


    @Bind(R.id.btnRetake)
    Button btnRetake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_determinants1);
        ButterKnife.bind(this);

        setTitle("Determinants");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onSubmitClick() {
        int score = 0;

        if (rb1a.isChecked())
            score++;

        if (rb2c.isChecked())
            score++;

        if (rb3b.isChecked())
            score++;

        if (rb4a.isChecked())
            score++;

        if (rb5d.isChecked())
            score++;

        if (rb6c.isChecked())
            score++;

        if (rb7d.isChecked())
            score++;

        if (rb8a.isChecked())
            score++;

        if (rb9d.isChecked())
            score++;

        if (rb10c.isChecked())
            score++;

        Log.d("score", "Total Score: " + score);
        displayScore(score);
        btnSubmit.setVisibility(View.GONE);
        btnRetake.setVisibility(View.VISIBLE);
    }

    private void displayScore(int score) {

        String message = "Your total score is " + score + "/ 10";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Total Score");
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("Review", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                review();
            }
        }).show();

    }

    private void review() {

        if (!rb1a.isChecked())
            tvQuestion1.setBackgroundColor(Color.RED);

        if (!rb2c.isChecked())
            tvQuestion2.setBackgroundColor(Color.RED);

        if (!rb3b.isChecked())
            tvQuestion3.setBackgroundColor(Color.RED);

        if (!rb4a.isChecked())
            tvQuestion4.setBackgroundColor(Color.RED);

        if (!rb5d.isChecked())
            tvQuestion5.setBackgroundColor(Color.RED);

        if (!rb6c.isChecked())
            tvQuestion6.setBackgroundColor(Color.RED);

        if (!rb7d.isChecked())
            tvQuestion7.setBackgroundColor(Color.RED);

        if (!rb8a.isChecked())
            tvQuestion8.setBackgroundColor(Color.RED);

        if (!rb9d.isChecked())
            tvQuestion9.setBackgroundColor(Color.RED);

        if (!rb10c.isChecked())
            tvQuestion10.setBackgroundColor(Color.RED);
    }

    private void retake() {

        rb1a.setChecked(false);
        rb1b.setChecked(false);
        rb1c.setChecked(false);
        rb1d.setChecked(false);

        rb2a.setChecked(false);
        rb2b.setChecked(false);
        rb2c.setChecked(false);
        rb2d.setChecked(false);

        rb3a.setChecked(false);
        rb3b.setChecked(false);
        rb3c.setChecked(false);
        rb3d.setChecked(false);

        rb4a.setChecked(false);
        rb4b.setChecked(false);
        rb4c.setChecked(false);
        rb4d.setChecked(false);

        rb5a.setChecked(false);
        rb5b.setChecked(false);
        rb5c.setChecked(false);
        rb5d.setChecked(false);

        rb6a.setChecked(false);
        rb6b.setChecked(false);
        rb6c.setChecked(false);
        rb6d.setChecked(false);

        rb7a.setChecked(false);
        rb7b.setChecked(false);
        rb7c.setChecked(false);
        rb7d.setChecked(false);

        rb8a.setChecked(false);
        rb8b.setChecked(false);
        rb8c.setChecked(false);
        rb8d.setChecked(false);

        rb9a.setChecked(false);
        rb9b.setChecked(false);
        rb9c.setChecked(false);
        rb9d.setChecked(false);

        rb10a.setChecked(false);
        rb10b.setChecked(false);
        rb10c.setChecked(false);
        rb10d.setChecked(false);

        tvQuestion1.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion2.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion3.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion4.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion5.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion6.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion7.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion8.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion9.setBackgroundColor(Color.TRANSPARENT);
        tvQuestion10.setBackgroundColor(Color.TRANSPARENT);

        btnSubmit.setVisibility(View.VISIBLE);
        btnRetake.setVisibility(View.GONE);


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

    @OnClick({R.id.btnSubmit, R.id.btnRetake})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit:
                onSubmitClick();
                break;
            case R.id.btnRetake:
                retake();
                break;
        }
    }
}
