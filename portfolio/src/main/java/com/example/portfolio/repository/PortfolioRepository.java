package com.example.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portfolio.entity.PortfolioEntity;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioEntity,Long>{
	Optional<PortfolioEntity> findByName(String faileName);

}
