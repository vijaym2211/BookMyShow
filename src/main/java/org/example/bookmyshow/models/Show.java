//package org.example.bookmyshow.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.Date;
//import java.util.List;
//
//@Data
//@Entity
//public class Show extends BaseModel{
//    @ManyToOne
//    private Movie movie;
//    @OneToOne
//    private Screen screen;
//    private Date startTime;
//    private Date endTime;
//    @Enumerated(value = EnumType.ORDINAL) //use when we use enum
//    @ElementCollection   //use when we have list of enum's
//    private List<Feature> featureList;
//}
