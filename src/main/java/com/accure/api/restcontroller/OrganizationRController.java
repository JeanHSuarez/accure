package com.accure.api.restcontroller;


import com.accure.api.models.Organization;
import com.accure.api.services.EntityNotFoundException;
import com.accure.api.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/organization")
public class OrganizationRController {

    @Autowired
    OrganizationService organizationService;

    @GetMapping("{orgId}")
    public Organization findOrganization(@PathVariable Long orgId) throws  EntityNotFoundException{
        Organization o = organizationService.find(orgId);
        return o;
    }

    @PostMapping("add")
    public String insert(@RequestBody Organization o) {
        return organizationService.insert(o);
    }

    @DeleteMapping("{orgId}")
    public String deleteById(@PathVariable Long orgId) throws EntityNotFoundException{
        return organizationService.delete(orgId);
    }
}

