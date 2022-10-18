/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository;

import com.costume.model.Hotel;
import com.costume.repository.crud.CostumeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author win10
 */
@Repository
public class CostumeRepository {
    @Autowired
    private CostumeCrudRepository costumeCrudRepository;
    
    public List <Hotel> getAll(){
        return (List<Hotel>) costumeCrudRepository.findAll();
    }
    
    public Optional<Hotel> getCostume(int id){
        return costumeCrudRepository.findById(id);
    }
    
    public Hotel save(Hotel hotel){
        return costumeCrudRepository.save(hotel);
    }
    public void delete(Hotel hotel){
        costumeCrudRepository.delete(hotel);
    }
}
