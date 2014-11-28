/* Denne klassen samler tilgjengelige ressurser per faggruppe, uavhengig av trinnfordeling. Klassen brukes i fordelinga.
* Kodingen er utf�rt av Jenny Emelia Nikolaisen
* Dette er versjon nr. 6 (25.11.14)
*/

public class FagJennyskluss
{
	private String fagNavn;
	private int laererIndeks;

	//konstrukt�r
	public Fag()
	{
		fagNavn = "";
		laererIndeks = 0;
	}

	//Konstrukt�r
	public Fag(String f, int l)
	{
		fagNavn = f;
		//Rune: Bruker denne for midlertidig testing
		laererIndeks = l;
		//Dette er den endelige
		//laererIndeks = metode_som_finner_indeksen_til(f);//??
	}

	public void setFag(String f)
	{
		fagNavn = f;
		//laererIndeks = metode_som_finner_indeksen_til(f);//???
	}

	public String getfagNavn() // lager en get-metode som returnerer faget
	{
		return fagNavn;
	}

	public int getlaererIndeks() // lager en get-metode som returnerer l�rerindeksen
	{
		return laererIndeks;
	}

		public void tilgjengeligLaerer() // Returnerer indeks til mest tilgjengelige l�rer. Public fordi Andreas skal ha tilgang.
										 // Nei, n� returnerer den ikke en skit.... Hva gj�r den s�? "Bare" gjennomg�r l�rerne s�
										 // Andreas skal se hvilken l�rer som har flest ledige timer til enhver tid?
		{
			int lIndeks = 0;
			int flestTimer = 0;

			for (int i = 0 ; i < laererNavn.length ; i++) // G�r igjennom alle l�rerne
			{
				if (laererNavn[i].spesialKompetanse == fagNavn)
				{

					if (laererNavn[i].tilgjengeligeTimer > flestTimer)
					{
						flestTimer = laererNavn[i].tilgjengeligeTimer;
						lIndeks = i;
					}
				}
			}

		}	// Slutt p� tilgjengeligLaerer

} // Slutt p� klassen Fag