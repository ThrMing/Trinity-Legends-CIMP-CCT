public class Displayer
{
    /* Method prints out game title/intro
       - Created by Brian -
     */
    public void GameIntro()
    {
        System.out.println("================================================");
        System.out.println("|          WELCOME TO TRINITY LEGENDS          |");
        System.out.println("================================================");
    }

    /* Method prints out data for player to see
       - Method developed by Brian - */
    public void GameClasses()
    {
        System.out.println("CHOICE 1");
        System.out.println("===================================");
        System.out.println("|          WARRIOR CLASS          |");
        System.out.println("===================================");
        System.out.println("|     Health Points (HP) : 200    |");
        System.out.println("|     Perk: x2 damage             |");
        System.out.println("===================================");
    
        System.out.println("");
    
        System.out.println("CHOICE 2");
        System.out.println("===================================");
        System.out.println("|          PALADIN CLASS          |");
        System.out.println("===================================");
        System.out.println("|     Health Points (HP) : 200    |");
        System.out.println("|     Perk: x2 defense            |");
        System.out.println("===================================");

        System.out.println("");
    
        System.out.println("CHOICE 3");
        System.out.println("======================================");
        System.out.println("|            PRIEST CLASS            |");
        System.out.println("======================================");
        System.out.println("|     Health Points (HP) : 200       |");
        System.out.println("|     Perk: x2 healing and regen     |");
        System.out.println("======================================");
    }

    /* Method displays all 52 cards for user to choose
       - Developed by Brian -
     */
    public void DisplayCharacterCards(Card[] characterDeck)
    {
        for ( int i = 0 ; i < 52 ; i++)
        {
            int j = i+1;
            System.out.println ("        ==================================");
            
            if (j <= 9)
            {
                System.out.print ("Card " + j + "  ||     ");
            }
            else
            {
                System.out.print ("Card " + j + " ||     ");
            }
            
            
            if ( characterDeck[i].GetCardType () == 0)
            {
                System.out.println("Attack Value: " + characterDeck[i].GetCardValue () + "       ||");
                System.out.println ("        ||     Mana Required: " + characterDeck[i].GetManaUsed () + "        ||");
            }
            
            else if ( characterDeck[i].GetCardType () == 1)
            {
                System.out.println("Defence Value: " + characterDeck[i].GetCardValue () + "       ||");
                System.out.println ("        ||     Mana Required: " + characterDeck[i].GetManaUsed () + "        ||");
            }
            
            else if ( characterDeck[i].GetCardType () == 2)
            {
                System.out.println("Healing Value: " + characterDeck[i].GetCardValue () + "       ||");
                System.out.println ("        ||     Mana Required: " + characterDeck[i].GetManaUsed () + "        ||");
            }
            
            else if ( characterDeck[i].GetCardType () == 3)
            {
                System.out.println("Mana Regen Value: " +characterDeck[i].GetCardValue () + "       ||");
                System.out.println ("        ||     Mana Required: " + characterDeck[i].GetManaUsed () + "        ||");
            }
            System.out.println ("        ==================================\n");
        }
    }

    /* Method displays the basic and important rules for players to understand how to play the game
       - Developed by Brian -
     */
    public void HowToPlay()
    {
        System.out.println ("===================================================================================");
        System.out.println ("                                    How to play                                    ");
        System.out.println ("===================================================================================");
        System.out.println ("Each player will get to play only one card each round.\nPlayers will select 10 cards from their class to bring into the game.");
        System.out.println ("When one player's health reaches 0, the other player is declared the winner!" +
                                    "\nWhen one player's mana is insufficient to play even one card in deck, other player is declared winner! ");
        System.out.println ("Good luck!");
        System.out.println ("===================================================================================");
    }

    /* Method displays current player deck
       - Developed by Brian -
     */
    public void DisplayPlayerDeck (Card[] playerDeck)
    {
        for ( int i = 0 ; i < 5 ; i++)
        {
            int j = i+1;
            System.out.println ("        ==================================");
        
            if (j <= 9)
            {
                System.out.print ("Card " + j + "  ||     ");
            }
            else
            {
                System.out.print ("Card " + j + " ||     ");
            }
        
        
            if ( playerDeck[i].GetCardType () == 0)
            {
                System.out.println("Attack Value: " + playerDeck[i].GetCardValue () + "         ||");
                System.out.println ("        ||     Mana Required: " + playerDeck[i].GetManaUsed () + "         ||");
            }
        
            else if ( playerDeck[i].GetCardType () == 1)
            {
                System.out.println("Defence Value: " + playerDeck[i].GetCardValue () + "           ||");
                System.out.println ("        ||     Mana Required: " + playerDeck[i].GetManaUsed () + "          ||");
            }
        
            else if ( playerDeck[i].GetCardType () == 2)
            {
                System.out.println("Healing Value: " + playerDeck[i].GetCardValue () + "        ||");
                System.out.println ("        ||     Mana Required: " + playerDeck[i].GetManaUsed () + "         ||");
            }
        
            else if ( playerDeck[i].GetCardType () == 3)
            {
                System.out.println("Mana Regen Value: " + playerDeck[i].GetCardValue () + "        ||");
                System.out.println ("        ||     Mana Required: " + playerDeck[i].GetManaUsed () + "           ||");
            }
            System.out.println ("        ==================================\n");
        }
    }
    
    /* Method prints player1 data
      @parameter - player1 object
      - Developed by Brian -
     */
    public void DisplayPlayer1Data (Player player1)
    {
        if (player1.GetPlayerHealth () < 0)
        {
            System.out.println ("==========================");
            System.out.println ("| Player1 Health: 0        |\n| Player1 Mana: " + player1.GetPlayerMana () + "      |");
            System.out.println ("==========================");
        }
        else
        {
            System.out.println ("==========================");
            System.out.println ("| Player1 Health: " + player1.GetPlayerHealth () + "    |\n| Player1 Mana: " + player1.GetPlayerMana () + "      |");
            System.out.println ("==========================");
        }
    }
    
    /* Method prints player2 data
      @parameter - player2 object
      - Developed by Brian -
     */
    public void DisplayPlayer2Data (Player player2)
    {
        if (player2.GetPlayerHealth () < 0)
        {
            System.out.println ("==========================");
            System.out.println ("| Player2 Health: 0        |\n| Player2 Mana: " + player2.GetPlayerMana () + "      |");
            System.out.println ("==========================");
        }
        else
        {
            System.out.println ("==========================");
            System.out.println ("| Player2 Health: " + player2.GetPlayerHealth () + "    |\n| Player2 Mana: " + player2.GetPlayerMana () + "      |");
            System.out.println ("==========================");
        }
    }
    
    /*Method displays error message when user selects class that is not displayed on screen
      - Method developed by Brian -
     */
    public void DisplayClassError()
    {
        System.out.println("\n==========================================");
        System.out.println(" Error! Select a class that is available! ");
        System.out.println("==========================================\n");
    }
    
    /*Method displays error message when user selects card that is not displayed on screen
      - Method developed by Brian -
     */
    public void DisplayCardError()
    {
        System.out.println("\n=========================================");
        System.out.println(" Error! Select a card that is available! ");
        System.out.println("=========================================\n");
    }
    
    /* Method display winner message
       - Developed by Brian -
     */
    public void DisplayPlayer1Winner()
    {
        System.out.println("==========================================================");
        System.out.println("     Congratulations Player 1! You have won the game!     ");
        System.out.println("==========================================================");
    
    }
    
    /* Method display winner message
       - Developed by Brian -
     */
    public void DisplayPlayer2Winner()
    {
        System.out.println("==========================================================");
        System.out.println("     Congratulations Player 2! You have won the game!     ");
        System.out.println("==========================================================");
    }
    
    /* Method prints out insufficient mana message
       - Developed by Brian -
     */
    public void InsufficientMana ()
    {
        System.out.println ("==============================================");
        System.out.println ("Insufficient mana! Please choose another card!");
        System.out.println ("==============================================");
    }
    
    /* Method displays player move to notify opponent what current player has played
       - Developed by Brian -
     */
    public void DisplayPlayerMove (int currPlayer, Card lastUsed)
    {
        if (lastUsed.GetCardType () == 0)
        {
            System.out.println ("=====================================");
            System.out.println ("     Player" + currPlayer + " used an attack card!     ");
            System.out.println ("=====================================");
        }
    
        if (lastUsed.GetCardType () == 1)
        {
            System.out.println ("=====================================");
            System.out.println ("     Player" + currPlayer + " used a defence card!");
            System.out.println ("=====================================");
        }
        
        if (lastUsed.GetCardType () == 2)
        {
            System.out.println ("=====================================");
            System.out.println ("     Player" + currPlayer + " used a healing card!");
            System.out.println ("=====================================");
        }
        
        if (lastUsed.GetCardType () == 3)
        {
            System.out.println ("=========================================");
            System.out.println ("     Player" + currPlayer + " used a mana regen card!");
            System.out.println ("=========================================");
        }
    }
}
