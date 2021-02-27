package com.example.keanchin.dataModel;

import com.example.keanchin.dataModel.constant.GenderEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
public class User extends BaseEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "userSeq")
    @SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "userSeq")
    private Long id;

    //Username as email
    private String username;
    private String password;
    private String profileName;
    private Integer age;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private GenderEnum genderType;
    private boolean isActive;
}
