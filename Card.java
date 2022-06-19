public class Card
{
	public static final int ATTACK_CARD = 0;	//Value that represents attack card//
	public static final int DEFENCE_CARD = 1;	//Value that represents defence card//
	public static final int HEALING_CARD = 2;	//Value that represents support card//
	public static final int REGEN_CARD = 3;		//Value that represents regen card//
	
	private int cardType;		//Holds value for determining whether card is attack, defence or support//
	private int cardValue;		//Holds the value for damage, heal or defence//
	private int manaUsed;		//Holds value for how much mana is used when card is used//
	
	public Card ()
	{
	}
	
	/* Constructor creates a card object to store the card data
	   - Developed by Ming - */
	public Card (int cardType, int cardValue, int manaUsed)
	{
		this.cardType = cardType;
		this.cardValue = cardValue;
		this.manaUsed = manaUsed;
	}
	
	/* Method returns card type to decide what action to run in CardAction class
	   - Developed by Ming - */
	public int GetCardType()
	{
		return this.cardType;
	}
	
	/* Method returns card type to decide what action to run in CardAction class
	   - Developed by Ming - */
	public int GetCardValue()
	{
		return this.cardValue;
	}
	
	/* Method returns card type to decide what action to run in CardAction class
	   - Developed by Ming - */
	public int GetManaUsed()
	{
		return this.manaUsed;
	}
}
