package com.example.keanchin.dataModel;

import com.example.keanchin.dataModel.constant.PaymentMethodEnum;
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
@Entity(name = "payments")
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "paymentSeq")
    @SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "paymentSeq")
    private Long id;
    private Date billDate;
    private String billTo;
    private Double amount;
    private PaymentMethodEnum paymentMethodEnum;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Booking booking;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private User user;
}