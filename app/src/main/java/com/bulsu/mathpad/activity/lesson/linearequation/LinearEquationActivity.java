package com.bulsu.mathpad.activity.lesson.linearequation;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.adapter.LessonBaseAdapter;
import com.bulsu.mathpad.sliding.SlidingTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LinearEquationActivity extends AppCompatActivity {

    @Bind(R.id.tabs)
    SlidingTabLayout tabs;
    @Bind(R.id.pager)
    ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_lesson_container);
        ButterKnife.bind(this);

        setTitle("Linear Equation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupPager();
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

    private void setupPager() {

        CharSequence titles[] = {"Page 1", "Page 2", "Page 3", "Page 4", "Page 5", "Page 6", "Page 7", "Page 8", "Page 9", "Page 10", "Page 11"};

        int id[] = {R.drawable.s1_1, R.drawable.s1_2, R.drawable.s1_3, R.drawable.s1_4, R.drawable.s1_5, R.drawable.s1_6, R.drawable.s1_7, R.drawable.s1_8, R.drawable.s1_9, R.drawable.s1_10, R.drawable.s1_11};
        LessonBaseAdapter adapter = new LessonBaseAdapter(getSupportFragmentManager(), titles, id);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }
}
