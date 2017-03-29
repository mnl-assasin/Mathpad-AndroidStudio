package com.bulsu.mathpad.activity.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.adapter.LessonBaseAdapter;
import com.bulsu.mathpad.sliding.SlidingTabLayout;

import butterknife.Bind;

public class LessonDeterminantsActivity extends AppCompatActivity {

    @Bind(R.id.tabs)
    SlidingTabLayout tabs;
    @Bind(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_lesson_container);

        setTitle("Determinants");
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

        CharSequence titles[] = {"Page 1", "Page 2", "Page 3", "Page 4", "Page 5", "Page 6", "Page 7", "Page 8", "Page 9", "Page 10",
                "Page 11", "Page 12", "Page 13", "Page 14", "Page 15", "Page 16", "Page 17"};
        int id[] = {R.drawable.d1_1, R.drawable.d1_2, R.drawable.d1_3, R.drawable.d1_4, R.drawable.d1_5, R.drawable.d1_6, R.drawable.d1_7, R.drawable.d1_8, R.drawable.d1_9, R.drawable.d1_10,
                R.drawable.d1_11, R.drawable.d1_12, R.drawable.d1_13, R.drawable.d1_14, R.drawable.d1_15, R.drawable.d1_16, R.drawable.d1_17};
        LessonBaseAdapter adapter = new LessonBaseAdapter(getSupportFragmentManager(), titles, id);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }
}
