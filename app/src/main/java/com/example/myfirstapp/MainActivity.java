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


    private Button btnAddInput, btnAddition, btnSubtract, btnDivision, btnMultiply;
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


    }

    private class BtnAddEdtTxt implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText addInputs = new EditText(MainActivity.this);
            addInputs.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            addInputs.setTextColor(Color.parseColor("#000000"));
            addInputs.setHint("Please Enter Input");
            addInputs.setHintTextColor(Color.parseColor("#696969"));
            addInputs.setTextSize(20);
            addInputs.setInputType(InputType.TYPE_CLASS_NUMBER);
            linearLayoutInputs.addView(addInputs);
            arrEditTexts.add(addInputs);
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

            int sum=sum= Integer.parseInt(arrEditTexts.get(0).getText().toString());
            for (int i = 1; i < arrEditTexts.size(); i++) {

                sum = sum * Integer.parseInt(arrEditTexts.get(i).getText().toString());
            }

            txtResult.setText(sum+"");

        }
    }

    private void init() {
        btnAddInput = findViewById(R.id.addInput);
        btnAddition = findViewById(R.id.btnAdd);
        btnDivision = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnSubtract = findViewById(R.id.btnSubtract);
        linearLayoutInputs = findViewById(R.id.Inputs);
        txtResult = findViewById(R.id.txtResult);
    }
}

