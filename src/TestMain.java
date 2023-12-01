import Cards.Card;
import Cards.Suit;

/**
 * @author Key Vollers
 * @project Card-Games
 * @date December 01, 2023
 */
public class TestMain {
    public static void main(String[] args) {
        Card testCard = new Card(Suit.DIAMOND, "5");
        testCard.printCard();
    }
}
