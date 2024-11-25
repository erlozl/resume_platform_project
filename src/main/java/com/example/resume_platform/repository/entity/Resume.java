package com.example.resume_platform.repository.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
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
@Table(name = "resume_tb")
@Entity
@Builder
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String userName;
    @Column(length = 100)
    private String mainTitle;
    @Column(length = 10)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    @Column(length = 20)
    private String tel;
    @Column(length = 100)
    private String address;
    private String career;
    private String resumeProfileUrl;
    private String hasSkillId;
    private String hasPositionId;

    @Builder
    public Resume(Integer id, String userName, String mainTitle, LocalDate birth, String tel, String address,
            String career, String resumeProfileUrl, String hasSkillId, String hasPositionId) {
        this.id = id;
        this.userName = userName;
        this.mainTitle = mainTitle;
        this.birth = birth;
        this.tel = tel;
        this.address = address;
        this.career = career;
        this.resumeProfileUrl = resumeProfileUrl;
        this.hasSkillId = hasSkillId;
        this.hasPositionId = hasPositionId;
    }

}
