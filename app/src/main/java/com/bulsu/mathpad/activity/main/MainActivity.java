package com.bulsu.mathpad.activity.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.fragment.AboutFragment;
import com.bulsu.mathpad.fragment.FragmentQuiz2;
import com.bulsu.mathpad.fragment.LessonsFragment;
import com.bulsu.mathpad.fragment.SolverFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.fragmentLayout)
    FrameLayout fragmentLayout;
    @Bind(R.id.navigationView)
    NavigationView navigationView;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initialized();


    }

    private void initialized() {

        setSupportActionBar(toolbar);
        setupInitialView();
        setupNavigationView();

    }

    private void setupInitialView() {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.fragmentLayout, new LessonsFragment()).commit();
    }

    private void setupNavigationView() {

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
//                fragmentFrame.setTranslationX(slideOffset * drawerView.getWidth());
//                drawerLayout.bringChildToFront(fragmentFrame);
//                drawerLayout.requestLayout();
            }
        };


        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        String title = null;
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment mFragment = null;

        if (item.isChecked())
            item.setChecked(false);
        else
            item.setChecked(true);
        //if(item.isChecked())


        switch (item.getItemId()) {
            case R.id.menu_lessons:
                mFragment = new LessonsFragment();
                break;
            case R.id.menu_quizzes:
//                mFragment = new QuizzesFragment();
                mFragment = new FragmentQuiz2();
                break;
            case R.id.menu_solver:
                mFragment = new SolverFragment();
                break;
            case R.id.menu_about:
                mFragment = new AboutFragment();
                break;
        }


        if (mFragment != null) {
            mFragmentTransaction.replace(R.id.fragmentLayout, mFragment);
            mFragmentTransaction.commit();
//            setTitle(title);
        }
        item.setChecked(true);
        drawerLayout.closeDrawers();
        return true;
    }
}
