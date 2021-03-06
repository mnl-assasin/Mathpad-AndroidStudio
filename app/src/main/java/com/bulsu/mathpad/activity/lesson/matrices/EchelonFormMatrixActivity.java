package com.bulsu.mathpad.activity.lesson.matrices;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.adapter.LessonBaseAdapter;
import com.bulsu.mathpad.sliding.SlidingTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EchelonFormMatrixActivity extends AppCompatActivity {

    @Bind(R.id.tabs)
    SlidingTabLayout tabs;
    @Bind(R.id.pager)
    ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_lesson_container);
        ButterKnife.bind(this);

        setTitle("Echelon Form of a Matrix");
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

        CharSequence titles[] = {"Page 1", "Page 2", "Page 3", "Page 4", "Page 5", "Page 6"};
        int id[] = {R.drawable.m6_1, R.drawable.m6_2, R.drawable.m6_3, R.drawable.m6_4, R.drawable.m6_5, R.drawable.m6_6};
        LessonBaseAdapter adapter = new LessonBaseAdapter(getSupportFragmentManager(), titles, id);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }
}
