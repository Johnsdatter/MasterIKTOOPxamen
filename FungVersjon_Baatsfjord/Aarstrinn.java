/* I denne klassen defineres det variabler med tilhørende datatyper
 * for hvert årstrinn., samt set- og get-metoder for disse.
 *
 * Kodet av Kristina Johnsdatter Andreasen
 */

public class Aarstrinn
{
	private String trinnNavn;
	private int maksoppfoeringer = 25 ;
	private String[] fag = new String[maksoppfoeringer];
	private int[] timer = new int[maksoppfoeringer];

	// Konstruktører

	public Aarstrinn()
	{
		/*
		Oppretter objekt med tomme datafelter
		*/

		trinnNavn = "";
		for ( int i = 0; i < maksoppfoeringer; i++ )
		{
			fag[ i ] = "";
			timer[ i ] = 0;
		}
	}

	public Aarstrinn( String[] f, int [] t, String tr )
	{
		/*
		Fyller objektet med data
		*/

		int x = 0;
		setTrinn( tr );

		if ( f.length <= maksoppfoeringer )
		{
			for( int i = 0; i < f.length; i++)
			{
				setFag( i , f [i] );
				setTimer( i , t [i] ) ;
			}
		}
	}

	// Metoder, setter og returnerer objektets datafelter

	public void setFag( int i, String f )
	{
		fag[ i ] = f ;
	}

	public void setTimer( int i, int t )
	{
		timer[ i ] = t ;
	}

	public void setTrinn( String tr )
	{
		trinnNavn = tr ;
	}

	public String getFag( int i )
	{
		return fag[ i ] ;
	}

	public int getTimer( int i )
	{
		return timer[ i ] ;
	}

	public String getTrinn()
	{
		return trinnNavn ;
	}
}
