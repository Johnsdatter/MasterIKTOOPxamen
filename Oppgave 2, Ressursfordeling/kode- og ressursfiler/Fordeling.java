/*********************************************************************
************************* Fordeling - form�l *************************
**********************************************************************

Klassen tar i bruk de ressurser og behov som er lest inn i klassene
Fag, Laerer og Aarstrinn og fordeler disse s� godt det lar seg gj�re.

Deretter lagres resultatet i underklasser per trinn og fag for hvert
trinn. Dette resultatet kan s� returneres til main med egne metoder.

Kodet av Andreas Neverdahl

/*********************************************************************
************************ Oppbygging av klassen ***********************
**********************************************************************

Fordeling					- Opprettes i main. Se form�l.
.fordelLaerere()			- Kalles i main. Kj�rer ressursfordeling.
.ledigLaerer()				- Brukes av fordelLaerere().
.trinnplan()				- Kalles i main. Genererer oversikt for
							  trinn.
.finnTrinnLaerere()			- Brukes av fordelLaerere().
	underklasse Trinn		- Opprettes av super for lagring av
							  fordeling.
		underklasse Faginfo	- Samme som Trinn.
		.leggTilLaerer()	- Brukes av fordelLaerere(). Lagrer l�rere.

*********************************************************************/

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Fordeling
{
	// Datafelt
	private int ressursFoerFordeling = 0;
	private int skoleBehov = 0;
	private ArrayList<Trinn> trinn = new ArrayList<Trinn>();


	// Konstrukt�rer

	public Fordeling(Fag[] fag, Aarstrinn[] aarstrinn, Laerer[] laerer)
	{
		for ( int i = 0 ; i < aarstrinn.length ; i++ )
		{
			trinn.add(new Trinn(aarstrinn[i], fag));

			for ( int j = 0 ; j < fag.length ; j++)
			{
				skoleBehov += aarstrinn[i].getTimer(j);
			}
		}

		for ( int i = 0 ; i < laerer.length ; i++ )
		{
			ressursFoerFordeling += laerer[i].getTilgjengeligeTimer();
		}
	}

	// Metoder

	public void fordelLaerere(
		Fag[] fag, Aarstrinn[] aarstrinn, Laerer[] laerer)

	/*
	Metoden for selve fordelinga.

	Prioriterer l�rere med fordypning innenfor hvert fag,
	men bruker l�rere uten fordypning der det trengs.
	*/

	{
		if (skoleBehov > ressursFoerFordeling)
		{
			JOptionPane.showMessageDialog(
				null,
				"Innlest timebehov er st�rre enn tilgjengelige " +
				"l�rerressurser!" +
				"\n\nTimebehov: " + skoleBehov +
				"\nTilgjengelig: " + ressursFoerFordeling +
				"\n\nProgrammet vil n� avslutte.",
				"Feil innverdier!", JOptionPane.ERROR_MESSAGE );
			System.exit(0);
		}
		else
		{
			// For hvert fag skolen tilbyr
			for ( int i = 0 ; i < fag.length ; i++)
			{
				boolean ledigFordypning = true;
				// For hvert innlest trinn
				for ( int j = 0 ; j < aarstrinn.length ; j++ )
				{
					// Hvor mange timer som er bundet til faget
					int timerBundet = 0;
					int behov = aarstrinn[j].getTimer(i);

					// Kj�rer fordeling til behovet til fag
					// i p� trinn j er m�tt
					while ( behov > timerBundet )
					{
						if (ledigFordypning)
							// Finner l�rer med flest ledige fordypningstimer
							fag[i].tilgjengeligLaerer(laerer);

						// Setter denne l�reren som f�rstevalg
						int aktLaerer = fag[i].getLaererIndeks();
						// Midlertidig verdi av bundet tid hos aktLaerer
						int timerBundetLaerer = 0;
						int tilgjengeligeTimer =
							laerer[aktLaerer].getTilgjengeligeTimer();

						// Dersom aktuell l�rer har fordypningstimer
						// igjen
						if ( tilgjengeligeTimer > 0 )
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
						else
						// Ikke mer fordypningstimer igjen.
						// Bruker annen laerer.
						{
							// Er false helt til neste fag skal fordeles.
							ledigFordypning = false;
							aktLaerer = ledigLaerer(laerer);
							tilgjengeligeTimer =
								laerer[aktLaerer].getTilgjengeligeTimer();

							if ( tilgjengeligeTimer > behov )
							{
								timerBundetLaerer = behov;
								timerBundet = timerBundetLaerer;
							}
							else
							{
								timerBundetLaerer =
									tilgjengeligeTimer;
								timerBundet += timerBundetLaerer;
							}
						}
						// Trekker bundet tid fra potten til gjeldende
						// laerer
						laerer[aktLaerer].setTilgjengeligeTimer(
							timerBundetLaerer);

						// Registrerer l�rer og antall timer i
						// resultatsobjektene
						this.trinn.get(j).faginfo.get(i).leggTilLaerer(
							aktLaerer, timerBundetLaerer);


					}	// Fordeling Aarstrinn[j]-loekke

				}	// Aarstrinn[]-loekke

			}	// Fag[]-loekke

			this.finnTrinnLaerere();
		}

	}	// fordelLaerere()

	private int ledigLaerer(Laerer[] laerer)
	{
		/*
		Returnerer indeks til l�rer i angitt array med flest ledige
		timer
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

	public JTextArea trinnPlan(Laerer[] laerer)
	{
		/*
		Returnerer et JTextArea-objekt med trinnvis oversikt over hvor
		mange timer hver l�rer har i hvert fag.
		*/

		JTextArea txt = new JTextArea();

		for (int i = 0 ; i < this.trinn.size() ; i++)
		{
			txt.append( "Oversikt over l�rertimer p� " +
				this.trinn.get(i).navn + ". trinn:\n" +
				"Fag\tL�rer\ttimer");

			for (int j = 0; j < this.trinn.get(i).faginfo.size(); j++)
			{
				// Sjekker at gjeldende fag er aktuelt p� trinnet
				if (this.trinn.get(i).faginfo.get(j).behov > 0)
				{
					txt.append( "\n" + this.trinn.get(i).faginfo.
						get(j).navn + ": \t");

					for (int k = 0; k < this.trinn.get(i).faginfo.
						get(j).laererIndeks.size(); k++)
					{
						// Hopper ned en linje med innrykk dersom flere
						// l�rere har samme fag
						if (k > 0)
							txt.append("\n\t" + laerer[trinn.get(i).
							faginfo.get(j).laererIndeks.get(k)].
							getLaererNavn() + "\t" +
							this.trinn.get(i).faginfo.get
							(j).laererTimer.get(k));
						else
							txt.append(laerer[trinn.get(i).faginfo.get
							(j).laererIndeks.get(k)].getLaererNavn() +
							"\t" + this.trinn.get(i).faginfo.get(j).
							laererTimer.get(k));
					}
				}
			}
			txt.append("\n\n");
		}

		return txt;
	}

	public JTextArea laererRessursEtterFordeling(Laerer[] laerer)
	{
		/*
		Returnerer et JTextArea-objekt med oversikt over gjenv�rende
		l�rerressurser.
		*/

		JTextArea txt =	new JTextArea();
		txt.setText(
			"Gjennv�rende l�rerressurser etter fordeling p� fag:\n\n"+
			"Navn\tLedige timer\tSpesielle oppgaver\n");
		int restLaererTimer = 0;

		for (int i = 0 ; i < laerer.length ; i++ )
		{
			restLaererTimer += laerer[i].getTilgjengeligeTimer();
			txt.append( laerer[i].getLaererNavn() + ":\t" + laerer[i].
				getTilgjengeligeTimer() + "\t");

			String spesOppg = "";
			for (int j = 0 ; j < 3 ; j++ )
			{
				if (!spesOppg.isEmpty() && !laerer[i].
					getSpesielleOppgaver(j).isEmpty())

					spesOppg += ", " + laerer[i].
						getSpesielleOppgaver(j);
				else
					spesOppg += laerer[i].getSpesielleOppgaver(j);
			}
			if (spesOppg.isEmpty())
				spesOppg = "Nei";
			txt.append(spesOppg + "\n");
		}
		txt.append(
			"\nTotalt antall timer tilgjengelig f�r fordeling:\t" +
			ressursFoerFordeling +
			"\nSkolens timebehov:\t\t" + skoleBehov +
			"\nResterende antall timer tilgjengelig:\t" +
			restLaererTimer);

		return txt;
	}

	public void finnTrinnLaerere()
	{
		/*
		Fyller arraylists med trinnl�rere ut fra l�rere i trinn.faginfo
		*/

		for ( int i = 0; i < this.trinn.size(); i++ )
		{
			this.trinn.get(i).laererIndeks.clear();

			for ( int j = 0; j < this.trinn.get(i).faginfo.size(); j++)
			{
				for ( int k = 0 ; k < this.trinn.get(i).faginfo.get(j).
					laererIndeks.size() ; k++ )
				{
					if (!this.trinn.get(i).laererIndeks.contains(
						this.trinn.get(i).faginfo.get(j).laererIndeks.
						get(k)))
						this.trinn.get(i).laererIndeks.add(
							this.trinn.get(i).faginfo.get(j).
							laererIndeks.get(k));
				}
			}
		}
	}

	// Underklasser

	public class Trinn
	{
		// Datafelt

		private String navn; // 1. klasse/1/Vg1 e.l.
		private ArrayList<Integer> laererIndeks =
			new	ArrayList<Integer>();
		private ArrayList<FagInfo> faginfo =
			new ArrayList<FagInfo>();

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
			private ArrayList<Integer> laererIndeks =
				new ArrayList<Integer>();
			private ArrayList<Integer> laererTimer =
				new ArrayList<Integer>();

			// Konstruktoer
			public FagInfo(
				int fagIndeks, Aarstrinn aarstrinn, Fag fag )
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