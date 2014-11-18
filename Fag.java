/* Denne klassen samler tilgjengelige ressurser per faggruppe, uavhengig av trinnfordeling. Klassen brukes i fordelinga.
* Kodingen er utført av Jenny Emelia Nikolaisen
* Dette er versjon nr. 5 (17.11.14)
*/

public class Fag
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
		laererIndeks = metode_som_finner_indeksen_til(f);//??
	}

	public String setFag(String f)
	{
		fagNavn = f;
		laererIndeks = metode_som_finner_indeksen_til(f);//???
	}

	public String getfagNavn() // lager en get-metode som returnerer faget
	{
		return fag;
	}
	public String getLaerere() // lager en get-metode som returnerer lærere
	{
		return laerere;
	}

	public int tilgjengeligLaerer(Laerer[] laerer) // Returnerer indeks til mest tilgjengelige lærer. Public fordi Andreas skal ha tilgang.
		{
			int laererIndeks = 0;
			int flestTimer = 0

			for (int i = 0 ; i < laerer.length ; i++) // Går igjennom alle lærerne
			{
				if (laerer[i].fordypning == fagNavn) // muligens endres, se Trudes koding for eksakte navn
				{

					if (laerer[i].timer > flestTimer)
					{
						flestTimer = laerer[i].timer;
						laererIndeks = i;
					}

				}
			}

			return laererIndeks;

	}	// Slutt på tilgjengeligLaerer

} // Slutt på klassen Fag