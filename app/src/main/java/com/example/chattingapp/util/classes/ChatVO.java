package com.example.chattingapp.util.classes;

import android.graphics.drawable.Drawable;

public class ChatVO {
    private Drawable icon ;
    private String chat ;

    public ChatVO(){

    }

    public ChatVO(Drawable newIcon, String newChat){
        icon = newIcon;
        chat = newChat;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon ;
    }
    public void setText(String title) {
        chat = title ;
    }

    public Drawable getIcon() {
        return this.icon;
    }
    public String getText() {
        return this.chat ;
    }

}
