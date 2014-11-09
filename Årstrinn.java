public class Årstrinn
{
	private int maksoppføringer = 5;
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

	public Årstrinn( String[] d )
	{
		for ( int i = 0; i < maksoppføringer; i++ )
		{
			for ( int x = 0; x < 10; x++ )
			{
				setFag( i, d[i] );
				setTimer( i, d[i+1] );
			}
		}
	}
	// konstruktør med argumenter
	public Årstrinn( int indeks, String f, String t )
	{
		setFag( indeks, f );
		setTimer( indeks, t );
	}

	public void setFag( int indeks, String f )
	{
		fag[indeks] = f;
	}

	public String getFag(int indeks)
	{
		return fag[indeks];
	}

	public void setTimer( int indeks, String t )
	{
		timer[indeks] = t;
	}

	public String getTimer(int indeks)
	{
		return timer[indeks];
	}
}