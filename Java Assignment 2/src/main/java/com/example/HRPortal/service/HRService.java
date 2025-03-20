package com.example.HRPortal.service;

import com.example.HRPortal.models.HR;
import com.example.HRPortal.repository.HRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HRService {

    @Autowired
    private HRRepository hrRepository;

    public String login(String email, String password) {
        Optional<HR> hr = hrRepository.findByEmail(email);
        if (hr.isPresent() && hr.get().getPassword().equals(password)) {
            return "Login Successful";
        }
        return "Invalid Email or Password";
    }

    public HR registerHR(HR hr) {
        return hrRepository.save(hr);
    }
}
