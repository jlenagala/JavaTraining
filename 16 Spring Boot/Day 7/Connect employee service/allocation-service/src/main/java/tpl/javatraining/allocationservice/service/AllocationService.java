package tpl.javatraining.allocationservice.service;

import tpl.javatraining.allocationservice.model.Allocation;

import java.util.List;

public interface AllocationService {
    Allocation save(Allocation allocation);

    Allocation getAllocation(Integer id);

    List<Allocation> getAllAllocations();

    List<Allocation> findByEmployee(Integer id);

}
