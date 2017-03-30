package com.bulsu.mathpad.activity.quiz;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_determinants1);
        ButterKnife.bind(this);

        setTitle("Determinants");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btnSubmit)
    public void onClick() {
        int score = 0;
        if (rb1a.isChecked())
            score++;
        else
            rb1a.setBackgroundColor(Color.RED);

        if (rb2c.isChecked())
            score++;
        else
            rb2c.setBackgroundColor(Color.RED);

        if (rb3b.isChecked())
            score++;
        else
            rb3b.setBackgroundColor(Color.RED);

        if (rb4a.isChecked())
            score++;
        else
            rb4a.setBackgroundColor(Color.RED);

        if (rb5d.isChecked())
            score++;
        else
            rb5d.setBackgroundColor(Color.RED);

        if (rb6c.isChecked())
            score++;
        else
            rb6c.setBackgroundColor(Color.RED);

        if (rb7d.isChecked())
            score++;
        else
            rb7d.setBackgroundColor(Color.RED);

        if (rb8a.isChecked())
            score++;
        else
            rb8a.setBackgroundColor(Color.RED);

        if (rb9d.isChecked())
            score++;
        else
            rb9d.setBackgroundColor(Color.RED);

        if (rb10c.isChecked())
            score++;
        else
            rb10c.setBackgroundColor(Color.RED);

        Log.d("score", "Total Score: " + score);
        displayScore(score);
    }

    private void displayScore(int score) {

        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_score, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(v);

        TextView tv = (TextView) v.findViewById(R.id.tv_score);
        tv.setText(String.valueOf(score));
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
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
}
