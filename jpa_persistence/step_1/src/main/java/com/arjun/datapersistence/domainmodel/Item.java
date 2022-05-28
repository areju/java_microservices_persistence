package com.arjun.datapersistence.domainmodel;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@org.hibernate.annotations.Cache(
		usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE 
)
public class Item {
	@NotNull
	@Size(
			min = 2,
			max = 255,
			message = "Name is require min of 2 and maximum of charachters "
	)
	private String name;

	@Future
	private Date auctionDate;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Bid.class)
    @JoinTable(name = "ITEM_BIDS", joinColumns = { @JoinColumn(name = "ITEM_ID") }, inverseJoinColumns = { @JoinColumn(name = "BID_ID") })
	private Set<Bid> bids = new HashSet<>();
	
	@Id
	@GeneratedValue
	private Long id;
	


	private float buyNowPrice;
	
	public float getBuyNowPrice() {
		return buyNowPrice;
	}


	public void setBuyNowPrice(float buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}
	
	public Date getAuctionDate() {
		return auctionDate;
	}


	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	

	public Set<Bid> getBids() {
		return Collections.unmodifiableSet(bids);
	}
	
	public void addBid(Bid bid) {
		if(bid == null)
			throw new NullPointerException("Cant add a null bid");
		
		if(bid.getItem() != null) {
			throw new IllegalStateException("Can't  place a bid, item has a bid already");
		}
		
		bids.add(bid);
		bid.setItem(this);
	}
	
	
}
