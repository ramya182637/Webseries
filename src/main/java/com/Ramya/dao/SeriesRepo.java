package com.Ramya.dao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Ramya.model.WebSeries;
public interface SeriesRepo extends JpaRepository<WebSeries, Integer> {

	Optional<WebSeries> findByName(String name);
	
}