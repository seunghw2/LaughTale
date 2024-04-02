package com.jshi.laughtale.worddata.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jshi.laughtale.worddata.domain.WordData;
import org.springframework.data.jpa.repository.Query;

public interface WordDataRepository extends JpaRepository<WordData, Long> {
	Optional<WordData> findByWord(String word);

	Page<WordData> findAllByOrderByFrequencyDesc(Pageable pageable);

	@Query("SELECT w FROM WordData w ORDER BY rand() LIMIT 5")
	List<WordData> findRandom();
}
