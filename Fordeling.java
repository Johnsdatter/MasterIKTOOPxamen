/*
Til main:
Fordeling skoleplan = new Fordeling(fagRessurs, trinnRessurs, laererRessurs);
skoleplan.fordelLaerere(fagRessurs, trinnRessurs, laererRessurs);
JOptionPane.showMessageDialog(null, skoleplan.trinnPlan(laererRessurs), "Fordeling", JOptionPane.PLAIN_MESSAGE );
*/

/*
Klassen fordeling
.fordelLaerere
.ledigLaerer
.trinnPlan
	underklasse Trinn
		underklasse Faginfo
*/

import java.util.ArrayList;

public class Fordeling
{
	// Datafelt
	private ArrayList<Trinn> trinn = new ArrayList<Trinn>();


	// Konstruktører

	public Fordeling(Fag[] fag, Aarstrinn[] aarstrinn, Laerer[] laerer)
	{
		/*
		Opprette instanser av visualiseringsklassene ihht. antall fag, aarstrinn og laerere.
		*/

		for ( int i = 0 ; i < aarstrinn.length ; i++ )
		{
			trinn.add(new Trinn(aarstrinn[i], fag));
		}

	}

	// Metoder

	public void fordelLaerere(Fag[] fag, Aarstrinn[] aarstrinn, Laerer[] laerer)

	/*
	Metoden for selve fordelinga.

	Prioriterer lærere med fordypning innenfor hvert fag, men bruker lærere uten fordypning der det trengs.
	*/

	{
		for ( int i = 0 ; i < fag.length ; i++) // For hvert enkelt fag skolen tilbyr
		{
			boolean ledigFordypning = true;
			for ( int j = 0 ; j < aarstrinn.length ; j++ ) // For hvert aarstrinn paa skolen
			{
				int timerBundet = 0;	// Hvor mange timer som er bundet til faget
				int behov = aarstrinn[j].getTimer(i);

				while ( behov > timerBundet ) // Faget [i] maa samsvare med indeksen i Fag
				{
					if (ledigFordypning)
						fag[i].tilgjengeligLaerer(laerer); // Finner lærer med flest ledige fordypningstimer
					int aktLaerer = fag[i].getlaererIndeks(); // Setter denne laereren som foerstevalg
					int timerBundetLaerer = 0;
					int tilgjengeligeTimer = laerer[aktLaerer].getTilgjengeligeTimer();

					if ( tilgjengeligeTimer > 0 ) // Dersom aktuell laerer har fordypningstimer igjen
					{
						if ( tilgjengeligeTimer > behov )
						{
							timerBundetLaerer = behov;
							timerBundet = timerBundetLaerer;
						}
						else
						{
							timerBundetLaerer = tilgjengeligeTimer;
							timerBundet += timerBundetLaerer;
						}
					}
					else // Ikke mer fordypningstimer igjen. Bruker annen laerer
					{
						ledigFordypning = false;
						aktLaerer = ledigLaerer(laerer);
						tilgjengeligeTimer = laerer[aktLaerer].getTilgjengeligeTimer();

						if ( tilgjengeligeTimer > behov )
						{
							timerBundetLaerer = behov;
							timerBundet = timerBundetLaerer;
						}
						else
						{
							timerBundetLaerer = tilgjengeligeTimer;
							timerBundet += timerBundetLaerer;
						}
					}
					laerer[aktLaerer].setTilgjengeligeTimer(timerBundetLaerer); // Trekker bundet tid fra potten til gjeldende laerer
					// Registrerer laerer og antall timer
					this.trinn.get(j).faginfo.get(i).leggTilLaerer(aktLaerer, timerBundetLaerer);


				}	// Fordeling Aarstrinn[j]-loekke

			}	// Aarstrinn[]-loekke

		}	// Fag[]-loekke

		this.finnTrinnLaerere();

	}	// fordelLaerere()

