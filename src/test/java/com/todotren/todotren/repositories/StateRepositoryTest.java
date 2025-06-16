package com.todotren.todotren.repositories;

import com.todotren.todotren.entities.StateEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StateRepositoryTest {

    @Autowired
    private StateRepository stateRepository;

    @Test
    @DisplayName("Deberia haber 3 estados en la base")
    public void testCantidadDeEstadosCargados(){
        List<StateEntity> estados = stateRepository.findAll();
        assertEquals(3, estados.size(), "La cantidad de estados iniciales debe ser 3");
    }

}