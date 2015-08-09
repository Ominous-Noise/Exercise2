package com.id12020261.exercise2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.CheckBox;
import android.app.Activity;


public class ActivityTwo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        final Button button = (Button) findViewById(R.id.Activity_Two_Submit_button);

        final TextView editText1 = (TextView) findViewById(R.id.Activity_Two_Name_textView);
        final TextView editText2 = (TextView) findViewById(R.id.Activity_Two_Phone_textView);
        final TextView editText3 = (TextView) findViewById(R.id.Activity_Two_Phone_type_textView);
        final TextView editText4 = (TextView) findViewById(R.id.Activity_Two_Email_textView);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.Activity_Agree_checkBox);


        Intent intent = getIntent();

        final String isChecked;

        editText1.setText(intent.getStringExtra("Name"));
        editText2.setText(intent.getStringExtra("Email"));
        editText3.setText(intent.getStringExtra("Phone"));
        editText4.setText(intent.getStringExtra("Phone_Type"));


        if (checkBox.isChecked()) {
            isChecked = "I Agree";
        }else{
            isChecked ="I Disagree";
        }


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();

                resultIntent.putExtra("checkBox", isChecked );

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_two, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



