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
        if( planetAnswer() && countriesInNA() && getCanadaCapital() && getUsaStatesNumber()){
            Toast.makeText(this, getString(R.string.awesome_job), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.google_time), Toast.LENGTH_LONG).show();
        }
    }

    private boolean planetAnswer() {
        int checkedId = mQ1RadioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.earth) {
            return true;
        } else {
            return false;
        }
    }

    private boolean countriesInNA() {
        if (mCheckboxCanada.isChecked() && mCheckboxUsa.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean getCanadaCapital(){
        if(mCanadaCapital.getText().toString().equalsIgnoreCase(CANADA_CAPITAL) ){
            return true;
        } else {
            return false;
        }
    }

    private boolean getUsaStatesNumber(){
        if(mUsaStates.getText().toString().equalsIgnoreCase(USA_STATES)){
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
