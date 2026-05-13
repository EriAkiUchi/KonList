package com.KonList.model.Studio;

import jakarta.persistence.*;

@Entity
@Table(name = "studios")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
