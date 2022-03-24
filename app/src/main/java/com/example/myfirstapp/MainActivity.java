package com.example.myfirstapp;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Button btnAddInput, btnAddition, btnSubtract, btnDivision, btnMultiply, btnClear;
    private LinearLayout linearLayoutInputs;
    private TextView txtResult;

    ArrayList<EditText> arrEditTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


            btnAddInput.setOnClickListener(new BtnAddEdtTxt());
            btnAddition.setOnClickListener(new btnAdditionListener());
            btnSubtract.setOnClickListener(new btnSubtractListener());
            btnDivision.setOnClickListener(new btnDivisionListener());
            btnMultiply.setOnClickListener(new BtnMultiplyListener());
            btnClear.setOnClickListener(new BtnClearListener());


    }

    private class BtnAddEdtTxt implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText AddEdtTxt = new EditText(MainActivity.this);
            AddEdtTxt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            AddEdtTxt.setTextColor(Color.parseColor("#000000"));
            AddEdtTxt.setHint("Please Enter Input");
            AddEdtTxt.setHintTextColor(Color.parseColor("#696969"));
            AddEdtTxt.setTextSize(20);
            AddEdtTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayoutInputs.addView(AddEdtTxt);
            arrEditTexts.add(AddEdtTxt);
        }
    }

    private class btnAdditionListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            int sum=0;
                for (int i = 0; i < arrEditTexts.size(); i++) {

                    sum = sum + Integer.parseInt(arrEditTexts.get(i).getText().toString());
                }

            txtResult.setText(sum+"");

        }
    }

    private class btnSubtractListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            int sum= Integer.parseInt(arrEditTexts.get(0).getText().toString());
            for (int i = 1; i < arrEditTexts.size(); i++) {

                sum = sum - Integer.parseInt(arrEditTexts.get(i).getText().toString());
            }

            txtResult.setText(sum+"");

        }
    }

    private class btnDivisionListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            float sum=sum= Float.parseFloat(arrEditTexts.get(0).getText().toString());
            for (int i = 1; i < arrEditTexts.size(); i++) {

                sum = sum / Float.parseFloat(arrEditTexts.get(i).getText().toString());
            }

            txtResult.setText(sum+"");

        }
    }

    private class BtnMultiplyListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            double sum=sum= Double.parseDouble(arrEditTexts.get(0).getText().toString());
            for (int i = 1; i < arrEditTexts.size(); i++) {

                sum = sum * Double.parseDouble(arrEditTexts.get(i).getText().toString());
            }

            txtResult.setText(sum+"");

        }
    }

    private class BtnClearListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            EditText removeEdtTxt = new EditText(MainActivity.this);
            for(int i=0; i<arrEditTexts.size(); i++){
                linearLayoutInputs.removeView(arrEditTexts.get(i));
            }
            arrEditTexts.clear();
            txtResult.setText("Please Enter Inputs");
        }
    }

    private void init() {
        btnAddInput = findViewById(R.id.btnAddInput);
        btnAddition = findViewById(R.id.btnAdd);
        btnDivision = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnSubtract = findViewById(R.id.btnSubtract);
        linearLayoutInputs = findViewById(R.id.containerInputs);
        txtResult = findViewById(R.id.txtResult);
        btnClear = findViewById(R.id.btnClear);
    }
}

