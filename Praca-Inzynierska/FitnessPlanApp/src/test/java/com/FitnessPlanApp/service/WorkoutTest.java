package com.FitnessPlanApp.service;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.FitnessPlanApp.model.Workout;
import com.FitnessPlanApp.repository.WorkoutRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class WorkoutTest {

	@Mock
	private WorkoutRepository workoutRepository;

	@InjectMocks
	private WorkoutService workoutService = new WorkoutService();

	@Test
	public void getAllWorkouts() {
		when(workoutRepository.findAll()).thenReturn(new ArrayList<>());
		List<Workout> workoutList = workoutService.getWorkoutList();
		assertThat(workoutList.size()).isEqualTo(0);
	}

	@Test
	public void getAllWorkoutCategories_1() {
		when(workoutRepository.findAll()).thenReturn(new ArrayList<>());
		List<String> workoutList = workoutService.getWorkoutCategories();
		assertThat(workoutList.size()).isEqualTo(0);
	}

	@Test
	public void getAllWorkoutCategories_2() {
		List<Workout> workoutList = workoutService.getWorkoutListByCategory("Test");
		assertThat(workoutList.size()).isEqualTo(0);
	}

	@Test
	public void getAllWorkoutCategories_3() {
		Workout workout = new Workout(null,
				"Cat",
				"Name",
				"Desc",
				"http://test",
				null);

		when(workoutRepository.findById(1)).thenReturn(java.util.Optional.of(workout));

		Workout workoutFromRepo = workoutRepository.findById(1).get();

		assertEquals("Cat", workoutFromRepo.getCategory());
		assertEquals("Name", workoutFromRepo.getName());
		assertEquals("Desc", workoutFromRepo.getDescription());
		assertEquals("http://test", workoutFromRepo.getVideoLink());
	}
}