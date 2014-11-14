public class Aarstrinn
{
	private int maksoppf�ringer ;//= antall ; fagkoder totalt ? m� denne defineres eller leses det av arrayet?
	private String[] fag; //= new String // [maksoppf�ringer];
	private int[] timer; //= new String[maksoppf�ringer];

	//konstrukt�r uten parametre, initialiserer klassen
	public Aarstrinn( int m )
	{
		maksoppf�ringer = m;
		fag = new String[maksoppf�ringer];
		timer = new int[maksoppf�ringer];
		for (int i = =; i < maksoppf�ringer; i++)
		{
			fag[i] = 0; timer[i] = "" ;  // er det etter dette jeg gj�r timer til integer?
		}
	}

	public Aarstrinn (String f, int t)
	{
		//kode som ordner det
	}

	public Aarstrinn (String[] d)
		{
			for ( int i = 0 ; i < maksoppf�ringer; i++)
			{
				for ( int x = 0; x < 10 ; x++)
				{
					setFag ( i , d[i]);
					setTimer ( i , d[i+1]) ;
				}
			}
		}
		//konstrukt�r med argumenter. Er det her jeg m� endre String t til Int t?
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

		public void setTimer ( int indeks, int t ) // m� her ogs� String t endres til Integer t?
		{
			timer [indeks] = t ;
		}

		// Get metode for � hente ut verdi i de lokale array variabelene fag og timer
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


