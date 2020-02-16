package tpl.javatraining.allocationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpl.javatraining.allocationservice.model.Allocation;
import tpl.javatraining.allocationservice.service.AllocationService;

import java.util.List;

@RestController
@RequestMapping("/alloservice")
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/allocations", method = RequestMethod.GET)
    public List<Allocation> findAllAllocations() {
        return allocationService.getAllAllocations();

    }

    @RequestMapping(value = "/allocation/{id}", method = RequestMethod.GET)
    public Allocation getAllocation(@PathVariable Integer id) {
        return allocationService.getAllocation(id);
    }

    @RequestMapping(value = "/allocation", method = RequestMethod.POST)
    public Allocation save(@RequestBody Allocation allocation) {
        return allocationService.save(allocation);
    }
    @RequestMapping(value = "/allofindbyemployee/{id}", method = RequestMethod.GET)
    public Allocation[] getAllocationByEmpId(@PathVariable Integer id) {
        List<Allocation> all =allocationService.findByEmployee(id);
        return all.toArray(new Allocation[all.size()]);
    }
}
