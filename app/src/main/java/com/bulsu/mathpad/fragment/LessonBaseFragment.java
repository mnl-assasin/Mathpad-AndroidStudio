package com.bulsu.mathpad.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bulsu.mathpad.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LessonBaseFragment extends Fragment {


    public LessonBaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_lesson_base, container, false);

        int layoutResourceId = getArguments().getInt("layout", R.layout.fragment_lesson_base);

        return inflater.inflate(layoutResourceId, container, false);
    }

}
