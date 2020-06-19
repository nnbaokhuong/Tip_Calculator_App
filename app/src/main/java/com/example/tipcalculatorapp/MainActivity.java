package com.example.tipcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    static float percentageValue;

    private Button btnCalculate;
    private Button btnClear;
    private TextView txtTipCalculated;
    private TextView txtTotalCalculated;
    private EditText txtTotalAmount;
    private EditText txtTaxAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTotalAmount = (EditText) findViewById(R.id.editTextNumberDecimalTotalAmount);
        txtTaxAmount = (EditText) findViewById(R.id.editTextNumberDecimalTaxAmount);
        txtTipCalculated = (TextView)findViewById(R.id.textViewCalculatedTip);
        txtTotalCalculated= (TextView)findViewById(R.id.textViewCalculatedTotal);
        btnCalculate = (Button) findViewById(R.id.buttonCalculate);
        btnClear = (Button) findViewById(R.id.buttonClear);
        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        RadioGroup radioGroup =
                (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rb1 =
                (RadioButton) findViewById(R.id.radioButton1);
        RadioButton rb2 =
                (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rbn3 =
                (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rbn4 =
                (RadioButton) findViewById(R.id.radioButton4);
        // Listen for all the button clicks

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Handle clicks here
                // Get a reference to the RadioButton
                // that is currently checked
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                // Switch based on the 'friendly' id
                switch (rb.getId()) {
                    case R.id.radioButton1:
                    // Do something here
                        percentageValue = 0;
                        break;
                    case R.id.radioButton2:
                    // Do something here
                        percentageValue = (float) 0.05;
                        break;
                    case R.id.radioButton3:
                    // Do something here
                        percentageValue = (float) 0.1;
                        break;
                    case R.id.radioButton4:
                    // Do something here
                        percentageValue = (float) 0.2;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + rb.getId());
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonCalculate:
                float temp;
                float temp1;
                try {
                    temp1 = Float.parseFloat(txtTotalAmount.getText().toString());
                    temp = Float.parseFloat(txtTotalAmount.getText().toString())
                            + Float.parseFloat(txtTaxAmount.getText().toString())
                            + Float.parseFloat(txtTotalAmount.getText().toString())*percentageValue;;
                }
                catch (final NumberFormatException e) {
                    temp = 0;
                    temp1 = 0;
                }
                txtTipCalculated.setText("$ " +Float.toString( temp1*percentageValue));
                txtTotalCalculated.setText("$ "+Float.toString(temp));
                break;
            case R.id.buttonClear:
                txtTotalAmount.setText("");
                txtTaxAmount.setText("");
                txtTipCalculated.setText("");
                txtTotalCalculated.setText("");
                break;
        }
    }
}