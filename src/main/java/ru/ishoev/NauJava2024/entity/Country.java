package ru.ishoev.NauJava2024.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    @Column
    private String capital;
    @OneToMany(mappedBy = "id")
    private List<PhoneFormat> phoneFormats;

    public Country(String name) {
        this.name = name;
    }

    public Country() {

    }
}
