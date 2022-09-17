package poker;
import java.util.Arrays;   

public class Poker {
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isFullHouse(String cards[], int n) {
		return isThreeOfaKind(cards, n) && isTwoPairs(cards, n) && !isFour(cards,n);
	}
	public String[] slice(String arr[], int n, int m) {
		String[] res = Arrays.copyOfRange(arr,n,m);
		return res;
	}
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isThreeOfaKind(String cards[], int n) {
		for (int i=0; i<n-2; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
					cards[i+1].charAt(1) == cards[i+2].charAt(1))
					return true;
		}

		return false;
	}

	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isTwoPairs(String cards[], int n) {
		int count = 0;
		for (int i=0; i<n-1; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1)) {
				count++;
				i++;
			}
		}
		if (count == 2)
			return true;
		else
			return false;
	}
	
	public boolean isFour(String cards[], int n) {
		int i =0;
//		if(isThreeOfaKind(cards,n)) {
//			if((cards[i].charAt(1) == cards[i+1].charAt(1) &&
//					cards[i+1].charAt(1) == cards[i+2].charAt(1) && cards[i+2].charAt(1) == cards[i+3].charAt(1))
//					|| cards[i+1].charAt(1) == cards[i+2].charAt(1) &&
//					cards[i+2].charAt(1) == cards[i+3].charAt(1) && cards[i+3].charAt(1) == cards[i+4].charAt(1)){
//						return true;
//					}
//		}
		if(isThreeOfaKind(slice(cards,0,3),4) && isThreeOfaKind(slice(cards,1,4),4)){
			return true;
		}
		return false;
	}
	public static void main(String args[]) {
		System.out.println(new Poker().isFullHouse(
			new String[] {"C2", "D2", "H2", "S3", "S4"}, 5));
	}
}
// end of Poker.java
