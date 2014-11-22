/* Dette er et objekt for hver enkelt tilgjengelige l�rer, med navn, spesialkompetanse, oppgaver etc.
 * Brukes for � lagre tilgjengelige ressurser for bruk i fordelingsklassen.
 * Kodingen er utf�rt av Jenny Emelia Nikolaisen
 * Dette er versjon nr. 1 (21.11.14)
*/

public class Laerer
{
	private String laererNavn; //l�rer som knyttes til kompetanse og oppgaver
	private String spesialKompetanse; //fagene l�rerne har kompetanse i
	private String spesielleOppgaver; //eks kontaktl�rer, fagl�rer, IKT-ansvarlig osv.
	private int spesielleTimer; //som g�r til spesielle oppgaver
	private int stillingsProsent; //hvor mange prosent stilling har l�reren
	private int tilgjengeligeTimer; //totalt tilgjengelige timer som kan fordeles

	//konstrukt�r
	public Laerer()
	{
		laererNavn = "";
		spesialKompetanse = "";
		spesielleOppgaver = "";
		spesielleTimer = 0;
		stillingsProsent = 0;
		tilgjengeligeTimer = 0;
	}

	//Konstrukt�r
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

	public String getlaererNavn() // lager en get-metode som returnerer l�rernavnet
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

} // Slutt p� klassen Laerer