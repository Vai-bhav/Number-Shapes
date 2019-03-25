package com.example.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
        int number;
        public boolean isSquare(){
            double sr=Math.sqrt(number);
            if(sr==Math.floor(sr)){
                return true;
            }else{
                return false;
            }

        }
        public boolean isTriangular(){
            int x=1;
            int triNum=1;
            while(triNum<number){
                x++;
                triNum+=x;
            }
            if(triNum==number){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void testNumber(View view){

        Log.i("Info","Clicked");

        EditText editText = (EditText) findViewById(R.id.editText);

        String message;

        if(editText.getText().toString().isEmpty()){

            message = "Please enter a number";

        }
        else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());

            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message = editText.getText().toString() + " is both square and triangulat number";
            } else if (myNumber.isSquare()) {
                message = editText.getText().toString() + " is a square number but not a triangular number";
            } else if(myNumber.isTriangular()){
                message = editText.getText().toString() + " is a triangular number but not a square number";
            }else{
                message = editText.getText().toString() + " is neither square nor triangular number";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}