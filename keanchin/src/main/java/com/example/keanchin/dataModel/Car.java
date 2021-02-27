package com.example.keanchin.dataModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
@Entity(name = "cars")
public class Car {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator ="carSeq" )
    @SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "carSeq")
    private Long id;
    private String carName;
    private String description;
    private Double dailyCarRating;
    private boolean isDeleted;
    private boolean isBooked;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private User user;
}
