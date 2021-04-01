package com.accure.api.models;

import java.io.Serializable;
import java.time.LocalDateTime;



import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="timeLogs")
public class TimeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="timeLogId")
    private Long id;

    @Column(name="signIn")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime signIn;

    @Column(name="signOut")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime signOut;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public LocalDateTime getSignIn() {
    	return this.signIn;
    }
    
    public void setSignIn(LocalDateTime signIn) {
    	this.signIn = signIn;
    }
    
    public LocalDateTime getSignOut() {
    	return this.signOut;
    }
    
    public void setSignOut(LocalDateTime signOut) {
    	this.signOut = signOut;
    }
    
    public User getUser() {
    	return this.user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }

}


