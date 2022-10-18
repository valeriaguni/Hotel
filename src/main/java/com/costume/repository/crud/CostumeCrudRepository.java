/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository.crud;

import com.costume.model.Hotel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author win10
 */
public interface CostumeCrudRepository extends CrudRepository<Hotel, Integer> {
    
}
