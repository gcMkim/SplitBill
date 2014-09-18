package split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {

	private ArrayList<Transaction> transactions;
	
	private HashMap<Integer, Double> creditors;
	
	private HashMap<Integer, Double> debtors;
	
	
	
	public void commitTransaction(Transaction t) {
		if (t.isTransactionValid()) {
			Map<Integer, Double> participants = t.getParticipatingEntities();
			
			for (Integer participantGuid : participants.keySet()) {
				if (creditors.containsKey(participantGuid)){
					double subtotal = creditors.get(participantGuid) + participants.get(participantGuid);
					if (subtotal > .01) {
						creditors.put(participantGuid, subtotal);
					} else if (subtotal < .01) {
						debtors.put(participantGuid, subtotal);
					} else {
						creditors.remove(participantGuid);
					}
				} else if (debtors.containsKey(participantGuid)) {
						double subtotal = debtors.get(participantGuid) + participants.get(participantGuid);
						if (subtotal > .01) {
							creditors.put(participantGuid, subtotal);
						} else if (subtotal < .01) {
							debtors.put(participantGuid, subtotal);
						} else {
							debtors.remove(participantGuid);
						}				
			} else if (participants.get(participantGuid) > .01) {
				creditors.put(participantGuid, participants.get(participantGuid));
			} else {
				debtors.put(participantGuid, participants.get(participantGuid));
			}
			}
		} else {
			//show error message; transaction isn't valid
		}		
	}
	
	
	
	
}
