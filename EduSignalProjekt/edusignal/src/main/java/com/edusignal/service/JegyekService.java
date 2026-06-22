package com.edusignal.service;


import com.edusignal.repository.JegyekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JegyekService {

    private final JegyekRepository jegyekRepository;

}