	private int ledigLaerer(Laerer[] laerer)
	{
		/*
		Returnerer indeks til laerer i angitt array med flest ledige timer
		*/

		int ledigIndeks = 0;
		int flestTimer = 0;
		for (int i = 0; i < laerer.length ; i++)
		{
			if (laerer[i].getTilgjengeligeTimer() > flestTimer)
			{
				flestTimer = laerer[i].getTilgjengeligeTimer();
				ledigIndeks = i;
			}
		}

		return ledigIndeks;

	}	// ledigLaerer()

	public String trinnPlan(Laerer[] laerer)
	/*
	Returnerer streng med oversikt over antall undervisningstimer for
	hver laerer for hvert fag paa hvert trinn
	*/

	{
		String s = "";

		for (int i = 0 ; i < this.trinn.size() ; i++)
		{
			s += this.trinnPlan(i, laerer) + "\n\n";
		}

		return s;
	}

	public String trinnPlan(int i, Laerer[] laerer)
	/*
	Samme som forrige, men kun et trinn om gangen
	*/

	{
		String s = "Oversikt over fag paa trinn: " + /*this.trinn.get(i).navn + */i +"\n";

		for (int j = 0 ; j < this.trinn.get(i).faginfo.size() ; j++)
		{
			if (this.trinn.get(i).faginfo.get(j).behov > 0)
			{
				s += "\n" + this.trinn.get(i).faginfo.get(j).navn + ": ";

				for (int k = 0 ; k < this.trinn.get(i).faginfo.get(j).laererIndeks.size() ; k++)
				{
					s += laerer[trinn.get(i).faginfo.get(j).laererIndeks.get(k)].getLaererNavn() +
						":" + this.trinn.get(i).faginfo.get(j).laererTimer.get(k) + "; ";
				}
			}
		}

		return s;
	}

	public void finnTrinnLaerere()
	{
		for ( int i = 0 ; i < this.trinn.size() ; i++ )
		{
			this.trinn.get(i).laererIndeks.clear();

			for ( int j = 0 ; j < this.trinn.get(i).faginfo.size() ; j++ )
			{
				for ( int k = 0 ; k < this.trinn.get(i).faginfo.get(j).laererIndeks.size() ; k++ )
				{
					if (!this.trinn.get(i).laererIndeks.contains(this.trinn.get(i).faginfo.get(j).laererIndeks.get(k)))
						this.trinn.get(i).laererIndeks.add(this.trinn.get(i).faginfo.get(j).laererIndeks.get(k));
				}
			}
		}
	}

	// Underklasser

	public class Trinn
	{
		// Datafelt
		private String navn; // 1. klasse/1/Vg1 e.l.
		private ArrayList<Integer> laererIndeks = new ArrayList<Integer>();
		private ArrayList<FagInfo> faginfo = new ArrayList<FagInfo>();

		// Konstruktoer

		public Trinn( Aarstrinn aarstrinn, Fag[] fag )
		{
			navn = ""; // aarstrinn.navn; OBS: Venter på implementasjon.
			for ( int i = 0 ; i < fag.length ; i++ )
			{
				faginfo.add(new FagInfo( i, aarstrinn, fag[i]));
			}
		}

		// Metoder

		// Underklasser

		public class FagInfo
		{
			// Datafelt
			private String navn;
			private int behov;
			private ArrayList<Integer> laererIndeks = new ArrayList<Integer>();
			private ArrayList<Integer> laererTimer = new ArrayList<Integer>();

			// Konstruktoer
			public FagInfo( int fagIndeks, Aarstrinn aarstrinn, Fag fag )
			{
				navn = fag.getfagNavn();
				behov = aarstrinn.getTimer(fagIndeks);
			}

			// Metoder
			public void leggTilLaerer(int indeks, int timer)
			{
				laererIndeks.add(indeks);
				laererTimer.add(timer);
			}


		} // class fag

	} // class trinn

}