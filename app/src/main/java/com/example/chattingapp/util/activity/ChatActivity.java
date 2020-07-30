package com.example.chattingapp.util.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;

import com.example.chattingapp.MainActivity;
import com.example.chattingapp.R;
import com.example.chattingapp.util.classes.ChatAdapter;
import com.example.chattingapp.util.classes.ChatVO;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private ArrayList<ChatVO> cArray;
    private ListView clist;
    private EditText act;
    private Button acb;
    private ChatAdapter adapter;
    private String user_id;
    private String friend_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        cArray = new ArrayList<ChatVO>();

        adapter = new ChatAdapter(this, R.layout.chat_view, cArray);
        clist = findViewById(R.id.chatList);
        act = findViewById(R.id.editTextAddChat);
        acb = findViewById(R.id.buttonAddChat);

        adapter.add(ContextCompat.getDrawable(this, R.drawable.user1), "유태현","너 병신이야?너 병신이야?너 병신이야?너 병신이야?너 병신이야?너 병신이야?너 병신이야?");
        adapter.add(ContextCompat.getDrawable(this, R.drawable.user2), "김우주", "응 맞아!");

        clist.setAdapter(adapter);

        Intent intent = getIntent();
        user_id = intent.getStringExtra(MainActivity.EXTRA_USER);
        friend_id = intent.getStringExtra(MainActivity.EXTRA_FRIEND);




    }
}