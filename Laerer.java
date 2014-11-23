/* Dette er et objekt for hver enkelt tilgjengelige lærer, med navn, spesialkompetanse, oppgaver etc.
 * Brukes for å lagre tilgjengelige ressurser for bruk i fordelingsklassen.
 * Kodingen er utfoert av Jenny Emelia Nikolaisen
 * Bearbeiding av Rune
 * Dette er versjon nr. 2 (23.11.14), utenkompileringsfeil
*/

public class Laerer
{
	private String laererNavn; //lærer som knyttes til kompetanse og oppgaver
	private String[] spesialKompetanse = new String[3]; //fagene lærerne har kompetanse i, maks 3
	private String[] spesielleOppgaver = new String[3]; //eks kontaktlærer, faglærer, IKT-ansvarlig osv., maks 3
	private int spesielleTimer; //som går til spesielle oppgaver
	private int stillingsProsent; //hvor mange prosent stilling har læreren
	private int tilgjengeligeTimer; //totalt tilgjengelige timer som kan fordeles

	//konstruktoer
	public Laerer()
	{
	}

	//Konstruktør
	public Laerer(String lN, String[] sK, String[] sO, int sT, int sP, int tT)
	{
		laererNavn = lN;
		spesialKompetanse = sK;
		spesielleOppgaver = sO;
		spesielleTimer = sT;
		stillingsProsent = sP;
		tilgjengeligeTimer = tT;
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
	
	public String[] getSpesialKompetanse() // lager en get-metode som returnerer spesialKompetanse som string array
	{
		return spesialKompetanse;
	}
	
	// lager en get-metode som returnerer verdien i posisjon gitt med int parameter indeks i string arrayet spesialKompetanse
	public String getSpesialKompetanse(int indeks) 
	{
		if (indeks < 3)
			return spesialKompetanse[indeks];
		else
			return "";
	}
	
	public String[] getSpesielleOppgaver() // lager en get-metode som returnerer
	{
		return spesielleOppgaver;
	}
	
	// lager en get-metode som returnerer verdien i posisjon gitt med int parameter indeks i string arrayet SpesielleOppgaver
	public String getSpesielleOppgaver(int indeks)
	{
		if (indeks < 3)
			return spesielleOppgaver[indeks];
		else
			return "";
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

} // Slutt på klassen Laerer
