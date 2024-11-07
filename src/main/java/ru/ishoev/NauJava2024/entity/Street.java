package ru.ishoev.NauJava2024.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String suffix;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Street(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Street() {

    }
}

