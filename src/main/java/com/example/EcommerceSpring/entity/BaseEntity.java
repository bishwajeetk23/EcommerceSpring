package com.example.EcommerceSpring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
//MappedSuperclass-> is JPA annotation used to define the base class that contains the common fields
// which will be inherited and mapped into child entity
// Unlike @Entity -> it does not get its own table int database, it adds these columns to those table who inherit it.
// EntityListeners -> for this we need to add Annotation at application entry point.
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column( nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private  Instant updatedAt;

    // PrePersist -> This method is automatically called before the entity is saved for the first time.
    @PrePersist
    protected void onCreate(){
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = Instant.now();
    }
}
