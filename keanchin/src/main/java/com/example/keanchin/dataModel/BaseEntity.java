package com.example.keanchin.dataModel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public class BaseEntity {
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    void onPersist() {
        this.updatedAt = new Date();
    }
}
