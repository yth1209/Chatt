package com.example.chattingapp.util.classes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chattingapp.R;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ChatVO> chatDataList;
    private LayoutInflater inflater;


    public ChatAdapter(Context applicationContext, int talklist, ArrayList<ChatVO> list){
        this.context = applicationContext;
        this.layout = talklist;
        this.chatDataList = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return chatDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return chatDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.chat_view, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ChatVO chatData = chatDataList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(chatData.getIcon());
        titleTextView.setText(chatData.getText());

        return convertView;
    }

    public void add(Drawable icon, String chat){
        ChatVO newChatData = new ChatVO(icon, chat);

        chatDataList.add(newChatData);
    }
}
