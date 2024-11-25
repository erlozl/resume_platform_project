package com.example.resume_platform.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "wish_position_tb")
@Entity
public class HasPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String resumeId;
    private String positionId;

    @Builder
    public HasPosition(Integer id, String resumeId, String positionId) {
        this.id = id;
        this.resumeId = resumeId;
        this.positionId = positionId;
    }

}
