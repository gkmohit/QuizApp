package com.mohitkishore.www.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String CANADA_CAPITAL = "Ottawa";
    private static final String USA_STATES = "50";
    private static final String YOU_SCORED = "You scored ";
    private static final int TOTAL_NUMBER_OF_QUESTIONS = 4;

    private static int mScore = 0;
    RadioGroup mQ1RadioGroup;
    CheckBox mCheckboxCanada;
    CheckBox mCheckboxPeru;
    CheckBox mCheckboxUsa;
    EditText mCanadaCapital;
    EditText mUsaStates;
    Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        setListeners();


    }

    private void initViews() {
        mQ1RadioGroup = (RadioGroup) findViewById(R.id.q1_radio_group);
        mCheckboxCanada = (CheckBox) findViewById(R.id.checkbox_canada);
        mCheckboxPeru = (CheckBox) findViewById(R.id.checkbox_peru);
        mCheckboxUsa = (CheckBox) findViewById(R.id.checkbox_usa);
        mCanadaCapital = (EditText) findViewById(R.id.canada_capital_et);
        mUsaStates = (EditText) findViewById(R.id.us_states_et);
        mSubmitButton = (Button) findViewById(R.id.submit_button);
    }

    private void setListeners() {
        mSubmitButton.setOnClickListener(this);
    }

    private void submitAnswers() {
        boolean answer1 = planetAnswer();
        boolean answer2 = countriesInNA();
        boolean answer3 = getCanadaCapital();
        boolean answer4 = getUsaStatesNumber();
        if (answer1 && answer2 && answer3 && answer4) {
            makeToast(getString(R.string.awesome_job) + YOU_SCORED + mScore + "/" + TOTAL_NUMBER_OF_QUESTIONS);
        } else {
            makeToast(getString(R.string.google_time) + YOU_SCORED + mScore + "/" + TOTAL_NUMBER_OF_QUESTIONS);
        }
        mScore = 0;
    }

    private void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private boolean planetAnswer() {
        int checkedId = mQ1RadioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.earth) {
            mScore++;
            return true;
        } else {
            return false;
        }
    }

    private boolean countriesInNA() {
        if (mCheckboxCanada.isChecked() && mCheckboxUsa.isChecked() && !mCheckboxPeru.isChecked()) {
            mScore++;
            return true;
        } else {
            return false;
        }
    }

    private boolean getCanadaCapital() {
        String answer = mCanadaCapital.getText().toString().trim();
        if (answer.equalsIgnoreCase(CANADA_CAPITAL.trim())) {
            mScore++;
            return true;
        } else {
            return false;
        }
    }

    private boolean getUsaStatesNumber() {
        String answer = mUsaStates.getText().toString().trim();
        if (answer.equalsIgnoreCase(USA_STATES.trim())) {
            mScore++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit_button: {
                submitAnswers();
            }
        }
    }
}
