package com.FitnessPlanApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String name;

    @Lob
    @Column(length = 100000)
    private String description;
    private String videoLink;

    @ManyToMany(mappedBy = "workoutList", fetch = FetchType.LAZY)
    private List<Day> dayList;
}
