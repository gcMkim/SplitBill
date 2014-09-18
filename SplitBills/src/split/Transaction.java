package split;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Transaction {

	private int guid;
	
	private String description;
	
	private Date date;
	
	private double totalAmount;
	
	//key = entity guids, value = amount either in credit or debt
	private HashMap<Integer, Double> participatingEntities;
	
	public HashMap<Integer, Double> getParticipatingEntities() {
		return participatingEntities;
	}
	
	public void addParticipant (int guid, double amount) {
		participatingEntities.put(guid, amount);
	}
	
	public boolean isTransactionValid() {
		double sumOfParticipatingEntities = new Double(0.0);
		Collection<Double> c = participatingEntities.values();
		for (Double amount : c) {
			sumOfParticipatingEntities += amount;
		}
		if (Math.abs(totalAmount - sumOfParticipatingEntities)<.01) {
			return true;
		} else {
			return false;
		}
	}
	
}
