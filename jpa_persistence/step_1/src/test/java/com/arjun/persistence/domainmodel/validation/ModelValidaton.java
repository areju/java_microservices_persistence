package com.arjun.persistence.domainmodel.validation;

import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
 

import com.arjun.datapersistence.domainmodel.Item;

public class ModelValidaton {
	@Test
	public void validateItem() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Item item = new Item();
		item.setName("Some Name");
		item.setAuctionDate(new Date());
		
		Set<ConstraintViolation<Item>> violations = validator.validate(item);
		ConstraintViolation<Item> violation = violations.iterator().next();
		
		String failedPropertyName =
		        violation.getPropertyPath().iterator().next().getName();
		
		assertAll(
				() -> assertEquals(1, violations.size()),
				() -> assertEquals("auctionEnd", failedPropertyName),
				() -> {
					if(Locale.getDefault().getLanguage().equals("en"))
						assertEquals(violation.getMessage(), "must be a future date");
				});
		
		


		
	}

}
