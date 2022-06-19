import java.util.Random;
public class Game
{
	private CardAction runCard = new CardAction();		//Instantiate runCard object to use CardAction class//
	private Card[] player1Deck = new Card [10];		//Array instantiated to store player1's 10 cards//
	private Card[] player2Deck = new Card [10];		//Array instantiated to store player2"s 10 cards//
	private Player player1 = new Player ();			//player1 object instantiated to use player class with player1 data//
	private Player player2 = new Player ();			//player2 object instantiated to use player class with player2 data//
	private int currPlayer = 0;
	private boolean isCheck = false;
	
	//==========================================================//
	//---------------------Private methods----------------------//
	//=========================================================//
	
	/* Private helper method checks if player has sufficient mana to continue playing
	   @return - int; number of cards that cannot be played by player
	   - Developed by Brian -
	 */
	private int CheckSufficientMana (Player player, Card[] playerDeck)
	{
		//Counter keeps track of how many cards cannot be played due to insufficient mana//
		int counter = 0;
		
		for (int count = 0; count < 10; count++)
		{
			if (player.GetPlayerMana () < playerDeck[count].GetManaUsed ())
			{
				counter = counter + 1;
			}
		}
		return counter;
	}
	
	//==========================================================//
	//----------------------Public methods----------------------//
	//=========================================================//
	/* Default constructor
	   - Created by Ming -
	 */
	public Game ()
	{
	}
	
	/* Method switches player
	   @return - int, current player
	   - Developed by Brian -
	 */
	public void SwitchPlayer()
	{
		if (this.currPlayer == 1)
		{
			this.currPlayer = 2;
		}
		else
		{
			this.currPlayer = 1;
		}
	}
	
	/* Method returns current player
	   - Developed by Brian - */
	public int GetCurrPlayer ()
	{
		return this.currPlayer;
	}
	
	/* Method checks if there is a winner
	   - Developed by Brian -
	 */
	public boolean CheckWinnerByHealth ()
	{
		if (player1.GetPlayerHealth() <= 0 || player1.GetPlayerMana () <= 0)
		{
			isCheck = true;
		}
		else if (player2.GetPlayerHealth() <= 0 || player2.GetPlayerMana () <= 0)
		{
			isCheck = true;
		}
		else
		{
			isCheck = false;
		}
		return isCheck;
	}
	
	/* Method checks if there is a winner by mana
	   - Developed by Ming -
	 */
	public boolean CheckWinnerByMana ()
	{
		isCheck = false;
		
		if (this.CheckSufficientMana (player1, player1Deck) >= 1)
		{
			isCheck = true;
		}
		
		else if (this.CheckSufficientMana (player2, player2Deck) >= 1)
		{
			isCheck = true;
		}
		
		return isCheck;
	}
	
	/* Method returns player1 object to main
	   - Created by Ming - */
	public Player GetPlayer1Object ()
	{
		return this.player1;
	}
	
	/* Method returns player2 object to main
	   - Created by Ming - */
	public Player GetPlayer2Object ()
	{
		return this.player2;
	}
	
	/* Method generates player deck according to character chosen by player
	   @param - int characterType: the character chosen by player
	   - Developed by Ming -
	 */
	public void GenPlayerDeck (int characterType)
	{
		if (this.currPlayer == 0)
		{
			player1.GenerateDeck (characterType);
			this.currPlayer = 1;
		}
		else if (this.currPlayer == 1)
		{
			player2.GenerateDeck (characterType);
			this.currPlayer = 2;
		}
	}
	
	/* Method returns full character deck from player object to use displayer object in main
	   - Developed by Brian - */
	public Card[] GetCharacterDeck ()
	{
		if (this.currPlayer == 1)
		{
			return player1.GetCharacterDeck ();
		}
		else
		{
			return player2.GetCharacterDeck ();
		}
	}

	/* Method returns deck when called
	   - Developed by Brian -
	 */
	public Card[] GetCurrPlayerDeck ()
	{
		if (this.currPlayer == 1)
		{
			return player1Deck;
		}
		else
		{
			return player2Deck;
		}
	}
	
	/* Method sets the 10 cards chosen by player into respective player deck
	   - Developed by Brian -
	 */
	public boolean SetPlayerDeck (Card [] tempDeck)
	{
		if(this.currPlayer == 1)
		{
			for (int i = 0; i < 10; i++)
			{
				this.player1Deck[i] = tempDeck[i];
			}
			return true;
		}
		else if(this.currPlayer == 2) {
			for (int i = 0; i < 10; i++)
			{
				this.player2Deck[i] = tempDeck[i];
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/* Method shuffles card
	   - Developed by Brian -
	*/
	public boolean ShuffleCards (Card [] playerDeck)
	{
		boolean check = false;
		
		if (this.currPlayer == 1)
		{
			player1Deck = playerDeck;
			Random rand = new Random();
			for (int i = 0; i < 5; i++)
			{
				// Random for remaining positions.
				int r = i + rand.nextInt(10 - i);
				//swapping the elements
				Card temp = player1Deck[r];
				player1Deck[r] = player1Deck[i];
				player1Deck[i] = temp;
				check = true;
			}
		}
		
		else if (this.currPlayer == 2)
		{
			player2Deck = playerDeck;
			Random rand = new Random();
			for (int i = 0; i < 5; i++)
			{
				// Random for remaining positions.
				int r = i + rand.nextInt(10 - i);
				//swapping the elements
				Card temp = player2Deck[r];
				player2Deck[r] = player2Deck[i];
				player2Deck[i] = temp;
				check = true;
			}
		}
		
		return check;
	}
	
	/* Method runs card chosen by player
	   - Developed by Ming -
	 */
	public boolean RunCardAction (int choice)
	{
		isCheck = false;
		
		if (this.currPlayer == 1)
		{
			if (player1.GetPlayerMana () > 0)
			{
				runCard.RunAction (player1Deck[choice], player1, player2);
				System.out.println();
				isCheck = true;
			}
		}
		
		else if (this.currPlayer == 2)
		{
			if (player2.GetPlayerMana () > 0)
			{
				runCard.RunAction (player2Deck[choice], player2, player1);
				System.out.println();
				isCheck = true;
			}
		}
		
		return isCheck;
	}
}


