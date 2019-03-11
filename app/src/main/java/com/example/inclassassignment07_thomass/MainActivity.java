package com.example.inclassassignment07_thomass;

import android.app.Activity;
import android.app.Person;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.inclassassignment07_thomass.Keys.PERSON;
import static com.example.inclassassignment07_thomass.Keys.REQUEST_CODE;


public class MainActivity extends AppCompatActivity {


    TextView outPut;
    Button reverse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_LONG).show();

        outPut = findViewById(R.id.output);
        reverse = findViewById(R.id.main_button);
    }

    public void Message(View view) {
        Intent click = new Intent(this, ReverseActivity.class); //connecting the classes
        //outPut.getText().toString();
        startActivityForResult(click, REQUEST_CODE); //This is the 11 that I declared in Keys interface
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (REQUEST_CODE == 11) {
            //if (requestCode == RESULT_OK) { //-1 value
            if (data != null) { //object check
                String outCome = data.getStringExtra(PERSON); //Key
                outPut.setText(outCome);
            }
        }


    }
}


// });

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE&&requestCode==RESULT_OK && data!= null){ //if three conditions are true this will happen
            String radioChoice = data.getStringExtra("group");
            outPut.setText(radioChoice);
    }
}}



    private void display() {
        reverse = findViewById(R.id.main_button);
        outPut = findViewById(R.id.output);
    }
*/

/*
    public void addPerson(View view) {
        Intent intent = new Intent(this, ReverseActivity.class);
        startActivityForResult(intent, Keys.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Keys.REQUEST_CODE && resultCode == RESULT_OK) {
            EditText person = (EditText) data.getSerializableExtra(Keys.PERSON);
            person.setText(person.toString());
        }
    }



    public void Home(){
        reverse = findViewById(R.id.main_button);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReverseActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode==RESULT_OK){
                String result = data.getStringExtra("name");

            }
        }
    }


    reverse = findViewById(R.id.main_button);
        outPut = findViewById(R.id.output);


        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReverseActivity.class);
                startActivity(intent);
            }
        });
    }










        reverse = findViewById(R.id.main_button);
        results = findViewById(R.id.output);


        animal = findViewById(R.id.the_animal);

        theAnimalName = getIntent().getExtras().getString("answer");

        animal.setText(theAnimalName);

        home = findViewById(R.id.the_home);
        results = getIntent().getExtras().getString("home");
        home.setText(theAnimalHome + " habitat is the animal's home");


        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reverseClass = new Intent(MainActivity.this, ReverseActivity.class);
                startActivity(reverseClass);
            }
        });

    }*/

