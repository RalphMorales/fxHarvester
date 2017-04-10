package org.ralphmorales.fx.fxHarvester.validator;

public class FxrecordValidator implements IValidator{

	@Override
	public boolean validateRecord(String[] record) {
		return (validateNoOfRows(record, 4) && validateDate(record[0], "M/d/yyyy hh:mm") 
				&& validateCurrency(record[1]) && validateCurrency(record[2]) 
				&& validateAmount(record[3]));
	}

}
