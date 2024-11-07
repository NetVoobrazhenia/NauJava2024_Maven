package ru.ishoev.NauJava2024.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phone_formats")
public class PhoneFormat {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Integer regionCode;
    @Column
    private String format;
}
