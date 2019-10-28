package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (Innlegg innleggITabell : innleggtabell) {
			if (innleggITabell != null && innleggITabell.erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		if (getAntall() < innleggtabell.length) {
			return true;
		}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig++] = innlegg;
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder(); 
		for (Innlegg innleggITabell : innleggtabell) {
			if (innleggITabell != null) {
				stringBuilder.append(innleggITabell.toString());
			}
		}
		
		return nesteledig + "\n" + stringBuilder; 
				
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] tempArray = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < innleggtabell.length; i++) {
			tempArray[i] = innleggtabell[i];
		}
		innleggtabell = tempArray;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public void slett(Innlegg innlegg) {
		int index = finnInnlegg(innlegg);
		if (index > -1) {
			innleggtabell[index] = null;
			// Må nesten rydde opp slik at nesteledig-- vil fungere. 
			Innlegg[] tempArray = new Innlegg[innleggtabell.length];
			for (int i = 0; i < innleggtabell.length; i++) {
				if (innleggtabell[i] != null) {
					tempArray[i] = innleggtabell[i];
				}
			}
			innleggtabell = tempArray;
			nesteledig--;
		}
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}