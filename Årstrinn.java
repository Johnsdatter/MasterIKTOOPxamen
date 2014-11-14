/*************************** NB! ******************************** NB! ***************************
 * Dette er en midlertidig klasse som er laget for å teste ut ideer og funksjonalitet i klassen
 * Ressursfordeling. Hele klassen er basert på at det leses inn 5 fag og tilhørende timetall p/u.
 * Både fag og timer er i denne omgang valgt å være string variabler, men timer bør etterhvert
 * konverteres til int.
 * De respektive konstruktører og metoder må da også endres.
 ************************************************************************************************/ 
 
public class Årstrinn
{
	// Lager er lokal variabel som dimmensjonerer array variblene fag og timer
	// f.eks.: maksoppføringer = 5; betyr at det er lagd plass til fem fag og tilhørende timeantall
	private int maksoppføringer = 5;
	// Lager lokale string array variabler fag og timer
	private String[] fag = new String[maksoppføringer];
	private String[] timer = new String[maksoppføringer];

	// konstruktør uten parametre, initialiserer klassen
	public Årstrinn()
	{
		for ( int i = 0; i < maksoppføringer; i++ )
		{
			fag[i] = "";
			timer[i] = "";
		}
	}

	// konstruktør med string array parameter, som benyttes til å skrive timer og fag inn
	// når data foreliger på string array form. Parameternavn d er valgt siden jeg ser på
	// det som leses inn i objektet fra fildet som data (so d, short for data - men kunne
	// altså ha vært kalt hva som helst. 
	// Når denne konstruktøren benyttes foytsettes det at d tilordnes verdier på formen:
	// { "nor1", "2", "eng1", "3", "map1", "5", "efde1", "11", "efau1", "10" }
	// Etter at begge for - løkkene er ferdige vil string array d være sortert, og
	// da ser fag slik ut: 		{ "nor1", "eng1", "map1", "efde1", "efau1" }
	// da ser timer slik ut: 	{ "2", "3", "5", "11", "10" }
	public Årstrinn( String[] d )
	{
		// Søker gjennom d, og sorterer fag og timer til lokale array variabler
		for ( int i = 0; i < maksoppføringer; i++ )
		{
			for ( int x = 0; x < 10; x++ )
			{
				setFag( i, d[i] );
				setTimer( i, d[i+1] );
			}
		}
	}
	
	// konstruktør med parametere.
	// Benyttes til: HUSKER ikke i farta. Usikker på om den er i bruk!
	// Funksjon: Venter med å beskrive til jeg vet om den er ibruk
	public Årstrinn( int indeks, String f, String t )
	{
		setFag( indeks, f );
		setTimer( indeks, t );
	}

	// Set metode for tilordning av ny verdi til de lokale array variabelene fag og timer
	// indeks viser til posisjon i arrayet og f er verdien som skal skrives inn
	public void setFag( int indeks, String f )
	{
		fag[indeks] = f;
	}

	public void setTimer( int indeks, String t )
	{
		timer[indeks] = t;
	}
	
	// Get metode for å hente ut verdi i de lokale array variabelene fag og timer
	// indeksen viser til posisjonen i arrayet verdien skal hentes fra
	public String getFag(int indeks)
	{
		return fag[indeks];
	}


	public String getTimer(int indeks)
	{
		return timer[indeks];
	}
}
