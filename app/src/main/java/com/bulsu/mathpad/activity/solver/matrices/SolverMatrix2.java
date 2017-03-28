package com.bulsu.mathpad.activity.solver.matrices;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bulsu.mathpad.R;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class SolverMatrix2 extends AppCompatActivity {


    ArrayList<EditText> numbers1 = new ArrayList<>();
    ArrayList<EditText> numbers2 = new ArrayList<>();
    ArrayList<TextView> answer = new ArrayList<>();
    TextView tv_answer;
    LinearLayout linearAnswer;
    Spinner spinner;
    int methodChoosed=0;
    ScrollView mScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_matrix2);
        numbers1.clear();
        numbers2.clear();
        answer.clear();

        String arr[] = new String[]{"A + B","A - B"};

        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        spinner = (Spinner) findViewById(R.id.spinnerChoose);
        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.spinne_layout,R.id.tv_spinner,arr));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                methodChoosed = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        numbers1.add((EditText) findViewById(R.id.colrow_1_1));
        numbers1.add((EditText) findViewById(R.id.colrow_1_2));
        numbers1.add((EditText) findViewById(R.id.colrow_1_3));
        numbers1.add((EditText) findViewById(R.id.colrow_1_4));
        numbers1.add((EditText) findViewById(R.id.colrow_2_1));
        numbers1.add((EditText) findViewById(R.id.colrow_2_2));
        numbers1.add((EditText) findViewById(R.id.colrow_2_3));
        numbers1.add((EditText) findViewById(R.id.colrow_2_4));
        numbers1.add((EditText) findViewById(R.id.colrow_3_1));
        numbers1.add((EditText) findViewById(R.id.colrow_3_2));
        numbers1.add((EditText) findViewById(R.id.colrow_3_3));
        numbers1.add((EditText) findViewById(R.id.colrow_3_4));
        numbers1.add((EditText) findViewById(R.id.colrow_4_1));
        numbers1.add((EditText) findViewById(R.id.colrow_4_2));
        numbers1.add((EditText) findViewById(R.id.colrow_4_3));
        numbers1.add((EditText) findViewById(R.id.colrow_4_4));

        numbers2.add((EditText) findViewById(R.id.colrow2_1_1));
        numbers2.add((EditText) findViewById(R.id.colrow2_1_2));
        numbers2.add((EditText) findViewById(R.id.colrow2_1_3));
        numbers2.add((EditText) findViewById(R.id.colrow2_1_4));
        numbers2.add((EditText) findViewById(R.id.colrow2_2_1));
        numbers2.add((EditText) findViewById(R.id.colrow2_2_2));
        numbers2.add((EditText) findViewById(R.id.colrow2_2_3));
        numbers2.add((EditText) findViewById(R.id.colrow2_2_4));
        numbers2.add((EditText) findViewById(R.id.colrow2_3_1));
        numbers2.add((EditText) findViewById(R.id.colrow2_3_2));
        numbers2.add((EditText) findViewById(R.id.colrow2_3_3));
        numbers2.add((EditText) findViewById(R.id.colrow2_3_4));
        numbers2.add((EditText) findViewById(R.id.colrow2_4_1));
        numbers2.add((EditText) findViewById(R.id.colrow2_4_2));
        numbers2.add((EditText) findViewById(R.id.colrow2_4_3));
        numbers2.add((EditText) findViewById(R.id.colrow2_4_4));

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

        linearAnswer = (LinearLayout) findViewById(R.id.linearAnswer);
    }


    public void onClickSolve(View v) {

        for (int i = 0; i < 16; i++) {
            if ((numbers1.get(i).getText().toString().equals("")) || (numbers2.get(i).getText().toString().equals(""))) {
                Toast.makeText(this, "please fill up the blank spaces", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if (methodChoosed==0)
        {
            solve4x4plus();
        }
        else if (methodChoosed==1)
        {
            solve4x4minus();
        }
        else {
            solve4x4multiplication();
        }
        mScrollView.post(new Runnable() {
            public void run() {
                mScrollView.scrollTo(0, mScrollView.getBottom());
            }
        });

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public void clear1(View view)
    {
        for(int i =0;i<16;i++)
        {
            numbers1.get(i).setText("");
        }
    }

    public void clear2(View view)
    {
        for(int i =0;i<16;i++)
        {
            numbers2.get(i).setText("");
        }
    }

    public void clear3(View view)
    {
        for(int i =0;i<16;i++)
        {
            numbers2.get(i).setText("");
            numbers1.get(i).setText("");
        }
        linearAnswer.setVisibility(View.GONE);
    }

    public void solve4x4multiplication() {
        try {
            int m, n, p, q,  c, d, k;
            double sum = 0;
            m = 4;
            n = 4;
            double first[][] = new double[m][n];

            int count = 0;
            for (c = 0; c < m; c++) {
                for (d = 0; d < n; d++) {
                    first[c][d] = Double.parseDouble(numbers1.get(count).getText().toString());
                    count++;
                }
            }

            count = 0;
            p = 4;
            q = 4;


            double second[][] = new double[p][q];
            double multiply[][] = new double[m][q];

            for (c = 0; c < p; c++) {
                for (d = 0; d < q; d++) {
                    second[c][d] = Double.parseDouble(numbers2.get(count).getText().toString());
                    count++;
                }
            }

            for (c = 0; c < m; c++) {
                for (d = 0; d < q; d++) {
                    for (k = 0; k < p; k++) {
                        sum = sum + first[c][k] * second[k][d];
                    }

                    multiply[c][d] = sum;
                    sum = 0;
                }
            }

            count = 0;
            linearAnswer.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("0");
            DecimalFormat df2 = new DecimalFormat("0.00");
            for (c = 0; c < m; c++) {
                for (d = 0; d < q; d++) {
                    if((Double.parseDouble(df2.format(multiply[c][d])) % 1) == 0) {
                        answer.get(count).setText(df.format(multiply[c][d]) + "");
                    }
                    else {
                        answer.get(count).setText(df2.format(multiply[c][d]) + "");
                    }
                    count++;
                }
            }
        }
        catch (Exception ex)
        {
            Log.d("kim",ex+"");
        }
    }


    public void solve4x4plus()
    {
        DecimalFormat df = new DecimalFormat("0");
        DecimalFormat df2 = new DecimalFormat("0.00");
        for (int i = 0; i < 16; i++) {
            double a = Double.parseDouble(df2.format(Double.parseDouble(numbers1.get(i).getText().toString())))+Double.parseDouble(df2.format(Double.parseDouble(numbers2.get(i).getText().toString())));
            if ((a % 1) == 0){
                answer.get(i).setText(df.format(a)+"");
            }
            else{
                answer.get(i).setText(df2.format(a)+"");
            }
        }
        linearAnswer.setVisibility(View.VISIBLE);
    }

    public void solve4x4minus()
    {
        DecimalFormat df = new DecimalFormat("0");
        DecimalFormat df2 = new DecimalFormat("0.00");
        for (int i = 0; i < 16; i++) {
            double a = Double.parseDouble(df2.format(Double.parseDouble(numbers1.get(i).getText().toString())))-Double.parseDouble(df2.format(Double.parseDouble(numbers2.get(i).getText().toString())));
            if ((a % 1) == 0){
                answer.get(i).setText(df.format(a)+"");
            }
            else{
                answer.get(i).setText(df2.format(a)+"");
            }
        }
        linearAnswer.setVisibility(View.VISIBLE);
    }

}
