import masse.viktige.ting

public class Fordeling
{
	/*
	OBS: Innhenter data fra andre objekter som om alle datafelter er public.
	Dette er selvsagt midlertidig. De kan enten byttes med get-/set-metoder eller få andre navn
	etterhvert som de andre klassene kommer på plass.
	*/

	public Fordeling(Fag[] fag, Årstrinn[] årstrinn, Lærer[] lærer)
	{
		/*
		Opprette instanser av visualiseringsklassene ihht. antall fag, årstrinn og lærere.
		*/
	}

	// Selve fordelinga
	public void fordelLærere()
	{
		this.fordelLærere(Fag[], Årstrinn[], Lærer[]);
	}

	public void fordelLærere(Fag[] fag, Årstrinn[] årstrinn, Lærer[] lærer)
	{
		/*
		TODO: < Sorter Fag-objekt >
		Enda ikke sikker. Skal kjernefag alltid komme først, så resten etter tilgjengelige fordypningstimer?
		*/

		for ( int i = 0 ; i < fag.length ; i++) // For hvert enkelt fag skolen tilbyr
		{
			int timerBundet = 0;	// Hvor mange timer som er bundet til nå
			for ( int j = 0 ; j < årstrinn.length ; j++ ) // For hvert årstrinn på skolen
			{
				while ( årstrinn[j].behov[i] > timerBundet ) // Faget [i] må samsvare med indeksen i Fag
				{
					int aktLærer = fag[i].tilgjengelig[0]; // Setter fordypningslærer som førstevalg

					if ( lærer[aktLærer].timer > 0 ) // Dersom aktuell lærer har fordypningstimer igjen
					{
						if ( lærer[aktLærer].timer > årstrinn[j].behov[i] )
						{
							timerBundet = årstrinn[j].behov[i];
							/*
							TODO:
							Bind all tid hos lærer
							Registrer lærer i skoleplan
							*/
						}
						else
						{
							timerBundet += lærer[aktLærer].timer;
							/*
							TODO:
							Bind resterende tid hos lærer
							Registrer lærer i skoleplan
							Oppdater/sorter Fag[i].tilgjengelig
							*/
						}
					}
					else // Ikke mer fordypningstimer igjen. Bruker annen lærer
					{
						aktLærer = ledigLærer(lærer);

						if ( lærer[aktLærer].timer > årstrinn[j].behov[i] )
							{
							timerBundet = Årstrinn[j].behov[i];
							/*
							TODO:
							Bind all tid hos lærer
							Registrer lærer i skoleplan
							*/
						}
						else
						{
							timerBundet += Lærer[aktLærer].timer;
							/*
							TODO:
							Bind resterende tid hos lærer
							Registrer lærer i skoleplan
							*/
					}

				}	// Fordeling Årstrinn[j]-løkke

			}	// Årstrinn[]-løkke

		}	// Fag[]-løkke

	}	// fordelLærere()

	private int ledigLærer(Lærer[] lærer)
	{
		/*
		Returnerer indeks til lærer i angitt array med flest ledige timer
		*/

		int ledigIndeks = 0;
		int flestTimer = 0
		for (int i ; i < lærer.length ; i++)
		{
			if lærer[i].timer > flestTimer
			{
				flestTimer = lærer[i].timer;
				ledigIndeks = i;
			}
		}

		return ledigIndeks;

	}	// ledigLærer

	public class skoleplan
	{
		/*
		For lagring av fordeling og visualisering/printing av resultat/planer

		Ikke gjort så mye tanker rundt lagring av resultatene enda, så denne er såvidt påbegynt.
		*/

		// Datafelt

		// Konstruktør
		public skoleplan( Årstrinn[] årstrinn, Fag[] fag, Lærer[] lærer )
		{
			trinn[] trinn = new trinn[årstrinn.length];
			for ( int i = 0 ; i < trinn.length ; i++ )
			{
				trinn[i] = new trinn(årstrinn[i], fag, lærer);
			}
		}

		// Metoder
		/*
		Trinnplan - oversikt over fag og antall timer pr. fag
		Fagplan, pr. trinn - oversikt over antall timer pr. lærer pr. fag
		*/

		public class trinn
		{
			// Datafelt
			private String navn; // 1. klasse/1/Vg1 e.l.

			// Konstruktør
			public trinn( Årstrinn årstrinn, Fag[] fag )
			{
				faginfo[] faginfo = new faginfo[fag.length];
				for ( int i = 0 ; i < faginfo.length ; i++ )
					faginfo[i] = new faginfo( fag[i] );
			}

			// Metoder


			public class faginfo
			{
				// Datafelt
				private String navn;
				private int[] lærerIndeks;
				private int[] lærerTimer;

				// Konstruktør
				faginfo( Fag fag )
					navn = fag.navn;

				// Metoder


			} // class fag

		} // class trinn

	} // class skoleplan

}