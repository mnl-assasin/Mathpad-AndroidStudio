package com.bulsu.mathpad.activity.solver.inverse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bulsu.mathpad.R;

import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.text.DecimalFormat;
import java.util.ArrayList;



public class SolverInverse extends AppCompatActivity {
    ArrayList<EditText> numbers1 = new ArrayList<>();
    ArrayList<TextView> answer = new ArrayList<>();
    TextView tv_answer;
    ScrollView mScrollView;
    LinearLayout linearAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_inverse);
        numbers1.clear();
        answer.clear();
        numbers1.add((EditText) findViewById(R.id.colrow_1_1));
        numbers1.add((EditText) findViewById(R.id.colrow_1_2));
        numbers1.add((EditText) findViewById(R.id.colrow_2_1));
        numbers1.add((EditText) findViewById(R.id.colrow_2_2));

        answer.add((TextView) findViewById(R.id.tv_answer_1_1));
        answer.add((TextView) findViewById(R.id.tv_answer_1_2));
        answer.add((TextView) findViewById(R.id.tv_answer_2_1));
        answer.add((TextView) findViewById(R.id.tv_answer_2_2));


        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        linearAnswer = (LinearLayout) findViewById(R.id.linear1);
    }

    public void onClickSolveinverse2(View v) {

        for (int i = 0; i < 4; i++) {
            if (numbers1.get(i).getText().toString().equals("")) {
                Toast.makeText(this, "please fill up the blank spaces", Toast.LENGTH_SHORT).show();
                return;
            }
        }


        try {
            RealMatrix a = new LUDecomposition(
                    MatrixUtils.createRealMatrix(new double[][] { { Double.parseDouble(numbers1.get(0).getText().toString()),  Double.parseDouble(numbers1.get(1).getText().toString())},
                            { Double.parseDouble(numbers1.get(2).getText().toString()),  Double.parseDouble(numbers1.get(3).getText().toString())}})
            ).getSolver().getInverse();
            double[][]b = a.getData();

            DecimalFormat df = new DecimalFormat("0");
            DecimalFormat df2 = new DecimalFormat("0.00");


            int count=0;
            for (int i =0;i<b.length;i++)
            {
                for (int j =0;j<b[0].length;j++){
                    if ((Double.parseDouble(df2.format(b[i][j])) % 1) == 0) {
                        answer.get(count).setText(df.format(b[i][j]));
                    } else {

                         answer.get(count).setText(df2.format(b[i][j]));

                    }
                    count++;
                }
            }

            mScrollView.post(new Runnable() {
                public void run() {
                    mScrollView.scrollTo(0, mScrollView.getBottom());
                }
            });


            linearAnswer.setVisibility(View.VISIBLE);
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

        }
        catch (Exception ex)
        {
            Toast.makeText(this, "it does not exist", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearInverse2(View v)
    {
        for (int i = 0; i < 4; i++) {
            numbers1.get(i).setText("");
        }
    }

    public void clearAllInverse2(View v)
    {
        linearAnswer.setVisibility(View.GONE);
        mScrollView.post(new Runnable() {
            public void run() {
                mScrollView.scrollTo(0, mScrollView.getTop());
            }
        });
        for (int i = 0; i < 4; i++) {
            numbers1.get(i).setText("");
        }
    }
}
