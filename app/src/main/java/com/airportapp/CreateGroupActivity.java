package com.airportapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
//import com.parse.Parse;
//import com.parse.ParseAnalytics;
=======
import android.view.View;
import android.widget.Button;
>>>>>>> d26c9146fa42e0733ea59844be29ce552ea1ce70


public class CreateGroupActivity extends Activity implements View.OnClickListener {

    Button createGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Parse.initialize(this, "JFLuGOh9LQsqGsbVwuunD9uSSXgp8hDuDGBgHguJ", "0x2FoxHDKmIF81PqcK0wuh8OS8Ga2FsM6RTUmmcu");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        // Access the Button defined in login XML
        // and listen for it here
        createGroupButton = (Button) findViewById(R.id.viewGroup_button);
        createGroupButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent clickCreateGroup = new Intent(CreateGroupActivity.this, ViewGroupActivity.class);
        startActivity(clickCreateGroup);
    }

}
