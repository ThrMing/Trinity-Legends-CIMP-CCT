public class WarriorCards extends GenerateCard
{
	/* Default constructor
	   - Created by Brian -
	 */
	public WarriorCards ()
	{
	}
	
	/* Method generates an attack card
	   - Developed by Ming - */
	public Card GenAttackCard ()
	{
		int attackVal = super.GenRandomVal (5, 20) * 2;
		int manaUsed;
		
		//If statement checks if attack is more than 10//
		if (attackVal > 10)
		{
			//manaUsed is assigned a higher value if damage is more than 15//
			manaUsed = super.GenRandomVal (20, 40);
		}
		
		else
		{
			//manaUsed is assigned a lower value if damage is less than 15//
			manaUsed = (int) (Math.random () * 20 + 1);
		}
		
		//Creates card object with the values created//
		Card card = new Card (0, attackVal, manaUsed);
		return card;
	}
	
	/* Method generates a defence card
	   - Developed by Ming - */
	public Card GenDefenceCard ()
	{
		int defenceVal = super.GenRandomVal (5, 15);
		int manaUsed;
		
		//If statement checks if attack is more than 15//
		if (defenceVal > 10)
		{
			//manaUsed is assigned a higher value if defence is more than 15//
			manaUsed = super.GenRandomVal (20, 30);
		}
		
		else
		{
			//manaUsed is assigned a lower value if defence is less than 15//
			manaUsed = (int) (Math.random () * 20 + 1);
		}
		
		//Creates card object with the values created//
		Card card = new Card (1, defenceVal, manaUsed);
		return card;
	}
	
	/* Method generates a healing card
	   - Developed by Brian -  */
	public Card GenHealingCard ()
	{
		int healingVal = super.GenRandomVal (5,20);
		int manaUsed;

		//If statement checks if attack is more than 15//
		if (healingVal > 10)
		{
			//manaUsed is assigned a higher value if defence is more than 15//
			manaUsed = super.GenRandomVal (20, 30);
		}
		else
		{
			//manaUsed is assigned a lower value if defence is less than 15//
			manaUsed = (int) (Math.random () * 20 + 1);
		}

		//Creates card object with the values created//
		Card card = new Card (2, healingVal, manaUsed);
		return card;
	}
	
	/* Method generates a regenerate mana card
	   - Developed by Brian	 */
	public Card GenRegenManaCard ()
	{
		int manaRegenVal = super.GenRandomVal (5,20);
		int manaUsed;

		//If statement checks if attack is more than 15//
		if (manaRegenVal > 10)
		{
			//manaUsed is assigned a higher value if defence is more than 15//
			manaUsed = super.GenRandomVal (20, 30);
		}
		else
		{
			//manaUsed is assigned a lower value if defence is less than 15//
			manaUsed = (int) (Math.random () * 20 + 1);
		}

		//Creates card object with the values created//
		Card card = new Card (3, manaRegenVal, manaUsed);
		return card;
	}
}
