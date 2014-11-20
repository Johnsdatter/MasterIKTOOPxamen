/*
Klassen fordeling
.fordelLaerere
.ledigLaerer
	underklasse Skoleplan
 	.trinnPlan
	.fagPlan
		underklasse Trinn
			underklasse Faginfo
*/

public class Fordeling
{
	/*
	OBS: Innhenter data fra andre objekter som om alle datafelter er public.
	Dette er selvsagt midlertidig. De kan enten byttes med get-/set-metoder eller faa andre navn
	etterhvert som de andre klassene kommer paa plass.
	*/

	// Konstruktører

	public Fordeling(Fag[] fag, Aarstrinn[] aarstrinn, Laerer[] laerer)
	{
		/*
		Opprette instanser av visualiseringsklassene ihht. antall fag, aarstrinn og laerere.
		*/
		Skoleplan skoleplan = new skoleplan( Aarstrinn[] aarstrinn, Fag[] fag, Laerer[] laerer );

	}

	// Metoder

	public void fordelLaerere()
	/*
	Uten parametre, går ut fra standardnavn på variabler
	*/

	{
		this.fordelLaerere(Fag[], Aarstrinn[], Laerer[]);
	}

	public void fordelLaerere(Fag[] fag, Aarstrinn[] aarstrinn, Laerer[] laerer)
	/*
	Metoden for selve fordelinga.

	Prioriterer lærere med fordypning innenfor hvert fag, men bruker lærere uten fordypning der det trengs.
	*/

	{
		/*
		TODO: < Sorter Fag-objekt >
		Enda ikke sikker. Skal kjernefag alltid komme foerst, saa resten etter tilgjengelige fordypningstimer?
		*/

		for ( int i = 0 ; i < fag.length ; i++) // For hvert enkelt fag skolen tilbyr
		{
			int timerBundet = 0;	// Hvor mange timer som er bundet til faget
			boolean ledigFordypning = true;
			for ( int j = 0 ; j < aarstrinn.length ; j++ ) // For hvert aarstrinn paa skolen
			{
				while ( aarstrinn[j].behov[i] > timerBundet ) // Faget [i] maa samsvare med indeksen i Fag
				{
					if (ledigFordypning)
						fag[i].tilgjengeligLaerer(laerer); // Finner lærer med flest ledige fordypningstimer
					int aktLaerer = fag[i].tilgjengelig[0]; // Setter denne laereren som foerstevalg
					int timerBundetLaerer = 0;

					if ( laerer[aktLaerer].timer > 0 ) // Dersom aktuell laerer har fordypningstimer igjen
					{
						if ( laerer[aktLaerer].timer > aarstrinn[j].behov[i] )
						{
							timerBundetLaerer = aarstrinn[j].behov[i];
							timerBundet = timerBundetLaerer;
						}
						else
						{
							timerBundetLaerer = laerer[aktLaerer].timer;
							timerBundet += timerBundetLaerer
						}
					}
					else // Ikke mer fordypningstimer igjen. Bruker annen laerer
					{
						ledigFordypning = false;
						aktLaerer = ledigLaerer(laerer);

						if ( laerer[aktLaerer].timer > aarstrinn[j].behov[i] )
						{
							timerBundetLaerer = Aarstrinn[j].behov[i];
							timerBundet = timerBundetLaerer;
						}
						else
						{
							timerBundetLaerer = Laerer[aktLaerer].timer;
							timerBundet += timerBundetLaerer;
						}

					laerer[aktLaerer].timer -= timerBundetLaerer; // Trekker bundet tid fra potten til gjeldende laerer
					// Registrerer laerer og antall timer
					this.skoleplan.trinn[j].faginfo[i].leggTilLaerer(aktLaerer, timerBundetLaerer);

					}

				}	// Fordeling Aarstrinn[j]-loekke

			}	// Aarstrinn[]-loekke

		}	// Fag[]-loekke

	}	// fordelLaerere()

	private int ledigLaerer(Laerer[] laerer)
	{
		/*
		Returnerer indeks til laerer i angitt array med flest ledige timer
		*/

		int ledigIndeks = 0;
		int flestTimer = 0
		for (int i ; i < laerer.length ; i++)
		{
			if laerer[i].timer > flestTimer
			{
				flestTimer = laerer[i].timer;
				ledigIndeks = i;
			}
		}

		return ledigIndeks;

	}	// ledigLaerer

	public class Skoleplan
	{
		/*
		For lagring av fordeling og visualisering/printing av resultat/planer
		*/

		// Datafelt

		// Konstruktoer
		public skoleplan( Aarstrinn[] aarstrinn, Fag[] fag, Laerer[] laerer )
		{
			trinn[] trinn = new trinn[aarstrinn.length];
			for ( int i = 0 ; i < trinn.length ; i++ )
			{
				trinn[i] = new trinn(aarstrinn[i], fag, laerer);
			}
		}

		// Metoder

		public String trinnPlan()
		/*
		Returnerer streng med oversikt over antall undervisningstimer for
		hver laerer for hvert fag paa hvert trinn
		*/

		{
			String s = "";

			for (int i = 0 ; i < this.trinn.length ; i++)
			{
				s += this.trinnPlan(i) + "\n\n";
			}

			return s;
		}

		public String trinnPlan(int i)
		/*
		Samme som forrige, men kun et trinn om gangen
		*/

		{
			private String s = "Oversikt over fag paa trinn: " + this.trinn[i].navn + "\n\n";

			for (int j = 0 ; j < this.trinn[i].fagInfo ; j++)
			{
				if (this.trinn[i].FagInfo[j].behov > 0)
				{
					s += this.trinn[i].fag[j].navn + "\n";

					for (int k = 0 ; this.trinn[i].fag[j].laererIndeks.size() ; k++)
					{
						s += "--- " + Laerer[trinn[i].fag[j].laererIndeks.get(k)].navn +
							": " + this.trinn[i].fag[j].laererTimer.get(k) + " timer\n";
					}
				}
			}

			return s;
		}

		// Underklasser

		public class Trinn
		{
			// Datafelt
			private String navn; // 1. klasse/1/Vg1 e.l.
			private ArrayList<Integer> laererIndeks = ArrayList();

			// Konstruktoer
			public trinn( Aarstrinn aarstrinn, Fag[] fag )
			{
				navn = aarstrinn.navn;
				FagInfo[] FagInfo = new FagInfo[fag.length];
				for ( int i = 0 ; i < FagInfo.length ; i++ )
					FagInfo[i] = new FagInfo( fag[i] );
			}

			// Metoder

			// Underklasser

			public class FagInfo
			{
				// Datafelt
				private String navn;
				private int behov;
				private ArrayList<Integer> laererIndeks = new ArrayList();
				private ArrayList<Integer> laererTimer = new ArrayList();

				// Konstruktoer
				public FagInfo( Fag fag )
				{
					navn = fag.navn;
					behov = fag.behov;
				}

				// Metoder
				public void leggTilLærer(int indeks, int timer)
				{
					laererIndeks.add(indeks);
					laererTimer.add(timer);
				}


			} // class fag

		} // class trinn

	} // class skoleplan

}