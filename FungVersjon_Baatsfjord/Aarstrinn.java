// I denne klassen defineres det variabler med tilhoerende datatyper,
// det opprettes en tom konstruktoer,
// det opprettes en konstruktoer med argumenter
// og det lages set og get metoder for variablene fag, timer og trinn som kan hentes fra andre klasser
//


public class Aarstrinn
{
	private String trinnNavn = "";
	private int maksoppfoeringer = 25 ;
	private String[] fag = new String[maksoppfoeringer];
	private int[] timer = new int[maksoppfoeringer];

	//konstruktoer uten parametre, initialiserer klassen
	public Aarstrinn()
	{
		for (int i = 0; i < maksoppfoeringer; i++)
		{
			fag[i] = "";
			timer[i] = 0;
		}
	}

	public Aarstrinn(String[] f, int [] t, String tr )
	{
		int x = 0;
		//sikrere metode for aa unngaa problemer med at arrayene har ulik stoerrelse
		if (f.length <= maksoppfoeringer)
		{
			trinnNavn = tr ;
			for(int i = 0; i < f.length; i++)
			{
				setFag ( i , f [i]);
				setTimer ( i , t [i]) ;
			}
		}
	}

	//konstruktoer med argumenter.
	public Aarstrinn(int indeks, String f, int t, String tr )
	{
		setFag ( indeks, f ) ;
		setTimer ( indeks, t ) ;
		trinnNavn = tr ;
	}

	//Set metode for tilordning av ny verdi til de lokale array variabelene fag, timer og trinn
	//indeks i viser til posisjon i arrayet og f er verdien som skal skrives inn

	public void setFag ( int i, String f )
	{
		fag [i] = f ;
	}

	public void setTimer ( int i, int t )
	{
		timer [i] = t ;
	}

	public void setTrinn ( String tr )
	{
		trinnNavn = tr ;
	}

	// Get metode for aa hente ut verdi i de lokale array variabelene fag, timer og trinn
	// i viser til posisjonen i arrayet verdien skal hentes fra
	public int getTimer ( int i )
	{
		return timer [ i ] ;
	}

	public String getFag ( int i )
	{
		return fag [i] ;
	}

	public String getTrinn ()
	{
		return trinnNavn ;
	}
}

