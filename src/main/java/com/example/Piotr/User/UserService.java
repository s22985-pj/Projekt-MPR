package com.example.Piotr.User;

import org.springframework.stereotype.Service;

import java.util.Optional;

// Dodawanie metod
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public void print(User user) {
        System.out.println(user);
    }

    public void changeName(User user, String name) {
        if (user.getName().equals(name)) {
            throw new IllegalArgumentException("Nie można ustawić tego samego imienia.");

        } else{
                user.setName(name);
            }

        }


    public void changeSurname(User user, String surname) {
        if (user.getSurname().equals(surname)) {
            throw new IllegalArgumentException("Nie można ustawić tego samego nazwiska.");

        } else{
            user.setSurname(surname);
        }
    }

    public void changeUsername(User user, String username) {
        if (user.getUsername().equals(username)) {
            throw new IllegalArgumentException("Nie można ustawić tego samego nicku.");

        } else{
            user.setUsername(username);
        }
    }

    public void setEmail(User user, String email) {
        if (user.getEmail().equals(email)) {
            throw new IllegalArgumentException("Ten mail jest już ustawiony.");

        } else if ( email != "{email}@domena.pl") {
            throw new IllegalArgumentException("Zły mail!");
        } else {
            user.setEmail(email);
        }
    }

    public void changePassword(User user, String password) {
        if (user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Nie można ustawić tego samego hasła");

        }
        else if (password.length()<8 ) {
            throw  new IllegalArgumentException("Hasło musi zawierać przynajmniej 8 znaków ");

        }
        else user.setPassword(password);
    }

    public void setAge(User user, int age){
        if( user.getAge() < 18 ) {
            throw new IllegalArgumentException("Użytkownik musi być pełnoletni");
        }
        else user.setAge(age);
    }

    public User getUser(String name, String surName, String userName){
        User user = new User(name ,surName, userName,"Zelkowski@domena.pl","123456", 20);
        return user;
    }

    public User FindById(Long id){
        Optional<User> ById = userRepository.findById(id);
        if (ById.isPresent()){
            return ById.get();
        }else throw new IllegalArgumentException("Brak ID");
    }



}


