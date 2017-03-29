package com.bulsu.mathpad.activity.solver.matrices;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.solver.Fractions;

import java.text.DecimalFormat;


public class SolverMatricesMultiplication extends AppCompatActivity {
    LinearLayout linear;
    EditText[][] number;
    EditText[][] number2;
    TextView[][] answers;
    double ans[][];
    double value[][];
    EditText row, column;
    EditText row2, column2;
    Button clear, clear2, solve;
    int rowSize;
    int columnSize;
    int rowSize2;
    int columnSize2;
    ScrollView mScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_matrices_multiplication);
        linear = (LinearLayout) findViewById(R.id.linear1);
        mScrollView = (ScrollView) findViewById(R.id.sv);

        number = new EditText[][]{
                {(EditText) findViewById(R.id.colrow_1_1), (EditText) findViewById(R.id.colrow_1_2), (EditText) findViewById(R.id.colrow_1_3), (EditText) findViewById(R.id.colrow_1_4)},
                {(EditText) findViewById(R.id.colrow_2_1), (EditText) findViewById(R.id.colrow_2_2), (EditText) findViewById(R.id.colrow_2_3), (EditText) findViewById(R.id.colrow_2_4)},
                {(EditText) findViewById(R.id.colrow_3_1), (EditText) findViewById(R.id.colrow_3_2), (EditText) findViewById(R.id.colrow_3_3), (EditText) findViewById(R.id.colrow_3_4)},
                {(EditText) findViewById(R.id.colrow_4_1), (EditText) findViewById(R.id.colrow_4_2), (EditText) findViewById(R.id.colrow_4_3), (EditText) findViewById(R.id.colrow_4_4)}
        };

        number2 = new EditText[][]{
                {(EditText) findViewById(R.id.colrow2_1_1), (EditText) findViewById(R.id.colrow2_1_2), (EditText) findViewById(R.id.colrow2_1_3), (EditText) findViewById(R.id.colrow2_1_4)},
                {(EditText) findViewById(R.id.colrow2_2_1), (EditText) findViewById(R.id.colrow2_2_2), (EditText) findViewById(R.id.colrow2_2_3), (EditText) findViewById(R.id.colrow2_2_4)},
                {(EditText) findViewById(R.id.colrow2_3_1), (EditText) findViewById(R.id.colrow2_3_2), (EditText) findViewById(R.id.colrow2_3_3), (EditText) findViewById(R.id.colrow2_3_4)},
                {(EditText) findViewById(R.id.colrow2_4_1), (EditText) findViewById(R.id.colrow2_4_2), (EditText) findViewById(R.id.colrow2_4_3), (EditText) findViewById(R.id.colrow2_4_4)}
        };

        answers = new TextView[][]{
                {(TextView) findViewById(R.id.tv_answer_1_1), (TextView) findViewById(R.id.tv_answer_1_2), (TextView) findViewById(R.id.tv_answer_1_3), (TextView) findViewById(R.id.tv_answer_1_4)},
                {(TextView) findViewById(R.id.tv_answer_2_1), (TextView) findViewById(R.id.tv_answer_2_2), (TextView) findViewById(R.id.tv_answer_2_3), (TextView) findViewById(R.id.tv_answer_2_4)},
                {(TextView) findViewById(R.id.tv_answer_3_1), (TextView) findViewById(R.id.tv_answer_3_2), (TextView) findViewById(R.id.tv_answer_3_3), (TextView) findViewById(R.id.tv_answer_3_4)},
                {(TextView) findViewById(R.id.tv_answer_4_1), (TextView) findViewById(R.id.tv_answer_4_2), (TextView) findViewById(R.id.tv_answer_4_3), (TextView) findViewById(R.id.tv_answer_4_4)}
        };

        row = (EditText) findViewById(R.id.row);
        column = (EditText) findViewById(R.id.column);

        row2 = (EditText) findViewById(R.id.row2);
        column2 = (EditText) findViewById(R.id.column2);


        solve = (Button) findViewById(R.id.buttonSolver);
        clear = (Button) findViewById(R.id.buttonClear);
        clear2 = (Button) findViewById(R.id.buttonClear2);
    }


    public void display1(View v) {





        if (column.getText().toString().equalsIgnoreCase("") && row.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(SolverMatricesMultiplication.this, "1st set matrices: Please enter column size and row size", Toast.LENGTH_SHORT).show();
            return;
        }
        if (column.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(SolverMatricesMultiplication.this, "1st set matrices: Please enter column size", Toast.LENGTH_SHORT).show();
            return;
        }

        if (row.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(SolverMatricesMultiplication.this, "1st set matrices: Please enter row size", Toast.LENGTH_SHORT).show();
            return;
        }
        rowSize = Integer.parseInt(row.getText().toString());
        columnSize = Integer.parseInt(column.getText().toString());

        if (columnSize <= 0 || columnSize >= 5) {
            Toast.makeText(SolverMatricesMultiplication.this, "1st set matrices: column size is invalid column size must be 2 to 4 value only", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rowSize <= 0 || rowSize >= 5) {
            Toast.makeText(SolverMatricesMultiplication.this, "1st set matrices: row size is invalid row size must be 2 to 4 value only", Toast.LENGTH_SHORT).show();
            return;
        }

        //second input

        if (column2.getText().toString().equalsIgnoreCase("") && row2.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(SolverMatricesMultiplication.this, "2nd set matrices: Please enter column size and row size", Toast.LENGTH_SHORT).show();
            return;
        }
        if (column2.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(SolverMatricesMultiplication.this, "2nd set matrices: Please enter column size", Toast.LENGTH_SHORT).show();
            return;
        }

        if (row2.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(SolverMatricesMultiplication.this, "2nd set matrices: Please enter row size", Toast.LENGTH_SHORT).show();
            return;
        }

        rowSize2 = Integer.parseInt(row2.getText().toString());
        columnSize2 = Integer.parseInt(column2.getText().toString());

        if (columnSize2 <= 0 || columnSize2 >= 5) {
            Toast.makeText(SolverMatricesMultiplication.this, "2nd set matrices: column size is invalid column size must be 2 to 4 value only", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rowSize2 <= 0 || rowSize2 >= 5) {
            Toast.makeText(SolverMatricesMultiplication.this, "2nd set matrices: row size is invalid row size must be 2 to 4 value only", Toast.LENGTH_SHORT).show();
            return;
        }

        if (columnSize != rowSize2) {
            Toast.makeText(this, "Matrices with entered orders can't be multiplied with each other.", Toast.LENGTH_SHORT).show();
            return;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                number[i][j].setVisibility(View.GONE);
                number[i][j].setText("");
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                number[i][j].setVisibility(View.VISIBLE);
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                number2[i][j].setVisibility(View.GONE);
                number2[i][j].setText("");
            }
        }


        for (int i = 0; i < rowSize2; i++) {
            for (int j = 0; j < columnSize2; j++) {
                number2[i][j].setVisibility(View.VISIBLE);
            }
        }


        solve.setVisibility(View.VISIBLE);
        clear.setVisibility(View.VISIBLE);
        clear2.setVisibility(View.VISIBLE);
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public void solveMultiplicationMatrices(View v) {

        try {
            int m, n, p, q, c, d, k;
            double sum = 0;
            m = rowSize;
            n = columnSize;
            double first[][] = new double[m][n];

            int count = 0;
            for (c = 0; c < m; c++) {
                for (d = 0; d < n; d++) {
                    first[c][d] = Double.parseDouble(number[c][d].getText().toString());
                    count++;
                }
            }

            count = 0;
            p = rowSize2;
            q = columnSize2;


            double second[][] = new double[p][q];
            double multiply[][] = new double[m][q];

            for (c = 0; c < p; c++) {
                for (d = 0; d < q; d++) {
                    second[c][d] = Double.parseDouble(number2[c][d].getText().toString());
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
            linear.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("0");
            DecimalFormat df2 = new DecimalFormat("0.00");
            for (c = 0; c < m; c++) {
                for (d = 0; d < q; d++) {
                    if ((Double.parseDouble(df2.format(multiply[c][d])) % 1) == 0) {
                        answers[c][d].setText(df.format(multiply[c][d]) + "");
                        answers[c][d].setVisibility(View.VISIBLE);
                    } else {
                        answers[c][d].setText(Fractions.convertDecimalToFraction(multiply[c][d]) + "");
                        answers[c][d].setVisibility(View.VISIBLE);
                    }
                    count++;
                }
            }

            mScrollView.post(new Runnable() {
                public void run() {
                    mScrollView.scrollTo(0, mScrollView.getBottom());
                }
            });

            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }catch (Exception ex)
        {
            Toast.makeText(this, "not acceptable", Toast.LENGTH_SHORT).show();
        }

    }

    public void clear1(View v) {
        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                number[i][j].setText("");
            }
        }
    }

    public void clear2(View v) {
        for (int i = 0; i < columnSize2; i++) {
            for (int j = 0; j < rowSize2; j++) {
                number2[i][j].setText("");
            }
        }
    }

    public void clearAll(View v) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                number[i][j].setText("");
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                number2[i][j].setText("");
            }
        }

        linear.setVisibility(View.GONE);
    }


}
