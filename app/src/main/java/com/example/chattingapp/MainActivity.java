package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> array = new ArrayList<>();

    private EditText aft;
    private Button afb;
    private ArrayAdapter adapter;
    private ListView flist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aft = findViewById(R.id.addFriendEditText);
        afb = findViewById(R.id.addFriendButton);
        flist = findViewById(R.id.friendList);

        array.add("김우주");
        array.add("신현수");
        array.add("이준석");

        adapter  = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array) ;

        flist.setAdapter(adapter);

    }

    public void clicked_addFriendButton(View view){
        array.add(aft.getText().toString());
        adapter.notifyDataSetChanged();
        aft.setText("");
        return;
    }
}