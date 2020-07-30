package com.example.chattingapp.util.classes;

import android.graphics.drawable.Drawable;

public class ChatVO {
    private Drawable icon ;
    private String chat ;
    private String name;

    public ChatVO(){

    }

    public ChatVO(Drawable newIcon, String name, String newChat){
        this.name = name;
        icon = newIcon;
        chat = newChat;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon ;
    }
    public void setText(String title) {
        chat = title ;
    }
    public void setName(String newname){
        name = newname;
    }

    public Drawable getIcon() {
        return this.icon;
    }
    public String getText() {
        return this.chat ;
    }

    public String getName(){
        return this.name;
    }
}
