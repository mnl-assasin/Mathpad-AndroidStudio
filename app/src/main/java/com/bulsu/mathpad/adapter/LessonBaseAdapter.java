package com.bulsu.mathpad.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bulsu.mathpad.fragment.LessonBaseFragment;

/**
 * Created by mykelneds on 12/03/2017.
 */

public class LessonBaseAdapter extends FragmentStatePagerAdapter {


    private CharSequence titles[];
    private int layoutResourceId[];

    public LessonBaseAdapter(FragmentManager fm, CharSequence[] titles, int[] layoutResourceId) {
        super(fm);
        this.titles = titles;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle b = new Bundle();
        b.putInt("drawableId", layoutResourceId[position]);

        LessonBaseFragment fragment = new LessonBaseFragment();
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
