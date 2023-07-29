package com.olive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olive.model.URLMapping;

@Repository
public interface URLMappingRepository extends JpaRepository<URLMapping, Long>{

	URLMapping findByShortURL(String shortURL);
	
}
