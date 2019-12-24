package com.example.shared_prefernces_yodalef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    /**
     * @since 11/12/2019
     * The onCreate check the last data the user entered
     */
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

    /**
     * @since 11/12/2019
     * The method is onClick that count the clicks of the user on the button
     */
    public void lets_Count(View view) {
        count++;
        tv.setText("The number of clicks: "+count);
    }

    /**
     * @since 11/12/2019
     * The method reset the number of clicks the user did.
     */
    public void Reset(View view) {
        count=0;
        tv.setText("The number of clicks: "+count);
    }

    /**
     * @since 11/12/2019
     * The method close the application and save the data of the user
     */
    public void End_App(View view) {
        st=et.getText().toString();
        SharedPreferences number = getSharedPreferences("count",MODE_PRIVATE);
        SharedPreferences.Editor editor= number.edit();
        editor.putInt("Number",count);
        editor.putString("Word",st);
        editor.commit();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent si = new Intent(this,Credits.class);
        startActivity(si);
        return true;
    }
}
