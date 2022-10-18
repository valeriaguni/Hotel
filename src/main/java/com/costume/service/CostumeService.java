/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.service;

import com.costume.model.Hotel;
import com.costume.repository.CostumeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author win10
 */
@Service
public class CostumeService {

    @Autowired

    private CostumeRepository costumeRepository;

    public List<Hotel> getAll() {
        return costumeRepository.getAll();
    }

    public Hotel save(Hotel hotel) {
        if (hotel.getId() == null) {
            return costumeRepository.save(hotel);

        } else {
            Optional<Hotel> client1 = costumeRepository.getCostume(hotel.getId());
            if (client1.isEmpty()) {
                return costumeRepository.save(hotel);
            } else {
                return hotel;
            }
        }
    }
    public boolean deleteCostume(int id){
        Optional<Hotel> costumed = costumeRepository.getCostume(id);
        if (costumed.isEmpty()) {
            return false;
        } else {
            costumeRepository.delete(costumed.get());
            return true;
        }
    }
    public Hotel updateCostume(Hotel hotel){
        
        if (hotel.getId()!=null) {
            Optional<Hotel> costumeU = costumeRepository.getCostume(hotel.getId());
            
            if (!costumeU.isEmpty()) {
                          
                if (hotel.getName()!= null){
                    costumeU.get().setName(hotel.getName());
            }
                if (hotel.getBrand()!= null){
                    costumeU.get().setBrand(hotel.getBrand());
                }
                if (hotel.getYear()!= null){
                    costumeU.get().setYear(hotel.getYear());
                }
                if (hotel.getDescription()!= null){
                    costumeU.get().setDescription(hotel.getDescription());
                }
                if(hotel.getCategory()!=null){
                 costumeU.get().setCategory(hotel.getCategory());
                }
            }
            return costumeRepository.save(costumeU.get());
        } 
        return hotel;
    }
}
