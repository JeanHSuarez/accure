package com.accure.api.services;

import com.accure.api.dao.OrganizationDAO;
import com.accure.api.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    OrganizationDAO organizationDAO;

    public Organization find(Long orgId) throws EntityNotFoundException {
        Organization o = null;
        Optional<Organization> opt = organizationDAO.findById(orgId);

        if (opt.isPresent()){
            o = opt.get();
        }else {
            throw new EntityNotFoundException(orgId + " doesn't exist");
        }
        return o;
    }
    public  String insert(Organization o){
        Optional<Organization> opt = organizationDAO.findById(o.getId());
        if (!opt.isPresent()) {
            organizationDAO.save(o);
            return "success";
        }
        return o.getId() + " already exist";
    }

    public String delete(Long orgId) throws EntityNotFoundException{
        Optional<Organization> opt = organizationDAO.findById(orgId);
        if (opt.isPresent()) {
            Organization o = opt.get();
            organizationDAO.deleteById(orgId);
        } else {
            throw new EntityNotFoundException("Organization" + orgId + "doesn't exist");
        }
        return "success";
    }
}