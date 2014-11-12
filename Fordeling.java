import masse.viktige.ting

public class Fordeling
{
	/*
	OBS: Innhenter data fra andre objekter som om alle datafelter er public.
	Dette er selvsagt midlertidig. De kan enten byttes med get-/set-metoder eller f� andre navn
	etterhvert som de andre klassene kommer p� plass.
	*/

	public Fordeling(Fag[] fag, �rstrinn[] �rstrinn, L�rer[] l�rer)
	{
		/*
		Opprette instanser av visualiseringsklassene ihht. antall fag, �rstrinn og l�rere.
		*/
	}

	// Selve fordelinga
	public void fordelL�rere()
	{
		this.fordelL�rere(Fag[], �rstrinn[], L�rer[]);
	}

	public void fordelL�rere(Fag[] fag, �rstrinn[] �rstrinn, L�rer[] l�rer)
	{
		/*
		TODO: < Sorter Fag-objekt >
		Enda ikke sikker. Skal kjernefag alltid komme f�rst, s� resten etter tilgjengelige fordypningstimer?
		*/

		for ( int i = 0 ; i < fag.length ; i++) // For hvert enkelt fag skolen tilbyr
		{
			int timerBundet = 0;	// Hvor mange timer som er bundet til n�
			for ( int j = 0 ; j < �rstrinn.length ; j++ ) // For hvert �rstrinn p� skolen
			{
				while ( �rstrinn[j].behov[i] > timerBundet ) // Faget [i] m� samsvare med indeksen i Fag
				{
					int aktL�rer = fag[i].tilgjengelig[0]; // Setter fordypningsl�rer som f�rstevalg

					if ( l�rer[aktL�rer].timer > 0 ) // Dersom aktuell l�rer har fordypningstimer igjen
					{
						if ( l�rer[aktL�rer].timer > �rstrinn[j].behov[i] )
						{
							timerBundet = �rstrinn[j].behov[i];
							/*
							TODO:
							Bind all tid hos l�rer
							Registrer l�rer i skoleplan
							*/
						}
						else
						{
							timerBundet += l�rer[aktL�rer].timer;
							/*
							TODO:
							Bind resterende tid hos l�rer
							Registrer l�rer i skoleplan
							Oppdater/sorter Fag[i].tilgjengelig
							*/
						}
					}
					else // Ikke mer fordypningstimer igjen. Bruker annen l�rer
					{
						aktL�rer = ledigL�rer(l�rer);

						if ( l�rer[aktL�rer].timer > �rstrinn[j].behov[i] )
							{
							timerBundet = �rstrinn[j].behov[i];
							/*
							TODO:
							Bind all tid hos l�rer
							Registrer l�rer i skoleplan
							*/
						}
						else
						{
							timerBundet += L�rer[aktL�rer].timer;
							/*
							TODO:
							Bind resterende tid hos l�rer
							Registrer l�rer i skoleplan
							*/
					}

				}	// Fordeling �rstrinn[j]-l�kke

			}	// �rstrinn[]-l�kke

		}	// Fag[]-l�kke

	}	// fordelL�rere()

	private int ledigL�rer(L�rer[] l�rer)
	{
		/*
		Returnerer indeks til l�rer i angitt array med flest ledige timer
		*/

		int ledigIndeks = 0;
		int flestTimer = 0
		for (int i ; i < l�rer.length ; i++)
		{
			if l�rer[i].timer > flestTimer
			{
				flestTimer = l�rer[i].timer;
				ledigIndeks = i;
			}
		}

		return ledigIndeks;

	}	// ledigL�rer

	public class skoleplan
	{
		/*
		For lagring av fordeling og visualisering/printing av resultat/planer

		Ikke gjort s� mye tanker rundt lagring av resultatene enda, s� denne er s�vidt p�begynt.
		*/

		// Datafelt

		// Konstrukt�r
		public skoleplan( �rstrinn[] �rstrinn, Fag[] fag, L�rer[] l�rer )
		{
			trinn[] trinn = new trinn[�rstrinn.length];
			for ( int i = 0 ; i < trinn.length ; i++ )
			{
				trinn[i] = new trinn(�rstrinn[i], fag, l�rer);
			}
		}

		// Metoder
		/*
		Trinnplan - oversikt over fag og antall timer pr. fag
		Fagplan, pr. trinn - oversikt over antall timer pr. l�rer pr. fag
		*/

		public class trinn
		{
			// Datafelt
			private String navn; // 1. klasse/1/Vg1 e.l.

			// Konstrukt�r
			public trinn( �rstrinn �rstrinn, Fag[] fag )
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
				private int[] l�rerIndeks;
				private int[] l�rerTimer;

				// Konstrukt�r
				faginfo( Fag fag )
					navn = fag.navn;

				// Metoder


			} // class fag

		} // class trinn

	} // class skoleplan

}