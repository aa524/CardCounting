
public class Card {
	
private String rank;
private String suit;
private int value;

public Card(String rank, String suit, int value) {
	this.rank=rank;
	this.suit=suit;	
	this.value=value;
}

String getRank() {
	return rank;
}

String getSuit() {
	return suit;
}

int getValue() {
	return value;
}

public String toString() {
	return "The card is of rank: " + rank + " and suit: " + suit + " and value: " + value;
}
}
