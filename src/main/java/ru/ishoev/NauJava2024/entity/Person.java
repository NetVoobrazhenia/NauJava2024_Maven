package ru.ishoev.NauJava2024.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String patronymic;
    @Column
    private String gender;
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(mappedBy = "id")
    private List<PhoneNumber> phoneNumbers;

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }
}
