package org.ralphmorales.fx.fxHarvester.validator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.ralphmorales.fx.fxHarvester.lists.Currency;

public interface IValidator {

	public boolean validateRecord(String[]record);
	
	default boolean validateNoOfRows(String[] record, int expectedCount){
		return record.length == expectedCount;
	}
	
	default boolean validateDate(String date, String format){
		try {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.parse(date);
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	default boolean validateCurrency(String currency){
		try {
			Currency.valueOf(currency);
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	default boolean validateAmount(String amount){
		try {
			new BigDecimal(amount);
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
}
