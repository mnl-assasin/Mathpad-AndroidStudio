package com.bulsu.mathpad.activity.lesson;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.adapter.LessonBaseAdapter;
import com.bulsu.mathpad.sliding.SlidingTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DeterminantsActivity extends AppCompatActivity {

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

    LessonBaseAdapter adapter;

    private void setupPager() {

        CharSequence titles[] = {"Page 1", "Page 2", "Page 3", "Page 4", "Page 5", "Page 6", "Page 7", "Page 8", "Page 9", "Page 10", "Page 11", "Page 12", "Page 13", "Page 14"};
        int layoutResourceId[] = {R.layout.determinants1, R.layout.determinants2,
                R.layout.determinants3, R.layout.determinants4, R.layout.determinants5, R.layout.determinants6, R.layout.determinants7,
                R.layout.determinants8, R.layout.determinants9, R.layout.determinants10, R.layout.determinants11, R.layout.determinants12, R.layout.determinants13, R.layout.determinants14};

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
