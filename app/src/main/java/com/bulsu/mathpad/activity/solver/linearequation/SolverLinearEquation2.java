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
import com.bulsu.mathpad.activity.solver.Fractions;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Jama.Matrix;

public class SolverLinearEquation2 extends AppCompatActivity {
    TextView tv_ans;
    double[][] var;
    double[] equalVar;

    ArrayList<TextView> answer = new ArrayList<>();
    ArrayList<EditText> numbers1 = new ArrayList<>();
    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_linear_equation2);

        tv_ans = (TextView) findViewById(R.id.tv_ans);
        linear = (LinearLayout) findViewById(R.id.linear1);


        answer.clear();
        numbers1.clear();
        numbers1.add((EditText) findViewById(R.id.colrow_1_1));
        numbers1.add((EditText) findViewById(R.id.colrow_1_2));
        numbers1.add((EditText) findViewById(R.id.colrow_1_3));
        numbers1.add((EditText) findViewById(R.id.colrow_1_4));
        numbers1.add((EditText) findViewById(R.id.colrow_1_5));
        numbers1.add((EditText) findViewById(R.id.colrow_2_1));
        numbers1.add((EditText) findViewById(R.id.colrow_2_2));
        numbers1.add((EditText) findViewById(R.id.colrow_2_3));
        numbers1.add((EditText) findViewById(R.id.colrow_2_4));
        numbers1.add((EditText) findViewById(R.id.colrow_2_5));
        numbers1.add((EditText) findViewById(R.id.colrow_3_1));
        numbers1.add((EditText) findViewById(R.id.colrow_3_2));
        numbers1.add((EditText) findViewById(R.id.colrow_3_3));
        numbers1.add((EditText) findViewById(R.id.colrow_3_4));
        numbers1.add((EditText) findViewById(R.id.colrow_3_5));
        numbers1.add((EditText) findViewById(R.id.colrow_4_1));
        numbers1.add((EditText) findViewById(R.id.colrow_4_2));
        numbers1.add((EditText) findViewById(R.id.colrow_4_3));
        numbers1.add((EditText) findViewById(R.id.colrow_4_4));
        numbers1.add((EditText) findViewById(R.id.colrow_4_5));

        answer.add((TextView) findViewById(R.id.tv_answer_1_1));
        answer.add((TextView) findViewById(R.id.tv_answer_1_2));
        answer.add((TextView) findViewById(R.id.tv_answer_1_3));
        answer.add((TextView) findViewById(R.id.tv_answer_1_4));
        answer.add((TextView) findViewById(R.id.tv_answer_2_1));
        answer.add((TextView) findViewById(R.id.tv_answer_2_2));
        answer.add((TextView) findViewById(R.id.tv_answer_2_3));
        answer.add((TextView) findViewById(R.id.tv_answer_2_4));
        answer.add((TextView) findViewById(R.id.tv_answer_3_1));
        answer.add((TextView) findViewById(R.id.tv_answer_3_2));
        answer.add((TextView) findViewById(R.id.tv_answer_3_3));
        answer.add((TextView) findViewById(R.id.tv_answer_3_4));
        answer.add((TextView) findViewById(R.id.tv_answer_4_1));
        answer.add((TextView) findViewById(R.id.tv_answer_4_2));
        answer.add((TextView) findViewById(R.id.tv_answer_4_3));
        answer.add((TextView) findViewById(R.id.tv_answer_4_4));

    }

    public String solve(double[][] lhsArray, double[] rhsArray, int unknown) {
        String ansText;
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0");
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
            ansText = "x = " + Fractions.convertDecimalToFraction(ans.get(0, 0));
        }

        if ((Double.parseDouble(df2.format(ans.get(1, 0))) % 1) == 0) {
            ansText = ansText + "\ny = " + df.format(ans.get(1, 0));
        } else {
            ansText = ansText + "\ny = " + Fractions.convertDecimalToFraction(ans.get(1, 0));
        }

        if ((Double.parseDouble(df2.format(ans.get(2, 0))) % 1) == 0) {
            ansText = ansText + "\nz = " + df.format(ans.get(2, 0));
        } else {
            ansText = ansText + "\nz = " + Fractions.convertDecimalToFraction(ans.get(2, 0));
        }


        if ((Double.parseDouble(df2.format(ans.get(3, 0))) % 1) == 0) {
            ansText = ansText + "\nw = " + df.format(ans.get(3, 0));
        } else {
            ansText = ansText + "\nw = " + Fractions.convertDecimalToFraction(ans.get(3, 0));
        }
        return ansText;
    }


    public void clear(View v) {
        for (int i = 0; i < 20; i++) {
            numbers1.get(i).setText("");
        }
        linear.setVisibility(View.GONE);
    }

    public void solve1(View v) {

        for (int i = 0; i < 20; i++) {
            if (numbers1.get(i).getText().toString().equals("")) {
                Toast.makeText(SolverLinearEquation2.this, "please fill up the blank spaces", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        var = new double[][]
                {{Double.parseDouble(numbers1.get(0).getText().toString()), Double.parseDouble(numbers1.get(1).getText().toString()), Double.parseDouble(numbers1.get(2).getText().toString()),Double.parseDouble(numbers1.get(3).getText().toString())}
                        , {Double.parseDouble(numbers1.get(5).getText().toString()), Double.parseDouble(numbers1.get(6).getText().toString()), Double.parseDouble(numbers1.get(7).getText().toString()),Double.parseDouble(numbers1.get(8).getText().toString())}
                        , {Double.parseDouble(numbers1.get(10).getText().toString()), Double.parseDouble(numbers1.get(11).getText().toString()), Double.parseDouble(numbers1.get(12).getText().toString()),Double.parseDouble(numbers1.get(13).getText().toString())}
                        , {Double.parseDouble(numbers1.get(15).getText().toString()), Double.parseDouble(numbers1.get(16).getText().toString()), Double.parseDouble(numbers1.get(17).getText().toString()),Double.parseDouble(numbers1.get(18).getText().toString())}};
        equalVar = new double[]{Double.parseDouble(numbers1.get(4).getText().toString()), Double.parseDouble(numbers1.get(9).getText().toString()), Double.parseDouble(numbers1.get(14).getText().toString()), Double.parseDouble(numbers1.get(19).getText().toString())};

        try {
            tv_ans.setText(solve(var, equalVar, 4));
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
