package user_data;

import index.bank;

public class convert {
	
	public void conversion() {
		double converted = Integer.parseInt(bank.fieldDolar1.getText());
		
		converted  = converted / 58;
		
		bank.fieldDolar2.setText(String.valueOf(converted));
	}

}
