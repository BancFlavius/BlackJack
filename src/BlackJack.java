import java.util.Scanner;

public class BlackJack {
    static boolean stay;
    static boolean busted;
    static Scanner input = new Scanner(System.in);
    static int playerCardOne, playerCardTwo, playerCardThree,  playerTotal;
    static int dealerCardOne, dealerCardTwo, dealerCardThree, dealerTotal;
    public static void main(String[] args) {


        System.out.println("Welcome to my blackjack program.");
        System.out.println("");

        //player's cards
        playerCardOne = (int) (Math.random() * 11);
        playerCardTwo = (int) (Math.random() * 11);
        playerTotal = playerCardOne + playerCardTwo;
        System.out.println("You drew " + playerCardOne + " and " + playerCardTwo);
        System.out.println("Your total is: " + playerTotal);
        System.out.println("");


        //dealer's cards
        dealerCardOne = (int) (Math.random() * 11);
        dealerCardTwo = (int) (Math.random() * 11);
        dealerTotal = dealerCardOne + dealerCardTwo;
        System.out.println("The dealer has " + dealerCardOne + " and a hidden card");
        System.out.println("His total is hidden.");
        System.out.println("");


        //player's choice (hit or stay)
        choice();

        //dealer's choice
        if(!busted) {
            System.out.println("");
            System.out.println("Okay, dealer's turn.");
            System.out.println("His hidden card was a " + dealerCardTwo);
            System.out.println("His total was " + dealerTotal);
            System.out.println("");
            dealer();
        }


        System.out.println("Dealer total is " + dealerTotal);
        System.out.println("Your total is " + playerTotal);
        System.out.println("");

        if (!busted) {
            if (dealerTotal < playerTotal) {
                System.out.println("You win!");
            } else if (dealerTotal == playerTotal) {
                System.out.println("It's a draw.");
            } else {
                System.out.println("The dealer won!");
            }
        }
    }


    static void dealer(){
        while (stay){

            if(dealerTotal < 16){
                dealerCardThree = (int)(Math.random()*11);
                dealerTotal += dealerCardThree;

                if(dealerTotal > 21) {
                    System.out.println("");
                    System.out.println("The dealer busted. You win!");
                    System.out.println("");
                    busted = true;
                    break;
                }

                System.out.println("He draws a " + dealerCardThree);
                System.out.println("His total is: "+dealerTotal);
                System.out.println("");
            } else {
                System.out.println("Dealer stays");
                System.out.println("");
                break;
            }
        }
    }

    static void choice(){
        while(!stay){
            System.out.print("Would you like to \"hit\" or \"stay\"? ");
            String hitOrStay = input.next();

            if(hitOrStay.toLowerCase().equals("hit")){
                int playerCardThree = (int)(Math.random()*11);
                playerTotal =  playerTotal + playerCardThree;

                if(playerTotal > 21){
                    System.out.println("");
                    System.out.println("You busted! The dealer wins.");
                    System.out.println("");
                    busted = true;
                    stay = true;
                    break;
                }

                System.out.println("You drew "+playerCardThree);
                System.out.println("Your total is: "+playerTotal);
                System.out.println("");
            } else if(hitOrStay.toLowerCase().equals("stay")){
                stay = true;
            }
        }
    }
}