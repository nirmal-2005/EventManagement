package com.example.relation.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventModel {
    @Id
    private int id;
    private String userName;
    private String managerName;
    private String eventName;
    private String date;
    private String location;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="register-id")
    private RegisterModel registerModel;
     

   
    
    

    
   
}
