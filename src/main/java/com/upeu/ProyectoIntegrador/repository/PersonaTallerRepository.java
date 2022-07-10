/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.ProyectoIntegrador.repository;

import com.upeu.ProyectoIntegrador.entity.PersonaTaller;
import com.upeu.ProyectoIntegrador.entity.Taller;
import java.util.List;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaTallerRepository extends CrudRepository<PersonaTaller, Long>{
    List<PersonaTaller> findByTaller(Taller taller);
}
