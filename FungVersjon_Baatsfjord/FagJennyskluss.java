/* Denne klassen samler tilgjengelige ressurser per faggruppe, uavhengig av trinnfordeling. Klassen brukes i fordelinga.
* Kodingen er utført av Jenny Emelia Nikolaisen
* Dette er versjon nr. 6 (25.11.14)
*/

public class FagJennyskluss
{
	private String fagNavn;
	private int laererIndeks;

	//konstruktør
	public Fag()
	{
		fagNavn = "";
		laererIndeks = 0;
	}

	//Konstruktør
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

	public int getlaererIndeks() // lager en get-metode som returnerer lærerindeksen
	{
		return laererIndeks;
	}

		public void tilgjengeligLaerer(Laerer[]laerer) // Returnerer indeks til mest tilgjengelige lærer. Public fordi Andreas skal ha tilgang.
										 // Nei, nå returnerer den ikke en skit.... Hva gjør den så? "Bare" gjennomgår lærerne så
										 // Andreas skal se hvilken lærer som har flest ledige timer til enhver tid?
		{
			int flestTimer = 0;

			for (int i = 0 ; i < laerer.length ; i++) // Går igjennom alle lærerne
			{
				for (int j = 0; j < 3; j++)
				{
					if (laerer[i].getspesialKompetanse(j)equals(fagNavn))
					{

						if (laerer[i].gettilgjengeligeTimer() > flestTimer)
						{
							flestTimer = laerer[i].gettilgjengeligeTimer();
							laererIndeks = i;
						}
					}
				}
			}

		}	// Slutt på tilgjengeligLaerer

} // Slutt på klassen Fag