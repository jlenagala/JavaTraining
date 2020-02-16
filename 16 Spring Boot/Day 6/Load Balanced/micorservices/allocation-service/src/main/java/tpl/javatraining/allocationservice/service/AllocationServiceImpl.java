package tpl.javatraining.allocationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import tpl.javatraining.allocationservice.model.Allocation;
import tpl.javatraining.allocationservice.repository.AllocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public Allocation save(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    @Override
    public Allocation getAllocation(Integer id) {
        Optional<Allocation> optionalAllocation = allocationRepository.findById(id);
        if (optionalAllocation.isPresent()) {
            return optionalAllocation.get();
        }
        return null;

    }

    @Override
    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    @Override
    public List<Allocation> findByEmployee(Integer id) {
        Allocation allocation=new Allocation();
        allocation.setEmpId(id);
        System.out.println("port 0");
        Example <Allocation> example=Example.of(allocation);
        List<Allocation> allocations=allocationRepository.findAll(example);
        return allocations;
    }
}
