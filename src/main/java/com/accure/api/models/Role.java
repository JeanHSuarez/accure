package com.accure.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", length=20)
    private EnumRoles name;

    public Role() {}

    public Role(EnumRoles name) {
        this.name = name;
    }

    public Integer getId() {
        return roleId;
    }

    public void setId(Integer roleId) {
        this.roleId = roleId;
    }

    public EnumRoles getName() {
        return name;
    }

    public void setName(EnumRoles name) {
        this.name = name;
    }

}
