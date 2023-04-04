package com.user.userapi.services.impl;

import com.user.userapi.dto.UserDTO;
import com.user.userapi.models.UserModel;
import com.user.userapi.repositories.UserRepository;
import com.user.userapi.services.exceptions.ObjectNotFoundException;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    public static final Integer ID      = 1;
    public static final String NAME     = "cesar";
    public static final String EMAIL    = "cesar@mail.com";
    public static final String PASSWORD = "123";
    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;
    UserDTO userDto;
    private UserModel user;
    private Optional<UserModel> optUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindUserByIdThenReturnAnUser() {
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optUser);

        UserModel response = service.findById(ID);

        Assertions.assertNotNull(response);

        //Validação de atributos
        Assertions.assertEquals(ID, response.getId());
        Assertions.assertEquals(NAME, response.getName());
        Assertions.assertEquals(EMAIL, response.getEmail());
        Assertions.assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        Mockito.when(repository.findById(Mockito.anyInt())).thenThrow(new ObjectNotFoundException("Objeto nao encontrado"));

        try{
            service.findById(ID);
        } catch (Exception e) {
            assertEquals(ObjectNotFoundException.class, e.getClass());
        }

    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        user = new UserModel(ID, NAME, EMAIL, PASSWORD);
        userDto = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optUser = Optional.of(new UserModel(ID, NAME, EMAIL, PASSWORD));
    }
}