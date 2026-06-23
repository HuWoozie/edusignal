package com.edusignal.service;

import com.edusignal.repository.TanuloStatuszRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TanuloStatuszService {

    private final TanuloStatuszRepository tanuloStatuszRepository;

}
