package com.example.chattingapp.services;

import com.example.chattingapp.domain.MessageDTO;
import com.example.chattingapp.domain.inbound.MessageDTOIn;

import java.util.List;

public interface IMessageService {
   public List<MessageDTO> showAllMessages();


  public void sendMessage(MessageDTOIn messageDTOIn);

   public MessageDTO showMessages(String senderId);

   public List<MessageDTO> showMsgs(String userId);

    public void receiveMessage(MessageDTOIn messageDTOInDTOIn);

   public List<MessageDTO> showAllMsgs(String senderId, String receiverId);


}
