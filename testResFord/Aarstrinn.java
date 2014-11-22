// I denne klassen skjer det egentlig ingenting.
// Her bare defineres det variabler med tilhoerende datatyper,
// det opprettes en tom konstruktoer,
// det opprettes en konstruktoer med argumenter (hva det betyr, har jeg ikke helt grep om ennaa )
// og det lages set og get metoder for variablene fag og timer som kan hentes fra andre klasser
//

import javax.swing.JOptionPane;

public class Aarstrinn
{
	private String test = "";
	private int maksoppfoeringer = 25;
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

	public Aarstrinn(String[] f, int [] t )
	{
		int x = 0;
		// Sikrere metode for å unngå problemer med at arrayene har ulik størrelse
		if (f.length <= maksoppfoeringer)
		{
			for(int i = 0; i < f.length; i++)
			{
				setFag(i, f[i]);
				setTimer(i, t[i]);
			}
		}
	}

	//konstruktoer med argumenter.
	public Aarstrinn (int indeks, String f, int t )
	{
		setFag( indeks, f ) ;
		setTimer( indeks, t ) ;
	}

	//Set metode for tilordning av ny verdi til de lokale array variabelene fag og timer
	//indeks viser til posisjon i arrayet og f er verdien som skal skrives inn
	public void setTimer(int i, int t)
	{
		timer[i] = t;
	}
	/*public void setTimer ( int i, int t )
	{
		JOptionPane.showMessageDialog(null, i + ", " + t,
			"Fra setTimer funksjonen", JOptionPane.PLAIN_MESSAGE );
			//timer[indeks] = t;
	}*/
	public void setFag( int i, String f )
	{
		fag[i] = f;
	}

	/*public void setFag( int indeks, String f )
	{
		JOptionPane.showMessageDialog(null, fag[indeks],
			"Når instansen av fag gis en verdi", JOptionPane.PLAIN_MESSAGE );

		//fag[indeks] = f;
	}*/

	// Get metode for aa hente ut verdi i de lokale array variabelene fag og timer
	// indeksen viser til posisjonen i arrayet verdien skal hentes fra
	public int getTimer ( int indeks )
	{
		return timer[ indeks ];
	}

	public String getFag (int indeks )
	{
		return fag[indeks];
	}

}