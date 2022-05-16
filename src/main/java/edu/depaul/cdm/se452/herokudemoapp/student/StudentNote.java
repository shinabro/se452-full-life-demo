package edu.depaul.cdm.se452.herokudemoapp.student;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class StudentNote {   
    private String studentId;
    private String note;
    private long noteNum;    
}
