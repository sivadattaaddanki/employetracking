package com.myproject.go.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.go.entityfwk.RegestrationEntity;
@Repository
public interface RegestrationRepo extends JpaRepository<RegestrationEntity,Integer>{
}
