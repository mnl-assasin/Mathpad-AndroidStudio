package com.bulsu.mathpad.activity.solver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.solver.linearequation.SolverLinearEquation;
import com.bulsu.mathpad.activity.solver.linearequation.SolverLinearEquation2;
import com.bulsu.mathpad.activity.solver.linearequation.SolverLinearEquation3;

public class SolverLinearEquationList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_linear_equation_list);
    }


    public void click_2x2(View v) {
        startActivity(new Intent(SolverLinearEquationList.this,SolverLinearEquation3.class));
    }
    public void click_3x3(View v) {
        startActivity(new Intent(SolverLinearEquationList.this,SolverLinearEquation.class));
    }
    public void click_4x4(View v) {
        startActivity(new Intent(SolverLinearEquationList.this,SolverLinearEquation2.class));
    }

}
