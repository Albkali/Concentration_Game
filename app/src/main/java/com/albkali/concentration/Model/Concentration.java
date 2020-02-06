package com.albkali.concentration.Model;

import java.util.ArrayList;
import java.util.Collections;

public class Concentration {

    public ArrayList<Card> cards = new ArrayList<>();


    public int indexofOneAndOnlyFaceUpCard = -1;

    public Concentration(int noOfPairs) {
        for (int id = 0; id < noOfPairs; id++) {
            Card card = new Card(id);
            Card matchingCard = new Card(id);
            cards.add(card);
           cards.add(matchingCard);
        }

        //this line for make similar cards random by using shuffle().
        Collections.shuffle(cards);
    }


    public void chooseCard(int index) {
        if (cards.get(index).isMatched == false) {
            //There are 3 cases here
            //1. No cards are face up
            //2. Two cards are face up either matching or not matching
            //3. There is one card face up
            if (indexofOneAndOnlyFaceUpCard != -1) {
                //There is a single face up card
                int matchIndex = indexofOneAndOnlyFaceUpCard;
                //Ignore the case where the user touches the same face up card again
                if (matchIndex != index) {
                    //Check if the cards match
                    if (cards.get(matchIndex).identifier == cards.get(index).identifier) {
                        cards.get(matchIndex).isMatched = true;
                        cards.get(index).isMatched = true;
                    }
                    //Even if they don't match we have to turn the card face up
                    cards.get(index).isFaceUp = true;
                    indexofOneAndOnlyFaceUpCard = -1;
                }
            } else {
                //Either no cards or two cards are face up
                //In this case we'll turn all cards face down
                for (int i = 0; i < cards.size(); i++) {
                    cards.get(i).isFaceUp = false;
                }
                //Turn the chosen card face up
                cards.get(index).isFaceUp = true;
                indexofOneAndOnlyFaceUpCard = index;
            }

        }
    }

}
