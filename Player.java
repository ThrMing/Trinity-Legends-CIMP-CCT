public class Player
{
	public static final int WARRIOR_TYPE = 0;	//Value representing Warrior class//
	public static final int PALADIN_TYPE = 1;	//Value representing Paladin class//
	public static final int PRIEST_TYPE = 2;	//Value representing Priest class//
	
	private int playerHealth = 200;
	private int playerMana = 200;
	private int characterType;
	private Card lastUsed;
	
	private Card[] characterDeck = new Card[52];	//Array to hold all possible 52 cards//
	
	//==========================================================//
	//---------------------Private methods----------------------//
	//=========================================================//
	/* Helper method creates cards and store them into the character deck
	   - Developed by Ming -
	 */
	private void GenerateCards (GenerateCard card)
	{
		//Assigns regen mana card as first card of character deck//
		characterDeck[0] = card.GenBaseRegenManaCard ();
		
		//Loops 17 times to create 17 attack cards//
		for (int count = 1; count < 18; count++)
		{
			characterDeck[count] = card.GenAttackCard ();
		}
		
		//Loops 17 times to create 17 defence cards//
		for (int count = 18; count < 35; count++)
		{
			characterDeck[count] = card.GenDefenceCard ();
		}
		
		//Loops 9 times to create 9 healing cards//
		for (int count = 35; count < 44; count++)
		{
			characterDeck[count] = card.GenHealingCard ();
		}
		
		//Loops 8 times to create 8 regen mana cards//
		for (int count = 44; count < 52; count++)
		{
			characterDeck[count] = card.GenRegenManaCard ();
		}
	}
	
	//==========================================================//
	//----------------------Public methods----------------------//
	//=========================================================//
	
	/* Default constructor
	   - Created by Ming -
	 */
	public Player ()
	{
	}
	
	/*Method generates deck according to character chosen by player
	  param - @characterType  - the character chosen by player
	  - Developed by Brian - */
	public boolean GenerateDeck (int characterType) {
		//Assigns chosen character to characterType in Player class//
		this.characterType = characterType;
		
		//If character chosen is Warrior//
		if (this.characterType == 0) {
			//Cards are generated using helper method//
			GenerateCards (new WarriorCards ());
			return true;
		}
		
		//If Paladin is chosen//
		else if (this.characterType == 1) {
			//Cards are generated using helper method//
			GenerateCards (new PaladinCards ());
			
			return true;
		}
		
		//If Priest class is chosen//
		else if (this.characterType == 2) {
			//Cards are generated using helper method//
			GenerateCards (new PriestCards ());
			
			return true;
		}
		
		//If player chooses a character that is non-existent, error message will be printed//
		else
		{
			return false;
		}
	}
	
	/* Method returns player health
	  - Created by Brian */
	public int GetPlayerHealth () {
		return this.playerHealth;
	}
	
	/* Method sets player health after card action
	   - Created by Brian - */
	public void SetPlayerHealth (int health) {
		this.playerHealth = health;
	}
	
	/* Method returns mana the player has
	   - Created by Brian - */
	public int GetPlayerMana () {
		return this.playerMana;
	}
	
	/* Method sets mana after a card has been used
	   - Created by Brian -	 */
	public void SetPlayerMana (int mana) {
		this.playerMana = mana;
	}
	
	/* Method sets the last used card to the last card played by player
	   - Created by Ming -*/
	public void SetLastUsedCard (Card card)
	{
		this.lastUsed = card;
	}
	
	/* Method returns the last used card
	   - Created by Ming -*/
	public Card GetLastUsedCard ()
	{
		return this.lastUsed;
	}
	
	/*Method returns deck to other classes to display the cards a player can choose from their chosen class
	  - Developed by Brian	 */
	public Card[] GetCharacterDeck()
	{
		return characterDeck;
	}
}
