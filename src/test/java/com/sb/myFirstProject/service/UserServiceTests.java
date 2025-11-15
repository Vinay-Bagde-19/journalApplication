package com.sb.myFirstProject.service;

import com.sb.myFirstProject.entity.User;
import com.sb.myFirstProject.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

//    @BeforeEach @BeforeAll
//    @AfterAll @AfterEach
//    void setUp(){
//
//    }

    
//    @Test
    @ParameterizedTest
    @ValueSource(strings = {
            "Vinay Bagde",
            "mahesh",
            "john"
    })
    public void testFindByUserName(String name){
//        User user = userRepository.findByUserName("Vinay Bagde");
        assertNotNull(userRepository.findByUserName(name), "Failed for : " + name);
//        assertTrue(user.getJournalEntries().isEmpty());
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}
