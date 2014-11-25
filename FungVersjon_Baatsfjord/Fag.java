/* Denne klassen samler tilgjengelige ressurser per faggruppe, uavhengig av trinnfordeling. Klassen brukes i fordelinga.
* Kodingen er utført av Jenny Emelia Nikolaisen
* Dette er versjon nr. 6 (25.11.14)
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
	/* må kommentere ut denne så lenge siden objektet laerer ikke er opprettet ennå */

	public String getLaerere() // lager en get-metode som returnerer lærere
	{
		return laerere;
	}

	public int getlaererIndeks() // lager en get-metode som returnerer lærerindeksen
	{
		return laererIndeks;
	}


/* Måte kommentere den ut da den gir kompileringsfeil på laerer[i].fordypning som ikke eksisterer.
   Antar at den refererer til arrayet spesialKompetanse[n] i Laerer
   Dermed må den omskrives litt*/

		public void tilgjengeligLaerer() // Returnerer indeks til mest tilgjengelige lærer. Public fordi Andreas skal ha tilgang.
		{
			int laererIndeks = 0;
			int flestTimer = 0;

			for (int i = 0 ; i < laerer.length ; i++) // Går igjennom alle lærerne
			{
				if (laerer[i].spesialKompetanse == fagNavn) // muligens endres, se Trudes koding for eksakte navn
				{

					if (laerer[i].timer > flestTimer)
					{
						flestTimer = laerer[i].timer;
						laererIndeks = i;
					}
				}
			}

		}	// Slutt på tilgjengeligLaerer

	public int gettilgjengeligLaerer () // lager en get-metode som returnerer tilgjengelige lærere
	{
		return tilgjengeligLaerer;
	}

} // Slutt på klassen Fag