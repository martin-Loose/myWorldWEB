/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Views;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="chatRoomDetails")
@RequestScoped
public class ChatRoomDetailsView {
  private int chatID;
private String chatRoomName;



    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }




}
