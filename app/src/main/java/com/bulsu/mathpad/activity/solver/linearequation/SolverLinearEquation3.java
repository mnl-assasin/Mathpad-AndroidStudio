package com.bulsu.mathpad.activity.solver.linearequation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bulsu.mathpad.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Jama.Matrix;

public class SolverLinearEquation3 extends AppCompatActivity {
    TextView tv_ans;
    double[][] var;
    double[] equalVar;
    ArrayList<EditText> numbers1 = new ArrayList<>();
    LinearLayout linear;
    String ansText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_linear_equation3);
        tv_ans = (TextView) findViewById(R.id.tv_ans);
        linear = (LinearLayout) findViewById(R.id.linear1);


        numbers1.clear();
        numbers1.add((EditText) findViewById(R.id.colrow_1_1));
        numbers1.add((EditText) findViewById(R.id.colrow_1_2));
        numbers1.add((EditText) findViewById(R.id.colrow_1_3));
        numbers1.add((EditText) findViewById(R.id.colrow_2_1));
        numbers1.add((EditText) findViewById(R.id.colrow_2_2));
        numbers1.add((EditText) findViewById(R.id.colrow_2_3));

    }

    public String solve(double[][] lhsArray, double[] rhsArray, int unknown) {

        DecimalFormat df = new DecimalFormat("0");
        DecimalFormat df2 = new DecimalFormat("0.00");
        //Creating Matrix Objects with arrays
        Matrix lhs = new Matrix(lhsArray);
        Matrix rhs = new Matrix(rhsArray, unknown);
        //Calculate Solved Matrix
        Matrix ans = lhs.solve(rhs);


        if ((Double.parseDouble(df2.format(ans.get(0, 0))) % 1) == 0)
        {
            ansText = "x = " + df.format(ans.get(0, 0));
        }
        else {
            ansText = "x = " + df2.format(ans.get(0, 0));
        }

        if ((Double.parseDouble(df2.format(ans.get(1, 0))) % 1) == 0) {
            ansText = ansText + "\ny = " + df.format(ans.get(1, 0));
        } else {
            ansText = ansText + "\ny = " + df2.format(ans.get(1, 0));
        }

        return ansText;
    }
    public void clear(View v) {
        for (int i = 0; i < 6; i++) {
            numbers1.get(i).setText("");
        }
        linear.setVisibility(View.GONE);
    }

    public void solve_1(View v) {

        for (int i = 0; i < 6; i++) {
            if (numbers1.get(i).getText().toString().equals("")) {
                Toast.makeText(SolverLinearEquation3.this, "please fill up the blank spaces", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        var = new double[][]
                {{Double.parseDouble(numbers1.get(0).getText().toString()), Double.parseDouble(numbers1.get(1).getText().toString())}
                        , {Double.parseDouble(numbers1.get(3).getText().toString()), Double.parseDouble(numbers1.get(4).getText().toString())}};
        equalVar = new double[]{Double.parseDouble(numbers1.get(2).getText().toString()), Double.parseDouble(numbers1.get(5).getText().toString())};


        try {
            tv_ans.setText(solve(var, equalVar, 2));
            linear.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Toast.makeText(this, "linear equation is not possible to solve", Toast.LENGTH_SHORT).show();
        }
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}
