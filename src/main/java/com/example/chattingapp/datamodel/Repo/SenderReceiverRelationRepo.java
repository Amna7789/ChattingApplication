package com.example.chattingapp.datamodel.Repo;

import com.example.chattingapp.datamodel.SenderReceiverRelation;
import com.example.chattingapp.domain.MessageDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SenderReceiverRelationRepo extends PagingAndSortingRepository<SenderReceiverRelation,String> {
    @Query("select new com.example.chattingapp.domain.MessageDTO(senderId, receiverId, message) from SenderReceiverRelation")
    List<MessageDTO> findAllMessages();

    SenderReceiverRelation findBySenderId(@Param("senderId") String senderId);
     /*@Query("select new com.example.chattingapp.domain.MessageDTO(senderId, receiverId,message)from SenderReceiverRelation where senderId = :userId")

    List<MessageDTO> findByMessageDTO(@Param("userId")String userId);*/
    @Query("select new com.example.chattingapp.domain.MessageDTO(senderId,receiverId,message)from SenderReceiverRelation where receiverId = :userId")
    List<MessageDTO> findByMessageDTO(@Param("userId")String userId);

/*    @Query("select new com.example.chattingapp.domain.MessageDTO(senderId,receiverId,message)from SenderReceiverRelation s where s.senderId =:senderId OR s.receiverId = :receiverId  ")
    List<MessageDTO> findMessageDTOBySenderId(String senderId,String receiverId);*/
/*@Query("select new com.example.chattingapp.domain.MessageDTO(senderId,receiverId,message)from SenderReceiverRelation s where s.senderId =:senderId OR s.receiverId = :receiverId AND s.receiverId = :senderId OR s.receiverId = :receiverId  ")
List<MessageDTO> findMessageDTOBySenderId(String senderId,String receiverId);*/
//my query
/*@Query("select new com.example.chattingapp.domain.MessageDTO(senderId,receiverId,message)from SenderReceiverRelation s where s.senderId =:senderId OR s.receiverId = :senderId AND s.receiverId = :senderId OR s.receiverId = :receiverId ")
List<MessageDTO> findMessageDTOBySenderId(String senderId,String receiverId);*/
    //sir query according to class scenario
    @Query("select new com.example.chattingapp.domain.MessageDTO(senderId,receiverId,message) " +
            "from SenderReceiverRelation s where " +
            " s.senderId =(:senderId) AND s.receiverId = (:receiverId) OR " +
            " s.senderId = (:receiverId) AND s.receiverId = (:senderId )")
    List<MessageDTO> findMessageDTOBySenderId(String senderId,String receiverId);
}
