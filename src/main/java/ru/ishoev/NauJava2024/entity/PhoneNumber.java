package ru.ishoev.NauJava2024.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {
    @Id
    @GeneratedValue
    private Long id;
    private Long Number;
    @ManyToOne
    @JoinColumn(name = "format_id")
    private PhoneFormat format;
}
