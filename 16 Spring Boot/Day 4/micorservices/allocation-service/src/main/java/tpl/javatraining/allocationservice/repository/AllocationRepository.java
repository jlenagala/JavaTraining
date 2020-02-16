package tpl.javatraining.allocationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpl.javatraining.allocationservice.model.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
}
