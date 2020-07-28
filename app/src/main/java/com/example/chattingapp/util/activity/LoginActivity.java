package com.example.chattingapp.util.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chattingapp.R;
import com.example.chattingapp.util.classes.Code;

public class LoginActivity extends AppCompatActivity {

    private Button logButton;
    private Button regButton;
    private EditText idText;
    private EditText pwdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logButton = findViewById(R.id.buttonLogin);
        regButton = findViewById(R.id.buttonReg);
        idText = findViewById(R.id.editTextLogin);
        pwdText = findViewById(R.id.editTextPassword);


    }

    public void logButtonClicked(View view){
        String id = idText.getText().toString();
        String pwd = pwdText.getText().toString();
        if(id.equals("yth1209") && pwd.equals("sd001209")){
            Intent resultIntent = new Intent();
            resultIntent.putExtra("ID",id);
            setResult(Code.resultCode, resultIntent);
            finish();
        }
    }
}