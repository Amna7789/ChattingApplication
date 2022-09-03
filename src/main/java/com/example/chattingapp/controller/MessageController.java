package com.example.chattingapp.controller;

import com.example.chattingapp.controller.annotation.Validation;
import com.example.chattingapp.domain.MessageDTO;

import com.example.chattingapp.domain.inbound.MessageDTOIn;

import com.example.chattingapp.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    IMessageService messageService;
    //chal rhi
    @GetMapping("senderReceiver/allMessages")
    public List<MessageDTO> showMessages(){
        return messageService.showAllMessages();

    }
    //chal rhi
    @Validation(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("senderReceiver/sendMessages")
    public void sendMessages(@RequestBody MessageDTOIn messageDTOIn){
        messageService.sendMessage(messageDTOIn);
    }
    /*@Validation(value = "")
    @GetMapping("senderReceiver/{senderId}")
    public MessageDTO showUserMessages(@PathVariable("senderId")String senderId){
        return messageService.showMessages(senderId);

    }*/
    //chal rha but ek msg show kr rha sender ka, receive ka b try krna amna, sir se puchna
    @GetMapping("sender/{userId}")
    public List<MessageDTO> showUserMsgs(@PathVariable("userId")String userId){
        return messageService.showMsgs(userId);

    }

    //chal gya mas haa allah, you are genius amna :-)
    @ResponseStatus(HttpStatus.CREATED)
    @Validation(value = "")
    @PostMapping("senderReceiver/receiveMessages")
    public void receiveMessages( @RequestBody MessageDTOIn messageDTOIn){
        messageService.receiveMessage(messageDTOIn);

    }
   //chal rha likin receiver k time receiver query uncomment rkhna amna, dsri sender vali comment out kr dena qk same hain
    @GetMapping("receiver/{userId}")
    public List<MessageDTO> showUserReceivedMsgs(@PathVariable("userId")String userId){
        return messageService.showMsgs(userId);

    }
    @Validation(value = "")
    //iski query thek krni hai
    @GetMapping("particularUser/allMsgs")
    public List<MessageDTO> showAllUserMsgs(@RequestParam("senderId")String senderId,
                                            @RequestParam("receiverId")String receiverId){
        return messageService.showAllMsgs(senderId,receiverId);



    }




}
