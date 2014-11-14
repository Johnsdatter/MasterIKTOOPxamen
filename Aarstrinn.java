public class Aarstrinn
{
	private int maksoppføringer ;//= antall ; fagkoder totalt ? må denne defineres eller leses det av arrayet?
	private String[] fag; //= new String // [maksoppføringer];
	private int[] timer; //= new String[maksoppføringer];

	//konstruktør uten parametre, initialiserer klassen
	public Aarstrinn( int m )
	{
		maksoppføringer = m;
		fag = new String[maksoppføringer];
		timer = new int[maksoppføringer];
		for (int i = =; i < maksoppføringer; i++)
		{
			fag[i] = 0; timer[i] = "" ;  // er det etter dette jeg gjør timer til integer?
		}
	}

	public Aarstrinn (String f, int t)
	{
		//kode som ordner det
	}

	public Aarstrinn (String[] d)
		{
			for ( int i = 0 ; i < maksoppføringer; i++)
			{
				for ( int x = 0; x < 10 ; x++)
				{
					setFag ( i , d[i]);
					setTimer ( i , d[i+1]) ;
				}
			}
		}
		//konstruktør med argumenter. Er det her jeg må endre String t til Int t?
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

		public void setTimer ( int indeks, int t ) // må her også String t endres til Integer t?
		{
			timer [indeks] = t ;
		}

		// Get metode for å hente ut verdi i de lokale array variabelene fag og timer
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


