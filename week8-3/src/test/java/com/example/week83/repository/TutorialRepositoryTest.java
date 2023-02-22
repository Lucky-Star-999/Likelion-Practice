package com.example.week83.repository;

import com.example.week83.entity.Tutorial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TutorialRepositoryTest {

    @Autowired
    private TutorialRepository tutorialRepository;

    @BeforeEach
    void setUp() {
        tutorialRepository.save(new Tutorial(null, "Title 1", "Description 1", true));
        tutorialRepository.save(new Tutorial(null, "Title 2", "Description 2", true));
        tutorialRepository.save(new Tutorial(null, "Title 3", "Description 3", false));
    }

    @AfterEach
    void tearDown() {
        tutorialRepository.deleteAll();
    }

    @Test
    void findAll() {
        assertThat(tutorialRepository.findAll()).isNotNull();
    }

    @Test
    void findById() {
        assertThat(tutorialRepository.findById(1l)).isNotNull();
    }

    @Test
    void findByPublished() {
        assertThat(tutorialRepository.findByPublished(true)).isNotNull();
    }

    @Test
    void findByTitleContainingIgnoreCase() {
        assertThat(tutorialRepository.findByTitleContainingIgnoreCase("des")).isNotNull();
    }
}