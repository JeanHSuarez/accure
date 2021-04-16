package com.accure.api.restcontroller;


import com.accure.api.models.Organization;
import com.accure.api.models.User;
import com.accure.api.services.EntityNotFoundException;
import com.accure.api.services.OrganizationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/org")
public class OrganizationRController {

    @Autowired
    OrganizationService organizationService;
    
    @GetMapping("orgs")
    public List<Organization> getOrgs() throws EntityNotFoundException{
    	List<Organization> orgs = organizationService.findAll();
    	return orgs;
    }

    @GetMapping("{orgId}")
    public Organization findOrganization(@PathVariable Long orgId) throws  EntityNotFoundException{
        Organization o = organizationService.find(orgId);
        return o;
    }
    
    @GetMapping("{orgId}/users")
    public List <User> findByOrgId(@PathVariable Long orgId) throws  EntityNotFoundException{
        Organization o = organizationService.find(orgId);
        return o.getUserList();
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

