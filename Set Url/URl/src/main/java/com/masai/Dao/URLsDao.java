package com.masai.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.URLs;

@Repository
public interface URLsDao extends JpaRepository<URLs, Integer> {

	public Optional<URLs> findByActualUrl(String actualUrl);
	public Optional<URLs> findByShortUrl(String shortUrl);
}
