package org.example.service;

import org.example.entity.Employe;
import org.example.entity.Plat;
import org.example.repository.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PlatService {

    @Autowired
    private PlatRepository platRepository;

    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    public Optional<Plat> getPlatById(int id) {
        return platRepository.findById(id);
    }

    public Plat savePlat(Plat plat) {
        return platRepository.save(plat);
    }

    public void deletePlat(int id) {
        platRepository.deleteById(id);
    }

    public void updatePlat(Plat plat) {
        platRepository.save(plat);
    }


}
