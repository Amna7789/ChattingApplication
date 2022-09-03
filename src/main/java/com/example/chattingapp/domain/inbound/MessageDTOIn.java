package com.example.chattingapp.domain.inbound;

import com.example.chattingapp.domain.MessageDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDTOIn extends MessageDTO {
    String senderId;
    String receiverId;
    String message;

    public MessageDTOIn(String senderId, String receiverId, String message) {
        super(senderId, receiverId, message);
    }
}
