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

public class LinearSystemInversesActivity extends AppCompatActivity {

    @Bind(R.id.tabs)
    SlidingTabLayout tabs;
    @Bind(R.id.pager)
    ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_lesson_container);
        ButterKnife.bind(this);

        setTitle("Linear System and Inverses");
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

    LessonBaseAdapter adapter;

    private void setupPager() {

        CharSequence titles[] = {"Page 1", "Page 2", "Page 3", "Page 4", "Page 5"};
        int layoutResourceId[] = {R.layout.matrix_lsi1, R.layout.matrix_lsi2,
                R.layout.matrix_lsi3, R.layout.matrix_lsi4, R.layout.matrix_lsi5};

        adapter = new LessonBaseAdapter(getSupportFragmentManager(), titles, layoutResourceId);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(android.R.color.white);
            }
        });
    }
}
