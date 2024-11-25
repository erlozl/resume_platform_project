package com.example.resume_platform.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Table(name = "has_skill_tb")
@Entity
public class HasSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String skillId;
    private String resumeId;

    @Builder
    public HasSkill(Integer id, String skillId, String resumeId) {
        this.id = id;
        this.skillId = skillId;
        this.resumeId = resumeId;
    }

}
