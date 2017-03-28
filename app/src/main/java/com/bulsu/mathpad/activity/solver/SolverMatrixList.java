package com.bulsu.mathpad.activity.solver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.solver.matrices.SolverMatricesMultiplication;
import com.bulsu.mathpad.activity.solver.matrices.SolverMatrix;
import com.bulsu.mathpad.activity.solver.matrices.SolverMatrix2;
import com.bulsu.mathpad.activity.solver.matrices.SolverMatrix3;


public class SolverMatrixList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_matrix_list);

    }

    public void click2x2(View v) {
        startActivity(new Intent(SolverMatrixList.this,SolverMatrix3.class));
    }
    public void click3x3(View v) {
        startActivity(new Intent(SolverMatrixList.this,SolverMatrix.class));
    }

    public void click4x4(View v) {
        startActivity(new Intent(SolverMatrixList.this,SolverMatrix2.class));
    }

    public void clickMultiplication(View v) {
        startActivity(new Intent(SolverMatrixList.this,SolverMatricesMultiplication.class));
    }

}
