package com.example.inclassassignment07_thomass;

import android.app.Activity;
import android.app.Person;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.RADIO;
import static com.example.inclassassignment07_thomass.Keys.GDRSPT;
import static com.example.inclassassignment07_thomass.Keys.PERSON;
import static com.example.inclassassignment07_thomass.Keys.REQUEST_CODE;

public class ReverseActivity extends AppCompatActivity {

    EditText name;
    Button button;
    CheckBox roommate, pet;
    Spinner borough;
    RadioGroup gender, sports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse);
        Toast.makeText(ReverseActivity.this, "Tell me about you", Toast.LENGTH_LONG).show();

        name = (EditText) findViewById(R.id.your_name);
        roommate = findViewById(R.id.roommate);
        pet = findViewById(R.id.pet);
        button = findViewById(R.id.submit);
        gender = findViewById(R.id.radio_gender);
        sports = findViewById(R.id.radio_sports);

        borough = findViewById(R.id.spinner_borough);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.boroughs, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        borough.setAdapter(spinnerAdapter);
    }

    public void SubmitHome(View view) {

        String hasName = name.getText().toString();
        boolean hasRoommate = roommate.isChecked();
        boolean hasPet = pet.isChecked();
        String hasBorough = (String) borough.getSelectedItem();

        RadioGroup gender = (RadioGroup) findViewById(R.id.radio_gender);
        String radio1 = ((RadioButton) findViewById(gender.getCheckedRadioButtonId())).getText().toString();

        RadioGroup hasSports = (RadioGroup) findViewById(R.id.radio_sports);
        String radio2 = ((RadioButton) findViewById(hasSports.getCheckedRadioButtonId())).getText().toString();

        String values = NewYorkerResults(hasName, hasBorough, hasRoommate, hasPet, radio1, radio2);

        Intent reverse = new Intent();
        reverse.putExtra(PERSON, values); // uses key
        setResult(REQUEST_CODE, reverse);
        finish();//launches to activity result - essential!
    }

    private String NewYorkerResults(String name, String hasBorough, boolean hasRoommate, boolean hasPet, String hasGender, String hasSports) { //A method with one locacl variable that is returned with the global variable
        String newYorker = "Name: " + name;
        newYorker = newYorker + "\nHas a roommate: " + hasRoommate;
        newYorker = newYorker + "\nHas a pet: " + hasPet + "\nNYC Borough: " + hasBorough + "\nPreferred gender: " + hasGender + "\nFavorite sports team: " + hasSports;

        return newYorker;
    }
}










/*

        name = findViewById(R.id.your_name);
        String hasName = name.getText().toString();

        roommate = findViewById(R.id.roommate);
        boolean hasRoommates = roommate.isChecked();

        pet = findViewById(R.id.pet);
        boolean hasPet = roommate.isChecked();

        borough = findViewById(R.id.spinner_borough);

        String hasBorough = (String) borough.getSelectedItem();
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.boroughs, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        borough.setAdapter(spinnerAdapter);

        final String theResults = NewYorkerResults(hasName, hasBorough, hasRoommates);


        Intent newYoker = new Intent(ReverseActivity.this, MainActivity.class);
        newYoker.putExtra(Keys.PERSON, hasName);
        setResult(RESULT_OK, newYoker);
        finish();
    }

*/







