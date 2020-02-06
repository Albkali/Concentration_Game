package com.albkali.concentration;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.albkali.concentration.Model.Card;
import com.albkali.concentration.Model.Concentration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    Button mCard01;
    TextView mFlips;
    int mNoOfFlips=0;
    public Concentration game;
    ArrayList<Button> cards = new ArrayList<Button>();
    public String[] emojiChoices={"😈","👻","💀","☠","👽","🎃","🐝","🎲","⚙","🔮",
            "♠","♣","♥","♦","👺","🐕","🐓","🐁","🐟","🐬"};
    Map<Integer, String> emoji=new HashMap<Integer, String>();
    ArrayList<String> emojiChoicesMutable = new ArrayList<String>(Arrays.asList(emojiChoices));
    public static final String TAG = MainActivity.class.getSimpleName();








    public void touchCard(View view) {

       // flipCard("😈", (Button) view);
       // this.setmNoOfFlips(mNoOfFlips+1);

        Log.i(TAG, "I am touched");
        int cardNumber=cards.indexOf((Button)view); game.chooseCard(cardNumber);
        updateViewFromModel(); this.setmNoOfFlips(mNoOfFlips+1);
    }






    public void flipCard(String emoji, Button card){
        if(card.getText()==emoji){
            card.setText(""); card.setBackgroundResource(R.drawable.button_fill);
        }
        else {
            card.setText(emoji);
            card.setBackgroundResource(R.drawable.button_stroke); }
    }



    void setmNoOfFlips(int noOfFlips){
        mNoOfFlips=noOfFlips;
        mFlips.setText("Flips :"+mNoOfFlips);
    }




    public void updateViewFromModel(){
        for(int i=0;i<cards.size();i++){
            Button button = cards.get(i);
            Card card = game.cards.get(i);
            if(card.isFaceUp){
                button.setText(emojiForCard(card));
                button.setBackgroundResource(R.drawable.button_stroke);
            }
            else{
                button.setText("");
                button.setBackgroundResource(R.drawable.button_fill);
                if(card.isMatched){
                    button.setVisibility(View.INVISIBLE);
                }
                }
        }
        }




    public String emojiForCard(Card card){
        String chosenEmoji=emoji.get(new Integer(card.identifier)); if(chosenEmoji==null){
            Random rand = new Random();
            int randomNum = rand.nextInt(emojiChoicesMutable.size());
            chosenEmoji=emojiChoicesMutable.get(randomNum);
            emoji.put(new Integer(card.identifier), chosenEmoji);
            emojiChoicesMutable.remove(chosenEmoji);
        }

        return chosenEmoji;
    }





        public void PlayAgain(View v) {

            finish();
            startActivity(getIntent());


        }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCard01=findViewById(R.id.card01);
        mFlips=findViewById(R.id.tv_flips);

        game = new Concentration( 8);

        cards.add((Button)findViewById(R.id.card01));
        cards.add((Button)findViewById(R.id.card02));
        cards.add((Button)findViewById(R.id.card03));
        cards.add((Button)findViewById(R.id.card04));
        cards.add((Button)findViewById(R.id.card05));
        cards.add((Button)findViewById(R.id.card06));
        cards.add((Button)findViewById(R.id.card07));
        cards.add((Button)findViewById(R.id.card08));
        cards.add((Button)findViewById(R.id.card09));
        cards.add((Button)findViewById(R.id.card10));
        cards.add((Button)findViewById(R.id.card11));
        cards.add((Button)findViewById(R.id.card12));
        cards.add((Button)findViewById(R.id.card13));
        cards.add((Button)findViewById(R.id.card14));
        cards.add((Button)findViewById(R.id.card15));
        cards.add((Button)findViewById(R.id.card16));

    }
}
