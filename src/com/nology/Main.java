package com.nology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
	// write your code here

        Scanner s = new Scanner(System.in);
        System.out.println("How many rounds do you want to play?");

        int GameRounds = Integer.parseInt(s.nextLine());
        for (int i = 0; i < GameRounds; i++) {
            playGame(s);
        }

    }



    private static void playGame(Scanner s) {

        // Array to Store players
       List<Player> playerList = new ArrayList<>();

       // Getting the players name before instantiating
        System.out.println("Welcome! Player 1 please enter your name");
        String playerOne = s.nextLine();
        System.out.println(" ");

        System.out.println("Welcome! Player 2 Please enter your name");
        String playerTwo = s.nextLine();
        System.out.println(" ");

        // instantiating and then adding the two players in a list
        playerList.add(new Player(playerOne));
        playerList.add(new Player(playerTwo));
        Player p1 = playerList.get(0);
        Player p2 = playerList.get(1);


        // Get input from the player
        System.out.println("Hey Player 1 its time to make your move! By typing either " +
                "rock, " +
                "paper," +
                " Or scissors");

        String player1 = s.nextLine();
        System.out.println("");
        String FirstPlayerName = playerList.get(0).getName();
        String input1 = playerList.get(0).getInput(player1);

        System.out.println("Hey Player 2 its time to make your move! By typing either " +
                "rock, " +
                "paper," +
                " Or scissors");

        String player2 = s.nextLine();
        System.out.println("");
        String SecondPlayerName = playerList.get(1).getName();
        String input2 = playerList.get(1).getInput(player2);

/// commented out computer logic //*
        // Get input from computer
//        Random random = new Random();
//        int randomNumber = random.nextInt(3);
//
//        String computer;
//        if (randomNumber == 0) {
//            computer = "rock";
//        } else if (randomNumber == 1) {
//            computer = "paper";
//        } else {
//            computer= "scissors";
//        }
//        System.out.println("Computer chose " + computer);//*

        // game logic begins here//

        int count1=0;

        int count2= 0;

        if (input1.equals(input2)) {
            System.out.println("It's a draw!");
        } else if (playerWins(input1, input2)) {
            // Player 1 wins and increments score using class method.
            System.out.println("Player " + FirstPlayerName + " wins!");
             count1++;
             p1.setScore(count1 + 1);
        } else {
            // Player 2 wins and increments score using class method.
            System.out.println("Player " + SecondPlayerName + " wins!");
            count2++;
            p2.setScore(count1 + 1);
            
        }

        // reporting of final scores
        GameScore(count1,count2,FirstPlayerName,SecondPlayerName);



    }

    private static void GameScore(int count1, int count2, String FirstPlayerName, String SecondPlayerName) {
        if (count1 > count2) {
            System.out.println(FirstPlayerName + " wins!"
                    + "\n with a score of: " + count1
                    + "\n" + SecondPlayerName + "looses"
                    + "\n with a score of: " + count2);
        } else if (count1 < count2){
            System.out.println(SecondPlayerName + " wins!"
                    + "\n with a score of: " + count2
                    + "\n " + FirstPlayerName + " looses"
                    + "\n with a score of: " + count1);
        } else {
            System.out.println(FirstPlayerName + " " + SecondPlayerName
                    + "drew and the score is: " + count1 + ":" + count2);
        }
    }


    static boolean playerWins(String player1, String player2){
        if (player1.equals("rock")) {
            return player2.equals("scissors");
        } else if (player1.equals("paper")) {
            return player2.equals("rock");
        } else {
            return player2.equals("paper");
        }
    }



}
