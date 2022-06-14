package com.FitnessPlanApp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.FitnessPlanApp.model.User;
import com.FitnessPlanApp.repository.UserRepository;
import com.FitnessPlanApp.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private LoginService loginService = new LoginService();

	@Captor
	private ArgumentCaptor<Integer> argumentCaptor;

	@Test
	public void UserTest_1() {
		User exampleUser = new User(null, "admin", "admin", "admin@sport.pl", "admin", 1, null);

		when(userRepository.findByEmail("admin@sport.pl")).thenReturn(java.util.Optional.of(exampleUser));

		User userFromRepository = userRepository.findByEmail("admin@sport.pl").get();

		assertEquals("admin", userFromRepository.getFirstName());
		assertEquals("admin", userFromRepository.getPassword());
		assertEquals(1, userFromRepository.getRole());
	}

	@Test
	public void UserTest_2() {
		User exampleUser = new User(null, "admin", "admin", "admin@sport.pl", "admin", 1, null);
		userRepository.delete(exampleUser);
		userRepository.delete(exampleUser);
		verify(userRepository, atLeast(2)).delete(exampleUser);
	}

	@Test
	public void UserTest_3() {
		User exampleUser = new User(null, "admin", "admin", "admin@sport.pl", "admin", 1, null);
		userRepository.save(exampleUser);
		userRepository.save(exampleUser);
		verify(userRepository, atLeast(2)).save(exampleUser);
	}

	@Test
	public void UserTest_4() {
		User exampleUser = new User(null, "admin", "admin", "admin@sport.pl", "admin", 1, null);

		when(userRepository.findByEmail("admin@sport.pl")).thenReturn(java.util.Optional.of(exampleUser));

		User userFromService = loginService.getByEmail("admin@sport.pl");

		assertEquals("admin", userFromService.getFirstName());
		assertEquals("admin", userFromService.getPassword());
		assertEquals(1, userFromService.getRole());
	}

}