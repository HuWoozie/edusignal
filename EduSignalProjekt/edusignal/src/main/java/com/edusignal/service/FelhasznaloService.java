package com.edusignal.service;


import com.edusignal.repository.FelhasznaloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FelhasznaloService {
    private final FelhasznaloRepository felhasznaloRepository;

}
