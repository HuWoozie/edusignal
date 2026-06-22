package com.edusignal.service;

import com.edusignal.repository.TantargyakRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TantargyakService {

    private final TantargyakRepository tantargyakRepository;

}
