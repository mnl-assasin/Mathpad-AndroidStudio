package com.bulsu.mathpad.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.solver.SolverDeterminantList;
import com.bulsu.mathpad.activity.solver.SolverInverseList;
import com.bulsu.mathpad.activity.solver.SolverLinearEquationList;
import com.bulsu.mathpad.activity.solver.SolverMatrixList;
import com.bulsu.mathpad.activity.solver.SolverTranspose;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SolverFragment extends Fragment {


    @Bind(R.id.btnSolver)
    Button btnSolver;
    @Bind(R.id.btnSolver2)
    Button btnSolver2;
    @Bind(R.id.btnSolver3)
    Button btnSolver3;
    @Bind(R.id.btnSolver4)
    Button btnSolver4;
    @Bind(R.id.btnSolver5)
    Button btnSolver5;

    public SolverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_solver, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btnSolver, R.id.btnSolver2, R.id.btnSolver3, R.id.btnSolver4, R.id.btnSolver5})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnSolver:
                startActivity(new Intent(getActivity(), SolverLinearEquationList.class));
                break;
            case R.id.btnSolver2:
                startActivity(new Intent(getActivity(), SolverMatrixList.class));
                break;
            case R.id.btnSolver3:
                startActivity(new Intent(getActivity(), SolverDeterminantList.class));
                break;
            case R.id.btnSolver4:
                startActivity(new Intent(getActivity(), SolverTranspose.class));
                break;
            case R.id.btnSolver5:
                startActivity(new Intent(getActivity(), SolverInverseList.class));
                break;
        }
    }
}
