package com.arjun.datapersistence.domainmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@org.hibernate.annotations.Cache(
		usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE 
)
public class Bid {
	
	@Id
	@GeneratedValue
	private Long id;
 
    private Item item;
 
    public Item getItem() {
        return item;
    }
    
    public void setItem(Item item) {
    	this.item = item;
    	this.item.addBid(this);
    }
 
 
}
