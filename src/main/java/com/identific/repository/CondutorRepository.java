package com.identific.repository;

import org.springframework.data.repository.CrudRepository;
import com.identific.model.Condutor;

public interface CondutorRepository extends CrudRepository<Condutor, Long>{
	Condutor findByCnh(Long cnh);
}
