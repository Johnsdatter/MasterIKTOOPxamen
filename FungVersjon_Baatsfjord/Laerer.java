/* Klasse for hver enkelt tilgjengelige lærer, med navn, spesialkompetanse, oppgaver etc.
 * Brukes for å lagre tilgjengelige ressurser for bruk i fordelingsklassen.
 *
 * Kodingen er utført av Jenny Emelia Nikolaisen
 */

import javax.swing.JOptionPane;

public class Laerer
{
	private String laererNavn; // Lærer som knyttes til kompetanse og oppgaver
	private String[] spesialKompetanse = new String[3]; // Fagene lærerne har kompetanse i, maks 3
	private String[] spesielleOppgaver = new String[3]; // F.eks kontaktlærer, IKT-ansvarlig osv., maks 3
	private int spesielleTimer; // All tid som trekkes fra undervisningstid
	private int tilgjengeligeTimer; // Ledig undervisningstid

	// Konstruktører

	public Laerer()
	{
		// Initialiserer objektet med tomme verdier

		laererNavn = "";
		for (int i = 0; i < 3; i++)
		{
			spesialKompetanse[i] = "";
			spesielleOppgaver[i] = "";
		}
		spesielleTimer = 0;
		tilgjengeligeTimer = 0;
	}

	public Laerer(String lN, String[] sK, String[] sO, int sT, int tT)
	{
		// Setter verdier til objektet

		laererNavn = lN;
		spesielleTimer = sT;
		tilgjengeligeTimer = tT;

		for(int i = 0; i < 3; i++)
		{
			setSpesialKompetanse( i, sK[i] );
			setSpesielleOppgaver( i, sO[i] );
		}
	}

	// Metoder

	public void setTilgjengeligeTimer( int t )
	{
		/*
		Trekker bundne timer fra tilgjengelig tid. Brukes i fordelinga.
		*/

		tilgjengeligeTimer -= t;
	}

	public String getLaererNavn()
	{
		/*
		Returnerer lærernavnet
		*/

		return laererNavn;
	}

	public String getSpesialKompetanse(int indeks)
	{
		/*
		Returnerer spesialkompetanse i gitt indeks
		*/

		return spesialKompetanse[ indeks ];
	}

	public String getSpesielleOppgaver(int indeks)
	{
		/*
		Returnerer spesiell oppgave av gitt indeks
		*/

		return spesielleOppgaver[indeks];
	}

	public int getSpesielleTimer()
	{
		/*
		Returnerer antall spesielle timer
		*/

		return spesielleTimer;
	}

	public int getTilgjengeligeTimer()
	{
		/*
		Returnerer tilgjengelige timer minus spesielle timer,
		som skal trekkes fra undervisningstid.
		*/

		return tilgjengeligeTimer - spesielleTimer;
	}

} // Slutt på klassen Laerer