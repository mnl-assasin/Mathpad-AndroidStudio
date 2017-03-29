package com.bulsu.mathpad.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.widgets.TouchImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LessonBaseFragment extends Fragment {


    @Bind(R.id.tiv)
    TouchImageView tiv;

    public LessonBaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_lesson_base, container, false);

        View v = inflater.inflate(R.layout.fragment_lesson_base, container, false);
        ButterKnife.bind(this, v);

        int drawable = getArguments().getInt("drawableId", R.drawable.banner_main);
        tiv.setImageDrawable(getResources().getDrawable(drawable));

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
