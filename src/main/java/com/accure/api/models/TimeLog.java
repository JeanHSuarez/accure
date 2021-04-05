package com.accure.api.models;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.persistence.*;

import org.javamoney.moneta.Money;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="timeLogs")
public class TimeLog implements Serializable {

	private static final CurrencyUnit usd = Monetary.getCurrency("USD");
    private static final long serialVersionUID = 1L;
    private static final int minsPerBillingUnit = 15;
    private static final double costPerUnit = 4.25;
    

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
    
    @Column(name="durationInMins")
    private Long durationInMins;
    
    @Column(name="billingUnits")
    private Long billingUnits;
    
    @Column(name="billableAmount")
    private String billableAmount;
    
    @Column(name="organization")
    private Organization org;
    
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
    	Duration duration = Duration.between(this.signIn, this.signOut);
    	Long duraMins = Math.abs(duration.toMinutes());
    	setDurationInMins(duraMins);
    }
      
    public Long getDurationInMins() {
    	return this.durationInMins;
    }
    
    public void setDurationInMins(Long durationInMins) {
    	this.durationInMins = durationInMins;
    	Long billU = durationInMins / minsPerBillingUnit;
    	setBillingUnits(billU);
    }
    
    public Long getBillingUnits() {
    	return this.billingUnits;
    }
    
    public void setBillingUnits(Long billingUnits) {
    	this.billingUnits = billingUnits;
    	Double billable = costPerUnit * (double)billingUnits;
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	formatter.format(billable);
    	Money billAm = Money.of(billable, usd).with(Monetary.getDefaultRounding());
    	setBillableAmount(billAm.toString());  	
    }
    
    public String getBillableAmount() {
    	return this.billableAmount;
    }
    
    public void setBillableAmount(String billableAmount) {
    	this.billableAmount = billableAmount;
    }
    
    public User getUser() {
    	return this.user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    	System.out.println(user.getOrganization());
    } 

}


