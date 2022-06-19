public abstract class GenerateCard
{
	/* Default constructor
	   - Created by Ming -
	 */
	public GenerateCard ()
	{
	}
	
	/* Method creates a mana regen card that costs 0 mana to use for the player
	   - Developed by Ming -*/
	public Card GenBaseRegenManaCard ()
	{
		Card card = new Card (3, 20, 0);
		return card;
	}
	
	/* Generates a random value for card value used in subclasses
	   - Developed by Ming - */
	public int GenRandomVal (int min, int max)
	{
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
	
	public abstract Card GenAttackCard ();
	
	public abstract Card GenDefenceCard ();
	
	public abstract Card GenHealingCard ();
	
	public abstract Card GenRegenManaCard ();
}

