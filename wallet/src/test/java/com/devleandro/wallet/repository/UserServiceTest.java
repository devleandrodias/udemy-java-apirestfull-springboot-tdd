package com.devleandro.wallet.repository;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.devleandro.wallet.entity.User;
import com.devleandro.wallet.service.interfaces.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserServiceTest
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

  @MockBean
  UserRepository userRepository;

  @Autowired
  UserService userService;

  @Before
  public void setUp() {
    BDDMockito.given(userRepository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
  }

  @Test
  public void testFindByEmail() {
    Optional<User> user = userService.findByEmail("email@test.com");

    assertTrue(user.isPresent());
  }
}