/**************************************************************************
************************* Fordeling - formål ******************************
***************************************************************************

Klassen tar i bruk de ressurser og behov som er lest inn i klassene Fag,
Laerer og Aarstrinn og fordeler disse så godt det lar seg gjøre.

Deretter lagres resultatet i underklasser per trinn og fag for hvert trinn.
Dette resultatet kan så returneres til main med egne metoder.

Kodet av Andreas Neverdahl

/**************************************************************************
************************* Oppbygging av klassen ***************************
***************************************************************************

Fordeling					- Opprettes i main. Se formål.
.fordelLaerere()			- Kalles i main. Kjører ressursfordeling.
.ledigLaerer()				- Brukes av fordelLaerere().
.trinnplan()				- Kalles i main. Genererer oversikt for trinn.
.finnTrinnLaerere()			- Brukes av fordelLaerere().
	underklasse Trinn		- Opprettes av super for lagring av fordeling.
		underklasse Faginfo	- Samme som Trinn.
		.leggTilLaerer()	- Brukes av fordelLaerere(). Lagrer lærere.

***************************************************************************/

import java.util.ArrayList;
import javax.swing.JTextArea;

public class Fordeling
{
	// Datafelt
	private ArrayList<Trinn> trinn = new ArrayList<Trinn>();


	// Konstruktører

	public Fordeling(Fag[] fag, Aarstrinn[] aarstrinn, Laerer[] laerer)
	{
		for ( int i = 0 ; i < aarstrinn.length ; i++ )
		{
			trinn.add(new Trinn(aarstrinn[i], fag));
		}

	}

	// Metoder

	public void fordelLaerere(Fag[] fag, Aarstrinn[] aarstrinn, Laerer[] laerer)

	/*
	Metoden for selve fordelinga.

	Prioriterer lærere med fordypning innenfor hvert fag,
	men bruker lærere uten fordypning der det trengs.
	*/

	{
		for ( int i = 0 ; i < fag.length ; i++) // For hvert fag skolen tilbyr
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
					int aktLaerer = fag[i].getLaererIndeks(); // Setter denne laereren som foerstevalg
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

	public JTextArea trinnPlan(int i, Laerer[] laerer)
	/*
	Samme som forrige, men kun et trinn om gangen
	*/

	{
		JTextArea txt = new JTextArea();
		txt.setText("Oversikt over fag på trinn: " + this.trinn.get(i).navn +"\n");

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

	public JTextArea laererRessursEtterFordeling(Laerer[] laerer)
	{
		JTextArea txt =	new JTextArea();
		txt.setText("Gjennværende lærerressurser etter fordeling på fag:\n\n"+
					"Navn\tLedige timer\tSpesielle oppgaver\n");

		for (int i = 0 ; i < laerer.length ; i++ )
		{
			txt.append( laerer[i].getLaererNavn() + ":\t" + laerer[i].getTilgjengeligeTimer() + "\t");
			String spesOppg = "";
			for (int j = 0 ; j < 3 ; j++ )
			{
				if (!spesOppg.isEmpty() && !laerer[i].getSpesielleOppgaver(j).isEmpty())
					spesOppg += ", " + laerer[i].getSpesielleOppgaver(j);
				else
					spesOppg = laerer[i].getSpesielleOppgaver(j);
			}
			if (spesOppg.isEmpty())
				spesOppg = "Nei";
			txt.append(spesOppg + "\n");
		}

		return txt;
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
			navn = aarstrinn.getTrinn();
			for ( int i = 0 ; i < fag.length ; i++ )
			{
				faginfo.add(new FagInfo( i, aarstrinn, fag[i]));
			}
		}

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
				navn = fag.getFagNavn();
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