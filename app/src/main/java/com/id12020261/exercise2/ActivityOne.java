package com.id12020261.exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;


public class ActivityOne extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        final Spinner spinner = (Spinner) findViewById(R.id.Activity_One_Phone_spinner);

        final Button button = (Button) findViewById(R.id.Activity_One_Submit_Button);
        final Button button3 = (Button) findViewById(R.id.Activity_One_Exit_button);
        final Button button2 = (Button) findViewById(R.id.Activity_One_Clear_button);

        final EditText editText = (EditText) findViewById(R.id.Activity_One_Name_editText);
        final EditText editText1 = (EditText) findViewById(R.id.Activity_One_Email_editText);
        final EditText editText2 = (EditText) findViewById(R.id.Activity_One_Phone_editText);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = editText.getText().toString();
                String email = editText1.getText().toString();
                String phone = editText2.getText().toString();
                String phoneType = spinner.getSelectedItem().toString();

                Intent intent=new Intent(ActivityOne.this,ActivityTwo.class);

                intent.putExtra("Name",name);
                intent.putExtra("Email",email);
                intent.putExtra("Phone",phone);
                intent.putExtra("Phone_Type", phoneType);

                Toast.makeText(getApplicationContext(), "Submit button Clicked",
                        Toast.LENGTH_LONG).show();
                construct:startActivityForResult(intent,1);
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.setText("");
                editText1.setText("");
                editText2.setText("");
                spinner.setPrompt("Home");
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_one, menu);
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
 class SpinnerActivity extends Activity implements OnItemSelectedListener {


     public void onItemSelected(AdapterView<?> parent, View view,
                                int pos, long id) {
         // An item was selected. You can retrieve the selected item using
         // parent.getItemAtPosition(pos)
     }

     public void onNothingSelected(AdapterView<?> parent) {
         // Another interface callback
     }

     public void onActivityResult(int requestCode, int resultCode, Intent data) {
         int request_Code = 1;
         if (requestCode == request_Code) {
             if (resultCode == RESULT_OK)
                 Toast.makeText(getApplicationContext(), "you "+data.getData().toString(),
                         Toast.LENGTH_LONG).show();
         }
     }
 }