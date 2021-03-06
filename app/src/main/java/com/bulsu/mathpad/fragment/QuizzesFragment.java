package com.bulsu.mathpad.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.quiz.QuizDeterminants1Activity;
import com.bulsu.mathpad.activity.quiz.QuizLinearSystem;
import com.bulsu.mathpad.activity.quiz.QuizMatricesActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizzesFragment extends Fragment {


    @Bind(R.id.btnLinearEQ)
    Button btnLinearEQ;
    @Bind(R.id.btnMatrices)
    Button btnMatrices;
    @Bind(R.id.btnDeterminants)
    Button btnDeterminants;

    public QuizzesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quizzes, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btnLinearEQ, R.id.btnMatrices, R.id.btnDeterminants})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLinearEQ:
                startActivity(new Intent(getActivity(), QuizLinearSystem.class));
                break;
            case R.id.btnMatrices:
                startActivity(new Intent(getActivity(), QuizMatricesActivity.class));
                break;
            case R.id.btnDeterminants:
                startActivity(new Intent(getActivity(), QuizDeterminants1Activity.class));
                break;
        }
    }
}
