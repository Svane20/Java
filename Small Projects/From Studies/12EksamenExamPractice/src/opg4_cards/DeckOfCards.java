package opg4_cards;

import java.util.Random;

public class DeckOfCards implements CardInterface {

    private Card[] deck;

    public DeckOfCards(){
        deck = new Card[NUMBER_OF_CARDS];
        int i = 0;
        for (int v = ACE; v <= KING; v++) {
            for (int c = CLUBS; c <= SPADES; c++) {
                deck[i] = new Card(v, c);
                i++;
            }
        }
       
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++) {
            if (i != 0 && i % 4 == 0) {
                sb.append("\n");
            }
            sb.append(deck[i]);
            if (i != deck.length-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps) {
        Random gen = new Random();
        Card temp = null;
        int position1, position2;

        for (int i = 0; i < swaps; i++) {
            position1 = gen.nextInt(deck.length);
            position2 = gen.nextInt(deck.length);

            temp = deck[position1];
            deck[position1] = deck[position2];
            deck[position2] = temp;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
            // Til test af opg 4 c
            DeckOfCards deckOfCards = new DeckOfCards();
            System.out.println("Opg 4c:\n" + deckOfCards);
            
            // Til test af opg 4 d
            deckOfCards.shuffle(100);
            System.out.println("Opg 4d:\n" + deckOfCards);
        

    }

}
