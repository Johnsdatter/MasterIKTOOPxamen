// I denne klassen skjer det egentlig ingenting. 
// Her bare defineres det variabler med tilhoerende datatyper, 
// det opprettes en tom konstruktoer,
// det opprettes en konstruktoer med argumenter (hva det betyr, har jeg ikke helt grep om ennaa )
// og det lages set og get metoder for variablene fag og timer som kan hentes fra andre klasser
//
// og jeg endrer variabelen fag fra datatype string til int?
//


public class Aarstrinn
{
	private int maksoppfoeringer = 22 ;
	private String[] fag; //= new String // [maksoppfoeringer];
	private int[] timer; //= new String[maksoppfoeringer];

	//konstruktoer uten parametre, initialiserer klassen
	public Aarstrinn( int m )
	{
		maksoppfoeringer = m;
		fag = new String[maksoppfoeringer];
		timer = new int[maksoppfoeringer];
		for (int i = =; i < maksoppfoeringer; i++)
		{
			fag[i] = 0; timer[i] = "" ; 
		}
	}

	public Aarstrinn (String[] d) // d står for data, altså innlest fra fil
		{
			for ( int i = 0 ; i < maksoppfoeringer; i++)
			{
				for ( int x = 0; x < 10 ; x++)
				{
					setFag ( i , d[i]);
					setTimer ( i , d[i+1]) ;
				}
			}
		}
		//konstruktoer med argumenter. Er det her jeg maa endre String t til Int t?
		public Aarstrinn (int indeks, String f, String t )
		{
			setFag ( indeks, f ) ;
			setTimer ( indeks, t ) ;
		}

		//Set metode for tilordning av ny verdi til de lokale array variabelene fag og timer
		//indeks viser til posisjon i arrayet og f er verdien som skal skrives inn

		public void setFag ( int indeks, String f )
		{
			fag [indeks] = f ;
		}

		public void setTimer ( int indeks, int t ) 
		{
			timer [indeks] = t ;
		}

		// Get metode for aa hente ut verdi i de lokale array variabelene fag og timer
		// indeksen viser til posisjonen i arrayet verdien skal hentes fra
		public String getTimer ( int indeks )
		{
			return timer [ indeks ] ;
		}

		public String getFag (int indeks )
				{
					return fag [indeks] ;
		}
	}
}

