package com.justclick.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.justclick.test.model.Url;
/**
 * *********************************************************************************************************
 * Name: UrlRepository 
 * Description:JpaRepository class that permit to select data in the postgres database
 * *********************************************************************************************************
 */
@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	Url findByName(String name);
}
