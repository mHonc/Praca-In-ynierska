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
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    private Plan plan;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Day_Workout",
            joinColumns = {@JoinColumn(name = "day_id")},
            inverseJoinColumns = {@JoinColumn(name = "workout_id")}

    )
    private List<Workout> workoutList;
}
