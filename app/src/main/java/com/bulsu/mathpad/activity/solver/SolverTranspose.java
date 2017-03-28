package com.bulsu.mathpad.activity.solver;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bulsu.mathpad.R;


public class SolverTranspose extends AppCompatActivity {



    LinearLayout linear;
    EditText[][] number;
    TextView[][] answers;
    double ans[][];
    double value[][];
    EditText row, column;
    Button clear, solve;
    int rowSize;
    int columnSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_transpose);

        linear = (LinearLayout) findViewById(R.id.linear1);


        number = new EditText[][]{
                {(EditText) findViewById(R.id.colrow_1_1), (EditText) findViewById(R.id.colrow_1_2), (EditText) findViewById(R.id.colrow_1_3), (EditText) findViewById(R.id.colrow_1_4)},
                {(EditText) findViewById(R.id.colrow_2_1), (EditText) findViewById(R.id.colrow_2_2), (EditText) findViewById(R.id.colrow_2_3), (EditText) findViewById(R.id.colrow_2_4)},
                {(EditText) findViewById(R.id.colrow_3_1), (EditText) findViewById(R.id.colrow_3_2), (EditText) findViewById(R.id.colrow_3_3), (EditText) findViewById(R.id.colrow_3_4)},
                {(EditText) findViewById(R.id.colrow_4_1), (EditText) findViewById(R.id.colrow_4_2), (EditText) findViewById(R.id.colrow_4_3), (EditText) findViewById(R.id.colrow_4_4)}
        };

        answers = new TextView[][]{
                {(TextView) findViewById(R.id.tv_answer_1_1), (TextView) findViewById(R.id.tv_answer_1_2), (TextView) findViewById(R.id.tv_answer_1_3), (TextView) findViewById(R.id.tv_answer_1_4)},
                {(TextView) findViewById(R.id.tv_answer_2_1), (TextView) findViewById(R.id.tv_answer_2_2), (TextView) findViewById(R.id.tv_answer_2_3), (TextView) findViewById(R.id.tv_answer_2_4)},
                {(TextView) findViewById(R.id.tv_answer_3_1), (TextView) findViewById(R.id.tv_answer_3_2), (TextView) findViewById(R.id.tv_answer_3_3), (TextView) findViewById(R.id.tv_answer_3_4)},
                {(TextView) findViewById(R.id.tv_answer_4_1), (TextView) findViewById(R.id.tv_answer_4_2), (TextView) findViewById(R.id.tv_answer_4_3), (TextView) findViewById(R.id.tv_answer_4_4)}
        };


        row = (EditText) findViewById(R.id.row);
        column = (EditText) findViewById(R.id.column);


        solve = (Button) findViewById(R.id.buttonSolver);
        clear = (Button) findViewById(R.id.buttonClear);
    }


    public void display(View v) {


        if (column.getText().toString().equalsIgnoreCase("")&&row.getText().toString().equalsIgnoreCase(""))
        {
            Toast.makeText(SolverTranspose.this, "Please enter column size and row size", Toast.LENGTH_SHORT).show();
            return;
        }

        if (column.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(SolverTranspose.this, "Please enter column size", Toast.LENGTH_SHORT).show();
            return;
        }

        if (row.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(SolverTranspose.this, "Please enter row size", Toast.LENGTH_SHORT).show();
            return;
        }

        rowSize = Integer.parseInt(row.getText().toString());
        columnSize = Integer.parseInt(column.getText().toString());

        if (columnSize <= 1 || columnSize >= 5) {
            Toast.makeText(SolverTranspose.this, "column size is invalid column size must be 2 to 4 value only", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rowSize <= 1 || rowSize >= 5) {
            Toast.makeText(SolverTranspose.this, "row size is invalid row size must be 2 to 4 value only", Toast.LENGTH_SHORT).show();
            return;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                number[i][j].setVisibility(View.GONE);
                number[i][j].setText("");
            }
        }

        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                number[i][j].setVisibility(View.VISIBLE);
            }
        }
        solve.setVisibility(View.VISIBLE);
        clear.setVisibility(View.VISIBLE);
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }


    public void clear(View v)
    {
        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                number[i][j].setText("");
            }
        }
    }

    public void clearAll(View v)
    {
        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                number[i][j].setText("");
            }
        }
        linear.setVisibility(View.GONE);
    }

    public void transpose(View v) {

       ans = new double[columnSize][rowSize];
        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {

                if (number[i][j].getText().toString().equals("")) {
                    Toast.makeText(SolverTranspose.this, "Please fill up the blank spaces", Toast.LENGTH_SHORT).show();
                    return;
                }
                ans[i][j] = Double.parseDouble(number[i][j].getText().toString());
            }
        }

        value = new double[rowSize][columnSize];
        value=transposeMatrix(ans);

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
              answers[i][j].setVisibility(View.GONE);
            }
        }

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                answers[i][j].setText(((int)value[i][j])+"");
                answers[i][j].setVisibility(View.VISIBLE);

            }
        }
        linear.setVisibility(View.VISIBLE);
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public double[][] transposeMatrix(double[][] m) {
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

}
