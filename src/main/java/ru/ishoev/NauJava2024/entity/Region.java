package ru.ishoev.NauJava2024.entity;

import java.util.Objects;

public class Region {
    private final Long id;
    private String name;
    private Short phoneCode;

    public Region(Long id, String name, Short phoneCode) {
        this.phoneCode = phoneCode;
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(Short phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Override
    public String toString() {
        return name + ", "
                + "телефонный код: +" + phoneCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Region r)) {
            return false;
        }

        if (!Objects.equals(this.name, r.name)) {
            return false;
        }
        if (!Objects.equals(this.phoneCode, r.phoneCode)) {
            return false;
        }

        return (long) this.id == r.id;
    }

    @Override
    public int hashCode() {
        final int prime = 53;
        int hash = 3;
        hash = prime * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = prime * hash + this.phoneCode;
        hash = prime * hash + this.id.intValue();
        return hash;
    }
}

