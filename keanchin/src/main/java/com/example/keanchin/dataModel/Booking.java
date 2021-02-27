package com.example.keanchin.dataModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
@Entity(name = "booking")
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "bookSeq")
    @SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "bookSeq")
    private Long id;
    private Date bookingDate;
    private Integer bookingDay;
    private Date returnDate;
    private boolean isPaid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private User user;
}
