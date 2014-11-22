/***** Oppgave Ressursfordeling ********
* Hovedklasse
* Programmet skal ta i bruk to datasett,
* ett med skolens behov for timefordeling pr. fag pr. årstrinn og
* ett med tilgjengelige ressurser
* (dvs. tilgjengelige lærere med ulik arbeidstid og kompetanse).
* Ressursene lagres i klassene Lærer, Årstrinn og Fag, for å bli hentet inn
* i klassen Fordeling som leser inn skolens behov og fordeler ressursene i
* henhold til disse. Resultatet av fordelinga skal så lagres og visualiseres
* i klassen Fordeling.

< Opprette array av klassene årstrinn-, fag - og lærer  >
< Lese fra fil for å definere array størrelser og hente data til hvert objekts datafelter.
	Mulig utvidelse: Lage bruker-input >

< Fordele timer og ressurser. Gjøres i/av klassen Fordeling >
	< Opprette Fordelings-objekt og utføre nødvendige kall på dets metoder >

< Gjøre kall på Fordelings-objektets metoder for å skrive oversikter til fil/dialogboks >

*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Ressursfordeling
{
	public static void main( String[] args )
	{
		String aarstrinnFilen = "aarstrinnRessurs.txt";
		String laererFilen = "lærerRessurs.txt";
		String fagFilen = "fagRessurs.txt";//filen inneholder alle fagkoder

		// For å få tilgang til metodene i klassen Filbehandling
		Filbehandling fil = new Filbehandling();

		//**** Leser filene for å dimmensjonere arrayene av ressursklassene.
		/* Klassen Filbehandlinginneholder to alternative metoder:
		 * antRogK( filnavn ) og antLinjer( filnavn ).
		 * Bruk av alt 1: int[] aarstrinnRoK = fil.antRogK( aarstrinnFilen );
		 * metoden finner antall rader og kolonner i fila (når data er skilt med et tegn,
		 * her ';' semikolon). csv-format: Comma/Character-Separated Values.
		 * og returnerer et int-array på formen [antall rader, antall kolonner].
		 * Bruk av alt 2: int antAarstrinn = fil.antLinjer( aarstrinnFilen );
		 * Metoden returnerer antall linjer i fila sin et helltall
		 */
		int antAarstrinn = fil.antLinjer( aarstrinnFilen );
		int antFag = fil.antLinjer( fagFilen );
		// iie: int antLaerer = fil.antLinjer( laererFilen );


		//lager array-objekter av ressursklassene
		Aarstrinn[] trinnRessurs = new Aarstrinn[antAarstrinn];
		Fag[] fagRessurs = new Fag[antFag];
		// Ikke Implementert Ennå = iie: Laerer[] laererRessurs = new Laerer[antallLærer];

		//**** Fyller objektene med informasjonen i datafilene
		trinnRessurs = fil.lesAarstrinnRessurs(aarstrinnFilen, trinnRessurs);
		fagRessurs = fil.lesFagRessurs(fagFilen, fagRessurs);

		//JOptionPane.showMessageDialog(null, test, "fra array",JOptionPane.PLAIN_MESSAGE );
		//JOptionPane.showMessageDialog(null, fil.melding(), "Konstruktør", JOptionPane.PLAIN_MESSAGE );

		String s = "";

		// ****** Test løkke for å lese ut trinnRessurs registrereinger
		/*
		for( int x = 0; x < 4; x++)
		{
			for ( int y = 0; y < 5; y++ )
			{
				//JOptionPane.showMessageDialog(null, "", "", JOptionPane.PLAIN_MESSAGE );
				s += trinnRessurs[x].getFag(y) + ", " + trinnRessurs[x].getTimer(y) + "\n";
			}
		}
		*/

		// ****** Test løkke for å lese ut fagRessurs registrereinger
		for( int x = 0; x < antFag; x++)
		{
				s += fagRessurs[x].getfagNavn() + "\n";
		}

		JOptionPane.showMessageDialog(null, s, "", JOptionPane.PLAIN_MESSAGE );



		//int antFag = antLinjer( fagFil );
		//int antLærere = antLinjer( lærerFil );*/

		/*Lager arrayene i riktig størrelse
		Årstrinn[] trinn;
		Fag[] fag = new Fag[antFag];
		Lærer[] lærere = new Lærer[antLærere];*/

	}
}