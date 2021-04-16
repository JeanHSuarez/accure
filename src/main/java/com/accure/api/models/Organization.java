package com.accure.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="organizations")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "orgId")
    private Long orgId;

    @Column(name = "name", length = 20)
    private String name;
    
    @JsonIgnore
    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER)
    List<User> userList;

    public Organization() {}

    public Organization(String name){
        this.name = name;
    }

    public Long getId(){
        return this.orgId;
    }

    public void setId(Long orgId){
        this.orgId = orgId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<User> getUserList(){
        return this.userList;
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
    }
}
