package com.example.chattingapp.services.impl;

import com.example.chattingapp.datamodel.Repo.SenderReceiverRelationRepo;
import com.example.chattingapp.datamodel.SenderReceiverRelation;
import com.example.chattingapp.domain.MessageDTO;
import com.example.chattingapp.domain.inbound.MessageDTOIn;
import com.example.chattingapp.services.IMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MessageServiceImpl implements IMessageService {
    @Autowired
    SenderReceiverRelationRepo senderReceiverRelationRepo;
//    @Autowired
//    ReceiverSenderRelationRepo receiverSenderRelationRepo;

    @Override
    public List<MessageDTO> showAllMessages() {
        return senderReceiverRelationRepo.findAllMessages();
    }

    @Override
    public void sendMessage(MessageDTOIn messageDTOIn) {
        SenderReceiverRelation senderReceiverRelation = new SenderReceiverRelation();
        senderReceiverRelation.setSenderId(messageDTOIn.getSenderId());
        senderReceiverRelation.setReceiverId(messageDTOIn.getReceiverId());
        senderReceiverRelation.setMessage(messageDTOIn.getMessage());
        senderReceiverRelationRepo.save(senderReceiverRelation);

    }

    @Override
    public MessageDTO showMessages(String senderId) {
        //SenderReceiverRelationDTO senderReceiverRelationDTO = new SenderReceiverRelationDTO();
        Optional<SenderReceiverRelation> senderReceiverRelation= Optional.ofNullable(senderReceiverRelationRepo.findBySenderId(senderId));
        ModelMapper modelMapper = new ModelMapper();
        MessageDTO mrr = modelMapper.map(senderReceiverRelation,MessageDTO.class);
        return mrr;
    }

    @Override
    public List<MessageDTO> showMsgs(String userId) {
        return senderReceiverRelationRepo.findByMessageDTO(userId);


    }

    @Override
    public void receiveMessage(MessageDTOIn messageDTOIn) {


        SenderReceiverRelation senderReceiverRelation = new SenderReceiverRelation();
        senderReceiverRelation.setSenderId(messageDTOIn.getSenderId());
        senderReceiverRelation.setReceiverId(messageDTOIn.getReceiverId());
        senderReceiverRelation.setMessage(messageDTOIn.getMessage());
        senderReceiverRelationRepo.save(senderReceiverRelation);

    }


    @Override
    public List<MessageDTO> showAllMsgs(String senderId,String receiverId) {
        return senderReceiverRelationRepo.findMessageDTOBySenderId(senderId,receiverId);
    }


}
