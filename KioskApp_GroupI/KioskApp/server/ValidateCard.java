//Nur Aisya Fatihah
package server;

public class ValidateCard {
	private String card;
	
	public ValidateCard(String card) {
		this.card=card;
	}
	
	public ValidateCard() {
		
	}
	
	public void setCard(String card) {
		this.card=card;
	}
	
	public String getCard() {
		return card;
	}

	public String getValidateCard(String card){
		if(card.length() != 16) {
			String cardVal="invalid";
			return cardVal;
	}
		else {
			String cardVal="valid";
			return cardVal;
		}
}
}
