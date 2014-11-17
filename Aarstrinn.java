// I denne klassen skjer det egentlig ingenting. 
// Her bare defineres det variabler med tilhoerende datatyper, 
// det opprettes en tom konstruktoer,
// det opprettes en konstruktoer med argumenter (hva det betyr, har jeg ikke helt grep om ennaa )
// og det lages set og get metoder for variablene fag og timer som kan hentes fra andre klasser
//


public class Aarstrinn
{
	private int maksoppfoeringer ;
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

	public Aarstrinn (String[] f, int [] t ) 
		{
			for ( int i = 0 ; i < maksoppfoeringer; i++)
			{
				
				setFag ( i , f [i]);
				setTimer ( i , t [i+1]) ;
			}
		}
		//konstruktoer med argumenter. 
		public Aarstrinn (int indeks, String f, int t )
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
		public int getTimer ( int indeks )
		{
			return timer [ indeks ] ;
		}

		public String getFag (int indeks )
				{
					return fag [indeks] ;
		}
	}
}

