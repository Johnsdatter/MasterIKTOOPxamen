/* Dette er et objekt for hver enkelt tilgjengelige lærer, med navn, spesialkompetanse, oppgaver etc.
 * Brukes for å lagre tilgjengelige ressurser for bruk i fordelingsklassen.
 * Kodingen er utført av Jenny Emelia Nikolaisen
 * Dette er versjon nr. 1 (21.11.14)
*/

public class Laerer
{
	private String laererNavn; //lærer som knyttes til kompetanse og oppgaver
	private String spesialKompetanse; //fagene lærerne har kompetanse i
	private String spesielleOppgaver; //eks kontaktlærer, faglærer, IKT-ansvarlig osv.
	private int spesielleTimer; //som går til spesielle oppgaver
	private int stillingsProsent; //hvor mange prosent stilling har læreren
	private int tilgjengeligeTimer; //totalt tilgjengelige timer som kan fordeles

	//konstruktør
	public Laerer()
	{
		laererNavn = "";
		spesialKompetanse = "";
		spesielleOppgaver = "";
		spesielleTimer = 0;
		stillingsProsent = 0;
		tilgjengeligeTimer = 0;
	}

	//Konstruktør
	public Laerer(String lN, String sK, String sO, int sT, int sP, int tT)
	{
		laererNavn = lN;
		spesialKompetanse = sK;
		spesielleOppgaver = sO;
		spesielleTimer = sT;
		stillingsProsent = sP;
		tilgjengeligeTimer = tT;
	}

	public String set(String )
	{

	}

	public String getlaererNavn() // lager en get-metode som returnerer lærernavnet
	{
			return ;
	}
	public String getspesialKompetanse() // lager en get-metode som returnerer
	{
			return ;
	}
	public String getspesielleOppgaver() // lager en get-metode som returnerer
	{
			return ;
	}
	public String getspesielleTimer() // lager en get-metode som returnerer
	{
			return ;
	}
	public String getstillingsProsent() // lager en get-metode som returnerer
	{
			return ;
	}
	public String gettilgjengeligeTimer() // lager en get-metode som returnerer
	{
			return ;
	}

} // Slutt på klassen Laerer