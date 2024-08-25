package com.adso.siatv4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siatv4.entity.AnioLectivo;
@Repository
public interface AnioRepository extends JpaRepository<AnioLectivo, Long>{
    
}
