package com.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.dao.ReservationDao;
import com.ts.exception.ReservationNotFoundException;
import com.ts.model.Reservation;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    public List<Reservation> getAllReservations() {
        return reservationDao.findAll();
    }

    public Reservation getReservationById(Long id) {
    	  return reservationDao.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation not found with ID: " + id));
    	  
    }

    public List<Reservation> getReservationsByCustomerId(Long customerId) {
        return reservationDao.findByCustomerId(customerId);
    }

    public List<Reservation> getReservationsByTableNumber(int tableNumber) {
        return reservationDao.findByTableNumber(tableNumber);
    }

    public void addReservation(Reservation reservation) {
        reservationDao.save(reservation);
    }

    public void updateReservation(Reservation reservation) {
    	 if (reservationDao.existsById(reservation.getId())) {
             reservationDao.save(reservation);
         } else {
             throw new ReservationNotFoundException("Reservation not found with ID: " + reservation.getId());
         }
    }

    public void deleteReservation(Long id) {
        if (reservationDao.existsById(id)) {
            reservationDao.deleteById(id);
        } else {
            throw new ReservationNotFoundException("Reservation not found with ID: " + id);
        }
    }

}

