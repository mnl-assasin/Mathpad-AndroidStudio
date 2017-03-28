package com.bulsu.mathpad.activity.solver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.solver.inverse.SolverInverse;
import com.bulsu.mathpad.activity.solver.inverse.SolverInverse2;
import com.bulsu.mathpad.activity.solver.inverse.SolverInverse3;

public class SolverInverseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_inverse_list);




    }


    public void click2x2inverse(View v) {
        startActivity(new Intent(SolverInverseList.this,SolverInverse.class));
    }
    public void click3x3inverse(View v) {
        startActivity(new Intent(SolverInverseList.this,SolverInverse2.class));
    }

    public void click4x4inverse(View v) {
        startActivity(new Intent(SolverInverseList.this,SolverInverse3.class));
    }
}
