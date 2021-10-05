package com.flightapp.flightappadmin.repository;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.flightappadmin.model.Login;  


public interface LoginRepository extends JpaRepository<Login, Integer>  
{  
}  