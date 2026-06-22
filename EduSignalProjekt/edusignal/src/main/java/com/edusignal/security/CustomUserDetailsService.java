package com.edusignal.security;

import com.edusignal.repository.FelhasznaloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final FelhasznaloRepository felhasznaloRepository;


    //valójában Id-t küldünk a JWT-ből
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return felhasznaloRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new UsernameNotFoundException("Felhasználó nem található: " + id));
    }
}