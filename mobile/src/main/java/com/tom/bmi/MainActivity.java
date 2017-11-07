package com.tom.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getResources().getString(R.string.app_name);//"bmi"
        Button btnHelp = (Button)findViewById(R.id.b_help);
        btnHelp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {//匿名類別
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("xxx")
                        .setMessage("Bmi說明:.....")
                        .setNeutralButton(R.string.OK,null
                        )
                        .show();

            }
        });}

    public  void bmi(View view){
        //Log.d("MainActivity","testing bmi method");
        EditText edWeight =(EditText)findViewById(R.id.ed_weight);
        EditText edHeight =(EditText)findViewById(R.id.ed_height);
        float weight =Float.parseFloat(edWeight.getText().toString());
        float height =Float.parseFloat(edHeight.getText().toString());
        float bmi = weight/(height*height);
new AlertDialog.Builder(this)
        .setMessage(getString(R.string.Your_bmi_is)+bmi)
        .setTitle(R.string.bmi_title)
        .setNeutralButton(R.string.OK,null)//按ok之後不做事情+null
        .show();
       // Log.d("MainActivity","Your bmi is"+bmi);
       // Toast.makeText(this,"Your BMI is:"+bmi,Toast.LENGTH_LONG).show();
}}
