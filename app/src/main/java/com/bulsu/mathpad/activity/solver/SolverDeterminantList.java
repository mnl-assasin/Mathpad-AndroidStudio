package com.bulsu.mathpad.activity.solver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.solver.determinant.SolverDeterminant;
import com.bulsu.mathpad.activity.solver.determinant.SolverDeterminant2;
import com.bulsu.mathpad.activity.solver.determinant.SolverDeterminant3;


public class SolverDeterminantList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_determinant_list);
    }


    public void click2x2Determinant(View v) {
        startActivity(new Intent(SolverDeterminantList.this,SolverDeterminant.class));
    }
    public void click3x3Determinant(View v) {
        startActivity(new Intent(SolverDeterminantList.this,SolverDeterminant2.class));
    }

    public void click4x4Determinant(View v) {
        startActivity(new Intent(SolverDeterminantList.this,SolverDeterminant3.class));
    }
}
