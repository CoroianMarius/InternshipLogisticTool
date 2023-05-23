package com.ibm.den.dto;

import java.util.Objects;

public class MentorDto {
    private Long id;
    private String name;

    public MentorDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MentorDto mentorDto)) return false;
        return Objects.equals(getId(), mentorDto.getId()) && Objects.equals(getName(), mentorDto.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "MentorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
