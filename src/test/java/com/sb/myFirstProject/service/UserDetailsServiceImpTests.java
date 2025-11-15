package com.sb.myFirstProject.service;

import com.sb.myFirstProject.repository.UserRepository;

import com.sb.myFirstProject.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;

import static org.mockito.Mockito.*;
@Disabled
public class UserDetailsServiceImpTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().
//        username("Vinay Bagde").password("abcad").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsService.loadUserByUsername("Vinay Bagde");
//        Assertions.assertNotNull(user);

        // Arrange
        User mockUser = new User("Vinay Bagde", "abcda");
        mockUser.setRoles(new ArrayList<>());

        when(userRepository.findByUserName(anyString())).thenReturn(mockUser);

        // Act
        UserDetails user = userDetailsService.loadUserByUsername("Vinay Bagde");

        // Assert
        Assertions.assertNotNull(user);
        Assertions.assertEquals("Vinay Bagde", user.getUsername());
    }
}
