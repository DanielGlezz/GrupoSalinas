package com.mx.GS_RecursosHumanos.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.GS_RecursosHumanos.Domain.ContractType;

@Repository
public interface IContractTypeDao extends JpaRepository<ContractType, Short> {

	Optional<ContractType> findById(Short contractTypeId);

}
