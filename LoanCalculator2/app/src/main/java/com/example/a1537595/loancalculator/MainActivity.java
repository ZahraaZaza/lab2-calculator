package com.example.a1537595.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import abcbank.LoanCalculator;

public class MainActivity extends AppCompatActivity {
    EditText etLoanAmount, etNumYears, etIntrstNum;
    TextView  monthlyPayRes, totPayRes, totIntrstRes;
    LoanCalculator loanCalculator = new LoanCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLoanAmount = (EditText) findViewById(R.id.loanAmount);
        etNumYears = (EditText) findViewById(R.id.numOfYears);
        etIntrstNum = (EditText) findViewById(R.id.intrstNum);

        monthlyPayRes = (TextView) findViewById(R.id.monthlyPayResult);
        totPayRes = (TextView) findViewById(R.id.totPayResult);
        totIntrstRes = (TextView) findViewById(R.id.totIntrstResult);
    }

    public void calculate(View v){
        DecimalFormat num = new DecimalFormat("#,###.00");

        //accept the required input (assumes valid input)
        double loanAmount = Double.parseDouble(etLoanAmount.getText().toString());
        int numberOfYears = Integer.parseInt(etNumYears.getText().toString());
        double yearlyInterestRate = Double.parseDouble(etIntrstNum.getText().toString());

        loanCalculator.setLoanAmount(loanAmount);
        loanCalculator.setNumberOfYears(numberOfYears);
        loanCalculator.setYearlyInterestRate(yearlyInterestRate);

        //display the output
        monthlyPayRes.setText(num.format(loanCalculator.getMonthlyPayment()));
        totPayRes.setText(num.format(loanCalculator.getTotalCostOfLoan()));
        totIntrstRes.setText(num.format(loanCalculator.getTotalInterest()));
    }

    public void clearData(View v){
        etLoanAmount.setText("");
        etNumYears.setText("");
        etIntrstNum.setText("");

        monthlyPayRes.setText("");
        totPayRes.setText("");
        totIntrstRes.setText("");
    }
}
