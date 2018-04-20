package com.work4myself.vik.userloginapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText userInfoText;
    EditText pswdInfoText;
    Button saveInfoButton;
    Button displayInfoButton;
    SharedPreferences sharedPreferences;
    TextView displaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInfoText = (EditText) findViewById(R.id.UserId_text);
        userInfoText.setSingleLine();
        pswdInfoText = (EditText) findViewById(R.id.password_text);
        pswdInfoText.setSingleLine();
        saveInfoButton = (Button) findViewById(R.id.save_info_button);
        displayInfoButton = (Button) findViewById(R.id.display_info_button);
        displaTextView = (TextView) findViewById(R.id.display_textview);
        sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
    }

    // method called once "Save Info" button is clicked
    public void saveInfo(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userId", userInfoText.getText().toString());
        editor.putString("password", pswdInfoText.getText().toString());
        editor.apply();
        userInfoText.getText().clear();
        pswdInfoText.getText().clear();
        Toast.makeText(this, "saved!!", Toast.LENGTH_LONG).show();
    }

    // method called once "Display Info" buttton is clicked

    public void displayInfo(View view) {
        String userId = sharedPreferences.getString("userId", "");
        String password = sharedPreferences.getString("password", "");
        displaTextView.setText("userId: "+userId+"\nPassword: "+password);

    }
}
