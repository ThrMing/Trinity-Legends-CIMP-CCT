import java.util.Scanner;

public class GameMain
{
    public static void main(String [] args)
    {
        Game game = new Game();                         //Instantiate game object to use Game class//
        Displayer displayer = new Displayer();          //Instantiate displayer object to use Displayer class//
        Scanner input = new Scanner (System.in);
        Card[] tempPlayerDeck = new Card [10];          //Array created to temporarily hold player's 10 selected cards//
        int choice;                                     //Keep track of player choice//
        boolean checkAction;
        
        //Program prints game into//
        displayer.GameIntro();
        displayer.HowToPlay ();
        
        //Program prints out the options for user to choose//
        displayer.GameClasses();
        System.out.print ("Player 1, Select your class: ");
        choice = input.nextInt();
        
        //While loop checks if player enters accepted option//
        while (choice <= 0 || choice > 3)
        {
            displayer.DisplayClassError ();
            //Program prints out the options for user to choose//
            displayer.GameClasses();
            System.out.print ("Player 1, Select your class: ");
            choice = input.nextInt();
        }
        
        //Code runs method in Game class that generates player deck//
        game.GenPlayerDeck (choice - 1);
        Card[] tempCharacterDeck = game.GetCharacterDeck ();
        
        System.out.println ("Player 1,  please select 10 cards to bring into the game.");
    
        //Displays all cards that the character has//
        displayer.DisplayCharacterCards (game.GetCharacterDeck ());
        
        //for loop gets player to select 10 cards to bring into the game//
        for (int count = 0; count < 10; count++)
        {
            System.out.println ("========================");
            System.out.println (10 - count + " cards left to choose.");
            System.out.print ("Player 1, select a card: ");
            choice = input.nextInt ();
            
            //While loop checks if user enters options showed on screen or not//
            while (choice <= 0 || choice > 52)
            {
                displayer.DisplayCardError ();
                displayer.DisplayCharacterCards (game.GetCharacterDeck ());
                System.out.print ("Player 1, select a card: ");
                choice = input.nextInt ();
            }
            tempPlayerDeck[count] = tempCharacterDeck[choice-1];
        }
        game.SetPlayerDeck (tempPlayerDeck);
        
        System.out.println ("\n======================");
        System.out.println ("     Next Player      ");
        System.out.println ("======================\n");
    
        //Program prints out the options for user to choose//
        displayer.GameClasses();
        System.out.print ("Player 2, Select your class: ");
        choice = input.nextInt();
    
        //While loop checks if player enters accepted option//
        while (choice <= 0 || choice > 3)
        {
            displayer.DisplayClassError ();
            //Program prints out the options for user to choose//
            displayer.GameClasses();
            System.out.print ("Player 2, Select your class: ");
            choice = input.nextInt();
        }
    
        //Code runs method in Game class that generates player deck//
        game.GenPlayerDeck (choice - 1);
        tempCharacterDeck = game.GetCharacterDeck ();
        
        System.out.println ("Player 2,  please select 10 cards to bring into the game.");
    
        //Displays all character cards available//
        displayer.DisplayCharacterCards (game.GetCharacterDeck ());
    
        //For loops asks player to select 10 cards//
        for (int count = 0; count < 10; count++)
        {
            System.out.println (10 - count + " cards left to choose.");
            System.out.print ("Player 2, select a card: ");
            choice = input.nextInt ();
        
            //While loop checks if user enters options showed on screen or not//
            while (choice <= 0 || choice > 52)
            {
                displayer.DisplayCardError ();
                displayer.DisplayCharacterCards (game.GetCharacterDeck ());
                System.out.print ("Player 2, select a card: ");
                choice = input.nextInt ();
            }
            tempPlayerDeck[count] = tempCharacterDeck[choice-1];
        }
        game.SetPlayerDeck (tempPlayerDeck);
        
        System.out.println ("\n======================================");
        System.out.println ("     It's time to start the game!     ");
        System.out.println ("========================================\n");
    
        trinityLegends: {
            while (true)
            {
                displayer.DisplayPlayer1Data (game.GetPlayer1Object ());
                displayer.DisplayPlayer2Data (game.GetPlayer2Object ());
                
                //If statement checks for winner by depleting opponent's health//
                if (game.CheckWinnerByHealth ())
                {
                    if (game.GetCurrPlayer () == 1)
                    {
                        System.out.println ("=======================================");
                        System.out.println ("|     Player2 has no more health!     |");
                        System.out.println ("=======================================");
                        displayer.DisplayPlayer1Winner ();
                        break trinityLegends;
                    }
                    else
                    {
                        System.out.println ("=======================================");
                        System.out.println ("|     Player1 has no more health!     |");
                        System.out.println ("=======================================");
                        displayer.DisplayPlayer2Winner ();
                        break trinityLegends;
                    }
                }
                
                //If statement checks if there is winner by checking if one player's mana is unable to play a card in the deck//
                else if (game.CheckWinnerByMana ())
                {
                    if (game.GetCurrPlayer () == 1)
                    {
                        System.out.println ("===========================================================");
                        System.out.println ("|     Player1 has insufficient mana to play one card!     |");
                        System.out.println ("===========================================================");
                        displayer.DisplayPlayer2Winner ();
                        break trinityLegends;
                    }
                    else
                    {
                        System.out.println ("===========================================================");
                        System.out.println ("|     Player2 has insufficient mana to play one card!     |");
                        System.out.println ("===========================================================");
                        displayer.DisplayPlayer1Winner ();
                        break trinityLegends;
                    }
                }
                
                //If no winner is produced, program will continue running the game//
                else
                {
                    game.SwitchPlayer ();
                    
                    /* If statements run the game accordingly
                       - Developed by Brian and Ming -
                     */
                    if (game.GetCurrPlayer () == 1 )
                    {
                        game.ShuffleCards (game.GetCurrPlayerDeck ());
                        displayer.DisplayPlayerDeck (game.GetCurrPlayerDeck ());
                        System.out.print ("Player 1, select a card to play: ");
                        choice = input.nextInt ();
        
                        //While loop checks if user enters acceptable input//
                        while (choice < 0 || choice > 5)
                        {
                            displayer.DisplayCardError ();
                            System.out.print ("Player 1, select a card to play: ");
                            choice = input.nextInt ();
                        }
                        
                        checkAction = game.RunCardAction (choice - 1);
    
                        while (!checkAction)
                        {
                            displayer.InsufficientMana ();
                            System.out.print ("Player 1, select a card to play: ");
                            choice = input.nextInt ();
                            checkAction = game.RunCardAction (choice - 1);
                        }
                        
                        displayer.DisplayPlayerMove (game.GetCurrPlayer (), game.GetPlayer1Object ().GetLastUsedCard ());
                    }
                    
                    else
                    {
                        game.ShuffleCards (game.GetCurrPlayerDeck ());
                        displayer.DisplayPlayerDeck (game.GetCurrPlayerDeck ());
                        System.out.print ("Player 2, select a card to play: ");
                        choice = input.nextInt ();
        
                        //While loop checks if user enters acceptable input//
                        while (choice < 0 || choice > 5)
                        {
                            displayer.DisplayCardError ();
                            System.out.print ("Player 2, select a card to play: ");
                            choice = input.nextInt ();
                        }
    
                        checkAction = game.RunCardAction (choice - 1);
    
                        while (!checkAction)
                        {
                            displayer.InsufficientMana ();
                            System.out.print ("Player 2, select a card to play: ");
                            choice = input.nextInt ();
                            checkAction = game.RunCardAction (choice - 1);
                        }
    
                        displayer.DisplayPlayerMove (game.GetCurrPlayer (), game.GetPlayer2Object ().GetLastUsedCard ());
                    }
                }
                
                System.out.println ("=====================");
                System.out.println ("     Next round!     ");
                System.out.println ("=====================\n");
            }
        }
    }
}
