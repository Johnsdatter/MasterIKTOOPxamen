/* Klasse for hver enkelt tilgjengelige l�rer, med navn,
 * spesialkompetanse, oppgaver etc.
 * Brukes for � lagre tilgjengelige ressurser for bruk i
 * fordelingsklassen.
 *
 * Kodingen er utf�rt av Jenny Emelia Nikolaisen
 */

import javax.swing.JOptionPane;

public class Laerer
{
	// L�rer som knyttes til kompetanse og oppgaver
	private String laererNavn;
	// Fagene l�rerne har kompetanse i, maks 3
	private String[] spesialKompetanse = new String[3];
	// F.eks kontaktl�rer, IKT-ansvarlig osv., maks 3
	private String[] spesielleOppgaver = new String[3];
	// All tid som trekkes fra undervisningstid
	private int spesielleTimer;
	// Ledig undervisningstid
	private int tilgjengeligeTimer;

	// Konstrukt�rer

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

	private void setSpesialKompetanse( int i, String s )
	{
		spesialKompetanse[i] = s;
	}

	private void setSpesielleOppgaver( int i, String s )
	{
		spesielleOppgaver[i] = s;
	}

	public String getLaererNavn()
	{
		/*
		Returnerer l�rernavnet
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

		return tilgjengeligeTimer;// - spesielleTimer;
	}

} // Slutt p� klassen Laerer