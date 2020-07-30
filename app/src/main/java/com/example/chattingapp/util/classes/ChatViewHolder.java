package com.example.chattingapp.util.classes;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chattingapp.R;

public class ChatViewHolder {
    ImageView iconImageView;
    TextView nameTextView;
    TextView titleTextView;

    public void bind(Drawable icon, String user, String chat){
        iconImageView.setImageDrawable(icon);
        nameTextView.setText(user);
        titleTextView.setText(chat);
    }
}
