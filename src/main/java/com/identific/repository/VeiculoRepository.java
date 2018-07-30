package com.identific.repository;

import com.identific.model.Condutor;

import org.springframework.data.repository.CrudRepository;
import com.identific.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long>{
	Iterable<Veiculo> findByCondutor(Condutor condutor);
        Veiculo findById(Long id);
}
