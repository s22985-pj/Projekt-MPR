package com.example.Piotr.User;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)

public class UserServiceTests {



    @Mock
    private UserService userService;

    @Test
    void ShouldChangeName(){
        //GIVEN
        User user = new User("Damian","Polanski","Poldam","Dampol@gmail.com","123456789",21);
        //WHEN
        userService.changeName(user,"Andrzej");
        //THEN
        assertThat(user.getName())
                .isEqualTo("Damian");
    }

    @Test
    void ShouldChangeSurname(){
        //GIVEN
        User user = new User("Damian","Polanski","Poldam","Dampol@gmail.com","123456789",21);
        //WHEN
        userService.changeSurname(user, "Dampol");
        //THEN
        assertThat(user.getSurname())
                .isEqualTo("Poldam");
    }

    @Test
    void ShouldChangeUsername(){
        //GIVEN
        User user = new User("Damian","Polanski","Poldam","Dampol@gmail.com","123456789",21);
        //WHEN
        userService.changeUsername(user,"Poldam");
        //THEN
        assertThat(user.getUsername())
                .isEqualTo("Poldam");
    }

    @Test
    void isSetEmail(){
        //GIVEN
        User user = new User("Damian","Polanski","Poldam","Dampol@gmail.com","123456789",21);
        //WHEN
        userService.setEmail(user,"Damlop@gmail.com");
        //THEN
        assertThat(user.getEmail())
                .isEqualTo("Damlop@gmail.com");

    }

    @Test
    void ShouldChangePassword(){
        //GIVEN
        User user = new User("Damian","Polanski","Poldam","Dampol@gmail.com","123456789",21);
        //WHEN
        userService.changePassword(user, "4213");
        userService.changePassword(user, "4213");

        //THEN
        assertThat(user.getPassword())
                .isEqualTo(4213);
    }

    @Test
    void isSetAge(){
        //GIVEN
        User user = new User("Damian","Polanski","Poldam","Dampol@gmail.com","123456789",21);
        //WHEN
        userService.setAge(user, 22);
        //THEN
        assertThat(user.getAge())
                .isEqualTo(22);
    }
}
        //GIVEN
        //WHEN
        //THEN
