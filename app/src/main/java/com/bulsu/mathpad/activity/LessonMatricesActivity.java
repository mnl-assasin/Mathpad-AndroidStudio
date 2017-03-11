package com.bulsu.mathpad.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bulsu.mathpad.R;

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
    }

    @OnClick({R.id.btnMatrices, R.id.btnMatrices2, R.id.btnMatrices3, R.id.btnMatrices4, R.id.btnMatrices5, R.id.btnMatrices6, R.id.btnMatrices7})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMatrices:
                break;
            case R.id.btnMatrices2:
                break;
            case R.id.btnMatrices3:
                break;
            case R.id.btnMatrices4:
                break;
            case R.id.btnMatrices5:
                break;
            case R.id.btnMatrices6:
                break;
            case R.id.btnMatrices7:
                break;
        }
    }
}
