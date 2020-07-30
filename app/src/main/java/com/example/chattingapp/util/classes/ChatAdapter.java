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

    ChatViewHolder holder;

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
            holder = new ChatViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.nameTextView = (TextView)convertView.findViewById(R.id.textViewUsername);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.textViewChat);

            convertView.setTag(holder);
        }
        else{
          holder= (ChatViewHolder) convertView.getTag();
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ChatVO chatData = chatDataList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        holder.bind(chatData.getIcon(),chatData.getName(), chatData.getText());

        return convertView;
    }

    public void add(Drawable icon, String name, String chat){
        ChatVO newChatData = new ChatVO(icon, name, chat);

        chatDataList.add(newChatData);
    }
}
