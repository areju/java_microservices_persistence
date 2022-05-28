package com.arjun.datapersistence.domainmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.arjun.datapersistence.domainmodel.Item;

@Entity
@org.hibernate.annotations.Cache(
		usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE 
)
public class Bid {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinTable(name = "BIDS_ITEM", joinColumns = { @JoinColumn(name = "BID_ID") }, inverseJoinColumns = { @JoinColumn(name = "ITEM_ID") })
    private com.arjun.datapersistence.domainmodel.Item item;
    
    public Item getItem() {
        return item;
    }
    
    public void setItem(Item item) {
    	this.item = item;
    	this.item.addBid(this);
    }
 
 
}
