package split;

import java.util.ArrayList;

public class Entity {
	
	
	private int guid;
	
	//transactions for which the entity owes others
	private ArrayList<Transaction> debts;  
	
	//transactions for which others owe the entity
	private ArrayList<Transaction> credits;

	public ArrayList<Transaction> getDebts() {
		return debts;
	}

	public ArrayList<Transaction> getCredits() {
		return credits;
	}

	public void addDebt(Transaction t) {
		debts.add(t);
	}

	public void addCredit(Transaction t) {
		credits.add(t);
	}

}
