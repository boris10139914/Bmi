package com.tom.bmi;

import android.content.Intent;
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
    private EditText edWeight;
    private EditText edHeight;
    private Button btnHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getResources().getString(R.string.app_name);//"bmi"
        findViews();
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//匿名類別
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("xxx")
                        .setMessage("Bmi說明:.....")
                        .setNeutralButton(R.string.OK, null
                        )
                        .show();


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onCreate");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onCreate");
    }

    private void findViews() {//抽出去變方法
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
        btnHelp = (Button) findViewById(R.id.b_help);
    }

    public void bmi(View view) {
        //Log.d("MainActivity","testing bmi method");

        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height * height);

        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.Your_bmi_is) + bmi)
                .setTitle(R.string.bmi_title)
                .setNeutralButton(R.string.OK, null)//按ok之後不做事情+null
                .show();
        // Log.d("MainActivity","Your bmi is"+bmi);
        // Toast.makeText(this,"Your BMI is:"+bmi,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.exrta_bmi), 0);

        startActivity(intent);
    }
}
