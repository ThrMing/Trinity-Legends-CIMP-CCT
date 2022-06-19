public class CardAction
{
	public static final int ATTACK_CARD = 0;		//Value that represents attack card//
	public static final int DEFENCE_CARD = 1;		//Value that represents defence card//
	public static final int HEAL_CARD = 2;			//Value that represents heal card//
	public static final int REGENMANA_CARD = 3;		//Value that represents regen mana card//
	
	private boolean isCheck = false;
	
	
	//==========================================================//
	//---------------------Private methods----------------------//
	//=========================================================//
	
	/* Private method checks if the opposite player's last card was a defence card
	   @param  - Player object for opposite player
	   @return - True if opposite player's last card was a defence card
	   	   - False if opposite player's last card was not a defence card
	   - Developed by Ming - */
	private boolean CheckLastUsedCard (Player oppositePlayer)
	{
		Card lastUsed = oppositePlayer.GetLastUsedCard ();
		
		if (lastUsed == null)
		{
			return false;
		}
		
		else if (lastUsed.GetCardType () == 1)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	/* Method calculates the amount of mana used
	   @param - manaUsed: the amount of mana requires to use the card
	          - currPlayer: player that used the card
	   - Developed by Ming -
	 */
	private int CalculateManaDepletion (int manaUsed, Player currPlayer)
	{
		//Calculates mana used by current player//
		return currPlayer.GetPlayerMana () - manaUsed;
	}
	
	/* Method calculates the effect card has on both players depending on card
	   - Developed by Brian - */
	private int CalculateCardEffect (int cardType, int cardValue, Player player)
	{
		if (cardType == 0)
		{
			//Calculates damage dealt by current player to opponent//
			return player.GetPlayerHealth () - cardValue;
		}
		
		else if (cardType == 2)
		{
			//Calculates how much to heal player//
			int newHealth = player.GetPlayerHealth () + cardValue;
			
			//If statement ensures health will never go above maximum health when heal card is used//
			if (newHealth > 200)
			{
				return 200;
			}
			
			else
			{
				return newHealth;
			}
		}
		
		else if (cardType == 3)
		{
			//Calculates how much mana to regen//
			int newMana = player.GetPlayerMana () + cardValue;
			
			//If statement ensures player's mana will never go above maximum 200 mana when regen mana card is used//
			if (newMana > 200)
			{
				return 200;
			}
			
			else
			{
				return newMana;
			}
		}
		else
		{
			return 0;
		}
	}
	
	//==========================================================//
	//----------------------Public methods----------------------//
	//=========================================================//
	
	/* Default constructor
	   - Created by Brian -
	 */
	public CardAction()
	{
	}
	
	/* Method runs the card action
	   - Method developed by Brian and Ming */
	public boolean RunAction (Card card, Player currPlayer, Player oppositePlayer)
	{
		int cardValue = card.GetCardValue ();
		int cardType = card.GetCardType ();
		int manaUsed = card.GetManaUsed ();
		
		if (manaUsed > currPlayer.GetPlayerMana ())
		{
			isCheck = false;
		}
		
		else
		{
			/* If statement runs the attack card
		   	   - Developed by Ming - */
			if (cardType == 0)
			{
				currPlayer.SetLastUsedCard (card);
				
				if (CheckLastUsedCard (oppositePlayer))
				{
					//Variable used to store final amount damage dealt after nullification from defence card//
					int nullifyAmt = oppositePlayer.GetLastUsedCard ().GetCardValue () - cardValue;
					
					//If the defence does not completely nullify the attack, oppositePlayer health will be depleted accordingly//
					if (nullifyAmt < 0)
					{
						//Calculates damage dealt by current player to opponent//
						int newHealth = oppositePlayer.GetPlayerHealth () + nullifyAmt;
						//Sets the health of the opponent according to how much damage was dealt//
						oppositePlayer.SetPlayerHealth (newHealth);
					}
				}
				
				else if (!CheckLastUsedCard (oppositePlayer))
				{
					oppositePlayer.SetPlayerHealth (CalculateCardEffect (cardType, cardValue, oppositePlayer));
				}
				
				currPlayer.SetPlayerMana (this.CalculateManaDepletion (manaUsed, currPlayer));
				
				isCheck = true;
			}
		
			/* If statement runs the defence card
		   	   - Developed by Ming - */
			else if (cardType == 1)
			{
				currPlayer.SetLastUsedCard (card);
				currPlayer.SetPlayerMana (this.CalculateManaDepletion (manaUsed, currPlayer));
				isCheck = true;
			}
		
			/* If statement runs the healing card
		   	   - Developed by Ming - */
			else if (cardType == 2)
			{
				currPlayer.SetLastUsedCard (card);
				currPlayer.SetPlayerHealth (CalculateCardEffect (cardType, cardValue, currPlayer));
				
				currPlayer.SetPlayerMana (this.CalculateManaDepletion (manaUsed, currPlayer));
				
				isCheck = true;
			}
		
			/* Method runs the regen mana card
		   	   - Developed by Ming - */
			else if (cardType == 3)
			{
				currPlayer.SetLastUsedCard (card);
				currPlayer.SetPlayerMana (this.CalculateManaDepletion (manaUsed, currPlayer));
				currPlayer.SetPlayerMana (this.CalculateCardEffect (cardType, cardValue, currPlayer));
				
				isCheck = true;
			}
		}
		
		return isCheck;
	}
}
