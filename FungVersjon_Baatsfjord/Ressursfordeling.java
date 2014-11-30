/**********************************************************************************
* Oppgave2: Ressursfordeling
* *********************************************************************************
* Programmerer: Rune Even Holmdal
* Dato: 30.11.2014
* *********************************************************************************
*
*************************** Hovedklasse *******************************************
* Programmet leser datafiler for skolens undervisningstilbud (ressursbehovet) og
* hvilke ressurser som er tilgjengelige (ressurstilgangen). Dataene lagres i tre
* array objekter basert på klasser, henholdsvis klassene Aarstrinn, Laerer og Fag.
*
* Klassen Fordeling fordeler ressurstilgangen i forhold til ressursbehovet.
* Resultatet av fordelinga blir visualiseres og lagret til fil.
*
* Alle datafiler (input og output) er på csv-formatet.
*
***********************************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Ressursfordeling
{
	public static void main( String[] args )
	{
		int maksoppfoeringer = 25; //Samme som i klassen Aarstrinn
		String aarstrinnFilen = "aarstrinnRessurs.csv";
		String laererFilen = "laererRessurs.csv";
		String fagFilen = "fagRessurs.csv";

		// For å få tilgang til metodene i klassen Filbehandling
		Filbehandling fil = new Filbehandling();

		// Dimmensjonere arrayene av ressursklassene,
		// ved å lese antall linjer i datafilene.
		int antAarstrinn = fil.antLinjer( aarstrinnFilen );
		int antFag = fil.antLinjer( fagFilen );
		int antLaerer = fil.antLinjer( laererFilen );

		// lager array-objekter av ressursklassene
		Aarstrinn[] trinnRessurs = new Aarstrinn[ antAarstrinn ];
		Fag[] fagRessurs = new Fag[ antFag ];
		Laerer[] laererRessurs = new Laerer[ antLaerer ];

		// Fyller objektene med informasjonen i datafilene
		trinnRessurs = fil.lesAarstrinnRessurs( aarstrinnFilen, trinnRessurs );
		fagRessurs = fil.lesFagRessurs( fagFilen, fagRessurs );
		laererRessurs = fil.lesLaererRessurs( laererFilen, laererRessurs );

/* test: skriver ut innhold i objektene trinnRessurs, fagRessurs og laererRessurs
		String s = "";
		// ****** Test løkke for å lese ut trinnRessurs registrereinger
		for( int x = 0; x < antAarstrinn; x++)
		{
			s += trinnRessurs[x].getTrinn() + ". klasse \n";
			for ( int y = 0; y < 11; y++ )
			{
					s += trinnRessurs[x].getFag(y) + ", " + trinnRessurs[x].getTimer(y) + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, s, "Årstrinn", JOptionPane.PLAIN_MESSAGE );
		s = "";
		// ****** Test løkke for å lese ut fagRessurs registrereinger
		for( int x = 0; x < antFag; x++)
		{
				s += fagRessurs[x].getFagNavn() + "\n";
		}
		JOptionPane.showMessageDialog(null, s, "Fag", JOptionPane.PLAIN_MESSAGE );

		// ****** Test løkke for å lese ut laererRessurs registrereinger
		s = "";
		for( int x = 0; x < antLaerer; x++) //
		{
			s = laererRessurs[x].getLaererNavn() + "\n" +
				laererRessurs[x].getSpesialKompetanse(0) + "\n" +
				laererRessurs[x].getSpesialKompetanse(1) + "\n" +
				laererRessurs[x].getSpesialKompetanse(2) + "\n" +
				laererRessurs[x].getSpesielleOppgaver(0) + "\n" +
				laererRessurs[x].getSpesielleOppgaver(1) + "\n" +
				laererRessurs[x].getSpesielleOppgaver(2) + "\n" +
				laererRessurs[x].getSpesielleTimer() + "\n" +
				laererRessurs[x].getStillingsProsent() + "\n" +
				laererRessurs[x].getTilgjengeligeTimer();
			JOptionPane.showMessageDialog(null, s, "Lærer", JOptionPane.PLAIN_MESSAGE );
		}
		laererRessurs[2].setTilgjengeligeTimer( 3 );
		s = "" + laererRessurs[2].getTilgjengeligeTimer();
		JOptionPane.showMessageDialog(null, "Endring av timetall:\n Opprinnelige timetall er 21 og reduseres med 3:\n Gjeldende timetall er: " + s, "Lærer", JOptionPane.PLAIN_MESSAGE );
//********************************** TEST SLUTT ***********************************************
*/
		// Fordeler ressurstilgangen etter ressursbehovet
		Fordeling skoleplan = new Fordeling(fagRessurs, trinnRessurs, laererRessurs);
		skoleplan.fordelLaerere(fagRessurs, trinnRessurs, laererRessurs);

		// Skriver resultatet ut på skjermen.
		JOptionPane.showMessageDialog(null, skoleplan.laererRessursEtterFordeling(laererRessurs),
			"Fordeling", JOptionPane.PLAIN_MESSAGE );
	}
}
