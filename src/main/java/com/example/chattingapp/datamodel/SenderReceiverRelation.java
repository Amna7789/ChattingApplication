package com.example.chattingapp.datamodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class SenderReceiverRelation {
    @Id
    /*@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")*/
    String message;
    String senderId;

    

    //@Id
    String receiverId;

    public SenderReceiverRelation(String senderId, String receiverId, String message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
    }
}
