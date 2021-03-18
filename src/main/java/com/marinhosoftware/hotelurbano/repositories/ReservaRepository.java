package com.marinhosoftware.hotelurbano.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marinhosoftware.hotelurbano.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
