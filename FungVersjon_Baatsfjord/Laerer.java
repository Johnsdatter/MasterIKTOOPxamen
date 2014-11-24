/* Dette er et objekt for hver enkelt tilgjengelige lærer, med navn, spesialkompetanse, oppgaver etc.
 * Brukes for å lagre tilgjengelige ressurser for bruk i fordelingsklassen.
 * Kodingen er utfoert av Jenny Emelia Nikolaisen
 * Bearbeiding av Rune
 * Dette er versjon nr. 3 (23.11.14)
*/

import javax.swing.JOptionPane;

public class Laerer
{
	private String laererNavn; //lærer som knyttes til kompetanse og oppgaver
	private String[] spesialKompetanse = new String[3]; //fagene lærerne har kompetanse i, maks 3
	private String[] spesielleOppgaver = new String[3]; //eks kontaktlærer, faglærer, IKT-ansvarlig osv., maks 3
	private int spesielleTimer; //som går til spesielle oppgaver
	private int stillingsProsent; //hvor mange prosent stilling har læreren
	private int tilgjengeligeTimer; //totalt tilgjengelige timer som kan fordeles

	//konstruktoer uten parameter, initialiserer
	public Laerer()
	{
		laererNavn = "";
		for (int i = 0; i < 3; i++)
		{
			spesialKompetanse[i] = "";
			spesielleOppgaver[i] = "";
		}
		spesielleTimer = 0;
		stillingsProsent = 0;
		tilgjengeligeTimer = 0;
	}

	//Konstruktør
	public Laerer(String lN, String[] sK, String[] sO, int sT, int sP, int tT)
	{
		laererNavn = lN;
		spesielleTimer = sT;
		stillingsProsent = sP;
		tilgjengeligeTimer = tT;
		for(int i = 0; i < 3; i++)
		{
			setSpesialKompetanse( i, sK[i] );
			setSpesielleOppgaver( i, sO[i] );
		}
	}
	private void setSpesialKompetanse( int i, String s )
	{
		spesialKompetanse[i] = s;
	}

	private void setSpesielleOppgaver( int i, String s )
	{
			spesielleOppgaver[i] = s;
	}

	//Gir mulighet for å endre timetallet etterhvert som lærer knyttes til oppgaver
	//Sett fra hovedklassen er dette eneste variabel som krever set metode.
	public void setTilgjengeligeTimer( int t )
	{
		tilgjengeligeTimer -= t;
	}

	public String getLaererNavn() // lager en get-metode som returnerer lærernavnet
	{
		return laererNavn;
	}

	/*
	public String[] getSpesialKompetanse() // lager en get-metode som returnerer spesialKompetanse som string array
	{
		return spesialKompetanse;
	}
	*/

	// lager en get-metode som returnerer verdien i posisjon gitt med int parameter indeks i string arrayet spesialKompetanse
	public String getSpesialKompetanse(int indeks)
	{
		return spesialKompetanse[ indeks ];
	}

	/*
	public String[] getSpesielleOppgaver() // lager en get-metode som returnerer
	{
		return spesielleOppgaver;
	}
	*/

	// lager en get-metode som returnerer verdien i posisjon gitt med int parameter indeks i string arrayet SpesielleOppgaver
	public String getSpesielleOppgaver(int indeks)
	{
		return spesielleOppgaver[indeks];
	}

	public int getSpesielleTimer() // lager en get-metode som returnerer
	{
		return spesielleTimer;
	}

	public int getStillingsProsent() // lager en get-metode som returnerer
	{
		return stillingsProsent;
	}

	public int getTilgjengeligeTimer() // lager en get-metode som returnerer
	{
		return tilgjengeligeTimer;
	}

	// metode for å sende debug informasjon
	private void debugMelding ( String m)
	{
		JOptionPane.showMessageDialog(null, m, "Fra klassen Laerer.", JOptionPane.PLAIN_MESSAGE );
	}

} // Slutt på klassen Laerer