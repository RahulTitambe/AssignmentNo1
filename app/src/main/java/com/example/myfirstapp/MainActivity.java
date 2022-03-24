package com.example.myfirstapp;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAddInput, btnAdd, btnSubtract, btnDivide, btnMultiply;
    private LinearLayout Inputs;
    private TextView txtResult;
    private EditText Input1, Input2;
    int ans;

    ArrayList<EditText> arrEditTexts = new ArrayList<>();
    ArrayList<String> arrValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddInput = findViewById(R.id.addInput);
        btnAdd = findViewById(R.id.btnAdd);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        Inputs = findViewById(R.id.Inputs);
        txtResult = findViewById(R.id.txtResult);
        Input1 = findViewById(R.id.edtFirstInput);
        Input2 = findViewById(R.id.edtSecondInput);


        btnAddInput.setOnClickListener(new AddInputs());
        btnAdd.setOnClickListener(new btnAdd());

    }

    private class AddInputs implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText addInputs = new EditText(MainActivity.this);
            addInputs.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            addInputs.setTextColor(Color.parseColor("#000000"));
            addInputs.setHint("Please Enter Input");
            addInputs.setHintTextColor(Color.parseColor("#696969"));
            addInputs.setTextSize(20);
            addInputs.setInputType(InputType.TYPE_CLASS_NUMBER);
            Inputs.addView(addInputs);
            arrEditTexts.add(addInputs);
        }
    }

    private class btnAdd implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            if(arrEditTexts.size() == 0) {

                double num1 = Double.parseDouble(Input1.getText().toString());
                double num2 = Double.parseDouble(Input1.getText().toString());
                double sum = num1 + num2;
                txtResult.setText(Double.toString(sum));

            }
            else {
                int sum = 0
                for (int i = 0; i <= arrEditTexts.size(); i++) {
                    sum = sum + Integer.parseInt( arrEditTexts.get(i).getText().toString() );
                }
                txtResult.setText(sum + "");
            }
        }
    }
}

