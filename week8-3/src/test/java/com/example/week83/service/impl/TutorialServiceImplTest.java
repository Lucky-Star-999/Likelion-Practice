package com.example.week83.service.impl;

import com.example.week83.entity.Tutorial;
import com.example.week83.repository.TutorialRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TutorialServiceImplTest {

    @Mock
    private TutorialRepository tutorialRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByTitleContaining() {
    }

    @Test
    void findById() {
        when(tutorialRepository.findById(1l))
                .thenReturn(Optional.of(new Tutorial(null, "Title 1", "Description 1", true)));
        assertThat(tutorialRepository.findById(1l)).isNotNull();
    }

    @Test
    void findByPublished() {
        List<Tutorial> tutorialList = new ArrayList<>();
        tutorialList.add(new Tutorial(null, "Title 1", "Description 1", true));
        tutorialList.add(new Tutorial(null, "Title 2", "Description 2", true));
        when(tutorialRepository.findByPublished(true)).thenReturn(tutorialList);

        assertThat(tutorialRepository.findByPublished(true).isEmpty()).isEqualTo(false);
    }

    @Test
    void findByPublished2() {
        List<Tutorial> tutorialList = new ArrayList<>();
        tutorialList.add(new Tutorial(null, "Title 1", "Description 1", true));
        tutorialList.add(new Tutorial(null, "Title 2", "Description 2", true));
        when(tutorialRepository.findByPublished(true)).thenReturn(tutorialList);

        assertThat(tutorialRepository.findByPublished(true)).isEqualTo(tutorialList);
    }

}