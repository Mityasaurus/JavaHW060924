package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "users")
public class User {
    public enum Gender {
        NOT_SPECIFIED, MALE, FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name = "Surname")
    private String surname;
    private String name;
    private Gender gender;
    private LocalDateTime authorizationTime;
}
