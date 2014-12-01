/* Denne klassen samler tilgjengelige ressurser per faggruppe,
*  uavhengig av trinnfordeling. Klassen brukes i fordelinga.
*
*  Kodingen er utf�rt av Jenny Emelia Nikolaisen
*/

public class Fag
{
	private String fagNavn;
	private int laererIndeks;

	// Konstrukt�r

	public Fag()
	{
		fagNavn = "";
		laererIndeks = 0;
	}

	// Metoder

	public String getFagNavn() // Returnerer fagnavnet
	{
		return fagNavn;
	}

	public int getLaererIndeks() // Returnerer l�rerindeksen
	{
		return laererIndeks;
	}

	public void setFag(String f) // Setter fagnavn
	{
		fagNavn = f;
	}

	public void tilgjengeligLaerer(Laerer[]laerer)
	{
		/*
		Returnerer indeksen til l�rer med mest tilgjengelig tid
		og som har fordypningskompetanse i aktuelt fag.
		*/
		int flestTimer = 0;

		for (int i = 0 ; i < laerer.length ; i++) // G�r igjennom alle l�rerne
		{
			for (int j = 0; j < 3; j++)
			{
				if (laerer[i].getSpesialKompetanse(j).equals(fagNavn))
				{

					if (laerer[i].getTilgjengeligeTimer() > flestTimer)
					{
						flestTimer = laerer[i].getTilgjengeligeTimer();
						laererIndeks = i;
					}
				}
			}
		}

	}	// Slutt p� tilgjengeligLaerer

} // Slutt p� klassen Fag