package com.example.shared_prefernces_yodalef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Dvir Dadon
 * @since 11/12/2019
 */

public class MainActivity extends AppCompatActivity {
    int count=0;
    TextView tv;
    EditText et;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.tv);
        et=findViewById(R.id.et);
        SharedPreferences number = getSharedPreferences("count",MODE_PRIVATE);
        count = number.getInt("Number",0);
        st = number.getString("Word","");
        et.setText(st);
        tv.setText("The number of clicks: "+count);
    }

    public void lets_Count(View view) {
        count++;
        tv.setText("The number of clicks: "+count);
    }

    public void Reset(View view) {
        count=0;
        tv.setText("The number of clicks: "+count);
    }

    public void End_App(View view) {
        st=et.getText().toString();
        SharedPreferences number = getSharedPreferences("count",MODE_PRIVATE);
        SharedPreferences.Editor editor= number.edit();
        editor.putInt("Number",count);
        editor.putString("Word",st);
        editor.commit();
        finish();
    }
}
