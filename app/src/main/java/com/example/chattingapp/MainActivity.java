package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.chattingapp.util.activity.ChatActivity;
import com.example.chattingapp.util.classes.Code;
import com.example.chattingapp.util.activity.LoginActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "com.example.chattingapp.user";
    public static final String EXTRA_FRIEND = "com.example.chattingapp.friend";

    private ArrayList<String> array = new ArrayList<>();

    private EditText aft;
    private Button afb;
    private ArrayAdapter adapter;
    private ListView flist;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aft = findViewById(R.id.addFriendEditText);
        afb = findViewById(R.id.addFriendButton);
        flist = findViewById(R.id.friendList);



        Intent intent_login = new Intent(MainActivity.this, LoginActivity.class);
        startActivityForResult(intent_login, Code.requestCode);



        flist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long i) { // view:클릭한 뷰 position:index id:position이랑 일반적으로 같다
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                String message = array.get(position).toString();
                intent.putExtra(EXTRA_USER, id);
                intent.putExtra(EXTRA_FRIEND, message);
                startActivity(intent);
            }
        });

        //친구 삭제기능
        flist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                showRemoveFriendBuilder(position);
                return true;
            }
        });

    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent resultIntent) {
        super.onActivityResult(requestCode, resultCode, resultIntent);
        if (requestCode == Code.requestCode && resultCode == Code.resultCode) {
            id = resultIntent.getStringExtra("ID");
            if(id.equals("yth1209")) {
                array.add("김우주");
                array.add("신현수");
                array.add("이준석");
            }

            adapter  = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array) ;

            flist.setAdapter(adapter);
        }

    }

    public void clicked_addFriendButton(View view){
        array.add(aft.getText().toString());
        adapter.notifyDataSetChanged();
        aft.setText("");
    }

    public void showRemoveFriendBuilder(int i){
        final int position = i;
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("삭제하기");
        builder.setMessage(array.get(position).toString()+"를 친구목록에서 삭제하시겠습니까?");

        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                array.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();

    }


}