package com.melikeyalpi.question5.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    abstract String print();

    @PrePersist // bir entity veritabanına ilk kez eklenmeden (persist edilmeden) hemen önce bir işlem yapılmasını sağlar.
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate // bir entity veritabanında güncellenmeden hemen önce bir işlem yapılmasını sağlar.
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
