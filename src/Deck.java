import java.util.*;
import javax.swing.JOptionPane;
public class Deck {
	private Random random=new Random();
	private ArrayList<Card> cardArray= new ArrayList<Card>();
	private String[] suits= {"Clubs", "Hearts", "Diamonds", "Spades"};
	private String[] ranks= {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

	public Deck(int n) {
		cardArray.clear();
		for (int i=0; i<n; i++){
			for (int suit=0; suit<4; suit++){
				for(int rank=0; rank<13; rank++){
					//implementing Hi-lo method
					if (rank<5) {
						cardArray.add(new Card(ranks[rank], suits[suit], 1));
					}
					else if (rank>=8) {
						cardArray.add(new Card(ranks[rank], suits[suit], -1));
					}
					else {
						cardArray.add(new Card(ranks[rank], suits[suit], 0));
					}
				}
			}
		}
	}
	
	public Card[] getCards(int n) {
		if (n > cardArray.size()) {
			throw new IllegalStateException("You chose too many cards");
		}
		Card[] holder= new Card[n];
		for (int i=0; i<n; i++) {
			holder[i]=cardArray.remove(random.nextInt(cardArray.size()));
		}
		return holder;
	}

	public static void main(String[] args) throws InterruptedException {
		Deck deck= new Deck(1);
		Card[] check= deck.getCards(52);
		int count=0;
		for (int i=0; i<check.length; i++) { 
			System.out.printf(check[i] + "\n");
			JOptionPane.showMessageDialog(null, check[i] + " running count is " + count, "yo check it", JOptionPane.INFORMATION_MESSAGE);
			count+=check[i].getValue();
			Thread.sleep(450);
		}
	//	throw new InterruptedException("Running count is " + count);
		
	}
	
}
