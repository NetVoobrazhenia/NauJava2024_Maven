package ru.ishoev.NauJava2024.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(mappedBy = "id")
    private List<PhoneFormat> phoneFormats;

    public Region(String name) {
        this.name = name;
    }

    public Region() {

    }
}

