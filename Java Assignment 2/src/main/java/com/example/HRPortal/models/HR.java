package com.example.HRPortal.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; 
}
