package Cards;

/**
 * Represents the values of a card.
 * <p>
 * **SUIT**
 * Stored as a ENUM value - (HEART, DIAMOND, CLUB SPADE)
 * <p>
 * **RANK**
 * Is the String representation of the card. There are 13 possible values for a card.
 * Number Cards - ("2", "3", ... , "10")
 * Face Cards - ("JACK", "QUEEN", "KING", "ACE")
 * Unrecognized rank will be stored as "UNKNOWN"
 * <p>
 * **VALUE**
 * Is the Value of each card.
 * Number Cards - worth the value stated on the card EX: "2" = 2, "3" = 3 "10" = 10
 * JACK = 11
 * QUEEN = 12
 * KING = 13
 * ACE = 1
 * Value can be set manually by adding it into the constructor. (If the value is set manually, it will not be
 * error checked.)
 * <p>
 * **STRING VALUE**
 * Will take the form of
 * ------ - Top line represented with the Unicode letter \u2581
 * |2  S| - 2 represents the rank 2 card
 * |    | - Right Vertical is unicode letter \u2595 Left Vertical is unicode letter \u258F
 * |S  2| - S represents the actual Unicode value for a spade.
 * ------ - Bottom line represented with the Unicode letter \u2594
 *
 * @author Key Vollers
 * @project Card-Games
 * @date December 01, 2023
 */
public class Card {

    // Values
    private final Suit suit;
    private final String rank;
    private final int value;

    // Terminal Graphics
    private final String topCard = "\u2581\u2581\u2581\u2581\u2581\u2581";
    private final String topLineCard;
    private final String middleCard = "\u258F \u2513\u2517 \u2595";
    private final String bottomLineCard;
    private final String bottomCard = "\u2594\u2594\u2594\u2594\u2594\u2594";
    private final String fullCard;

    /**
     * Will set up a new card.
     * Unofficial rank will result in "UNKNOWN" as the rank String and 0 as the rank value.
     *
     * @param suit stored as an ENUM values - (HEART, DIAMOND, CLUB, SPADE)
     * @param rank stored as a string value
     *             Number Cards - ("2", "3", ... , "10")
     *             Face Cards - ("JACK", "QUEEN", "KING", "ACE")
     */
    public Card(final Suit suit, final String rank) {
        // Setting Values
        this.suit = suit;
        this.rank = setRank(rank);
        value = setValue(this.rank);

        // Setting Terminal Graphics
        topLineCard = setTopLineCard();
        bottomLineCard = setBottomLineCard();
        fullCard = setFullCard();
    }

    /**
     * Will set up a new card.
     * Unofficial rank will result in "UNKNOWN" as the rank String.
     *
     * @param suit  stored as an ENUM values - (HEART, DIAMOND, CLUB, SPADE)
     * @param rank  stored as a string value
     *              Number Cards - ("2", "3", ... , "10")
     *              Face Cards - ("JACK", "QUEEN", "KING", "ACE")
     * @param value stored as an integer - will set the value of the card to your custom value
     */
    public Card(final Suit suit, final String rank, final int value) {
        // Setting Values
        this.suit = suit;
        this.rank = setRank(rank);
        this.value = value;

        // Setting Terminal Graphics
        topLineCard = setTopLineCard();
        bottomLineCard = setBottomLineCard();
        fullCard = setFullCard();
    }

    // TODO: Set up error handling for bad rank.
    private String setRank(final String rank) {
        switch (rank) {
            case "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE" -> {
                return rank;
            }
            default -> {
                return "UNKNOWN";
            }
        }

    }

    private int setValue(final String rank) {
        switch (rank) {
            case "2" -> {
                return 2;
            }
            case "3" -> {
                return 3;
            }
            case "4" -> {
                return 4;
            }
            case "5" -> {
                return 5;
            }
            case "6" -> {
                return 6;
            }
            case "7" -> {
                return 7;
            }
            case "8" -> {
                return 8;
            }
            case "9" -> {
                return 9;
            }
            case "10" -> {
                return 10;
            }
            case "JACK" -> {
                return 11;
            }
            case "QUEEN" -> {
                return 12;
            }
            case "KING" -> {
                return 13;
            }
            case "ACE" -> {
                return 1;
            }
            default -> {
                return 0;
            }
        }
    }

    private String setFullCard() {
        return topCard + "\n" +
                "\u258F" + topLineCard + "\u2595\n" +
                middleCard + "\n" +
                "\u258F" + bottomLineCard + "\u2595\n" +
                bottomCard;
    }

    private String setTopLineCard() {
        StringBuilder topLine = new StringBuilder();

        if (rank.equals("10")) {
            topLine.append(rank);
            topLine.append(" ");
        } else {
            topLine.append(rank.charAt(0));
            topLine.append("  ");
        }

        topLine.append(getSuitUnicodeValue());

        return topLine.toString();
    }

    private String setBottomLineCard() {
        StringBuilder bottomLine = new StringBuilder();

        bottomLine.append(getSuitUnicodeValue());

        if (rank.equals("10")) {
            bottomLine.append(" ");
            bottomLine.append(rank);
        } else {
            bottomLine.append("  ");
            bottomLine.append(rank.charAt(0));
        }

        return bottomLine.toString();
    }

    // Default is SPADE
    private char getSuitUnicodeValue() {
        switch (suit) {
            case HEART -> {
                return '\u2665';
            }
            case DIAMOND -> {
                return '\u2666';
            }
            case CLUB -> {
                return '\u2663';
            }
            default -> {
                return '\u2660';
            }
        }
    }

    /**
     * Will take the form of
     * ------ - Top line represented with the Unicode letter \u2581
     * |2  S| - 22 represents the rank 2 card
     * |    | - Right Vertical is unicode letter \u2595 Left Vertical is unicode letter \u258F
     * |S  2| - SS represents the actual Unicode value for a spade.
     * ------ - Bottom line represented with the Unicode letter \u2594
     *
     * @return new string representation of
     */
    @Override
    public String toString() {
        return fullCard;
    }

    /**
     * Will print the string value of the card.
     */
    public void printCard() {
        System.out.println(this.toString());
    }
}
