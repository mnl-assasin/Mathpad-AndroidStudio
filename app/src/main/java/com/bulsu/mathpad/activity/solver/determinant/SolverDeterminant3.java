package com.bulsu.mathpad.activity.solver.determinant;

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


public class SolverDeterminant3 extends AppCompatActivity {

    TextView tv_ans;
    double[][] var;

    ArrayList<TextView> answer = new ArrayList<>();
    ArrayList<EditText> numbers1 = new ArrayList<>();
    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver_determinant3);


        tv_ans = (TextView) findViewById(R.id.tv_ans);
        linear = (LinearLayout) findViewById(R.id.linear1);


        answer.clear();
        numbers1.clear();
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


    }

    public static double determinant(double[][] matrix){

        int sum=0;
        int s;
        if(matrix.length==1){
            return(matrix[0][0]);
        }
        for(int i=0;i<matrix.length;i++){
            double[][]smaller= new double[matrix.length-1][matrix.length-1];
            for(int a=1;a<matrix.length;a++){
                for(int b=0;b<matrix.length;b++){
                    if(b<i){
                        smaller[a-1][b]=matrix[a][b];
                    }
                    else if(b>i){
                        smaller[a-1][b-1]=matrix[a][b];
                    }
                }
            }
            if(i%2==0){
                s=1;
            }
            else{
                s=-1;
            }
            sum+=s*matrix[0][i]*(determinant(smaller));
        }

        return(sum);
    }

    public void solve1(View v) {
        for (int i = 0; i < 16; i++) {
            if (numbers1.get(i).getText().toString().equals("")) {
                Toast.makeText(SolverDeterminant3.this, "please fill up the blank spaces", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        var = new double[][]
                {{Double.parseDouble(numbers1.get(0).getText().toString()), Double.parseDouble(numbers1.get(1).getText().toString()), Double.parseDouble(numbers1.get(2).getText().toString()),Double.parseDouble(numbers1.get(3).getText().toString())}
                        , {Double.parseDouble(numbers1.get(4).getText().toString()), Double.parseDouble(numbers1.get(5).getText().toString()), Double.parseDouble(numbers1.get(6).getText().toString()),Double.parseDouble(numbers1.get(7).getText().toString())}
                        , {Double.parseDouble(numbers1.get(8).getText().toString()), Double.parseDouble(numbers1.get(9).getText().toString()), Double.parseDouble(numbers1.get(10).getText().toString()),Double.parseDouble(numbers1.get(11).getText().toString())}
                        , {Double.parseDouble(numbers1.get(12).getText().toString()), Double.parseDouble(numbers1.get(13).getText().toString()), Double.parseDouble(numbers1.get(14).getText().toString()),Double.parseDouble(numbers1.get(15).getText().toString())}};
        DecimalFormat df = new DecimalFormat("0");
        DecimalFormat df2 = new DecimalFormat("0.00");
        double answer1 = determinant(var);
        String ansText="";
        if ((answer1 % 1) == 0) {
            ansText = df.format(answer1);
        } else {
            ansText = Fractions.convertDecimalToFraction(answer1);
        }
        tv_ans.setText(ansText);
        linear.setVisibility(View.VISIBLE);
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void clearAllDeterminant4x4(View view) {
        for (int i =0; i< numbers1.size();i++)
        {
            numbers1.get(i).setText("");
        }
        linear.setVisibility(View.GONE);
    }
}
