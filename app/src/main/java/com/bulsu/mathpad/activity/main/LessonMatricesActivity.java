package com.bulsu.mathpad.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.bulsu.mathpad.R;
import com.bulsu.mathpad.activity.lesson.matrices.EchelonFormMatrixActivity;
import com.bulsu.mathpad.activity.lesson.matrices.GaussianGaussJordanActivity;
import com.bulsu.mathpad.activity.lesson.matrices.LinearSystemInversesActivity;
import com.bulsu.mathpad.activity.lesson.matrices.MatricesAndMatrixActivity;
import com.bulsu.mathpad.activity.lesson.matrices.NonsingularMatricesActivity;
import com.bulsu.mathpad.activity.lesson.matrices.SpecialTypeMatrixActivity;
import com.bulsu.mathpad.activity.lesson.matrices.TransposeMatrixActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LessonMatricesActivity extends AppCompatActivity {

    @Bind(R.id.btnMatrices)
    Button btnMatrices;
    @Bind(R.id.btnMatrices2)
    Button btnMatrices2;
    @Bind(R.id.btnMatrices3)
    Button btnMatrices3;
    @Bind(R.id.btnMatrices4)
    Button btnMatrices4;
    @Bind(R.id.btnMatrices5)
    Button btnMatrices5;
    @Bind(R.id.btnMatrices6)
    Button btnMatrices6;
    @Bind(R.id.btnMatrices7)
    Button btnMatrices7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_matrices);
        ButterKnife.bind(this);

        setTitle("Matrices");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btnMatrices, R.id.btnMatrices2, R.id.btnMatrices3, R.id.btnMatrices4, R.id.btnMatrices5, R.id.btnMatrices6, R.id.btnMatrices7})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMatrices:
                startActivity(new Intent(getApplicationContext(), MatricesAndMatrixActivity.class));
                break;
            case R.id.btnMatrices2:
                startActivity(new Intent(getApplicationContext(), TransposeMatrixActivity.class));
                break;
            case R.id.btnMatrices3:
                startActivity(new Intent(getApplicationContext(), SpecialTypeMatrixActivity.class));
                break;
            case R.id.btnMatrices4:
                startActivity(new Intent(getApplicationContext(), NonsingularMatricesActivity.class));
                break;
            case R.id.btnMatrices5:
                startActivity(new Intent(getApplicationContext(), LinearSystemInversesActivity.class));
                break;
            case R.id.btnMatrices6:
                startActivity(new Intent(getApplicationContext(), EchelonFormMatrixActivity.class));
                break;
            case R.id.btnMatrices7:
                startActivity(new Intent(getApplicationContext(), GaussianGaussJordanActivity.class));
                break;
        }
    }
}
