/***** Oppgave Ressursfordeling ********
* Hovedklasse
* Programmet skal ta i bruk to datasett,
* ett med skolens behov for timefordeling pr. fag pr. aarstrinn og
* ett med tilgjengelige ressurser
* (dvs. tilgjengelige laerere med ulik arbeidstid og kompetanse).
* Ressursene lagres i klassene Laerer, Aarstrinn og Fag, for å bli hentet inn
* i klassen Fordeling som leser inn skolens behov og fordeler ressursene i
* henhold til disse. Resultatet av fordelinga skal så lagres og visualiseres
* i klassen Fordeling.

< Opprette array av klassene Aarstrinn-, Fag - og Laerer  >
< Lese fra fil for å definere array stoerrelser og hente data til hvert objekts datafelter.
	Mulig utvidelse: Lage bruker-input >

< Fordele timer og ressurser. Gjoeres i/av klassen Fordeling >
	< Opprette Fordelings-objekt og utføre nødvendige kall på dets metoder >

< Gjoere kall på Fordelings-objektets metoder for å skrive oversikter til fil/dialogboks >

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

		// For aa faa tilgang til metodene i klassen Filbehandling
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
		int antLaerer = fil.antLinjer( laererFilen );

		//lager array-objekter av ressursklassene
		Aarstrinn[] trinnRessurs = new Aarstrinn[ antAarstrinn ];
		Fag[] fagRessurs = new Fag[ antFag ];
		Laerer[] laererRessurs = new Laerer[ antLaerer ];

		//**** Fyller objektene med informasjonen i datafilene
		trinnRessurs = fil.lesAarstrinnRessurs( aarstrinnFilen, trinnRessurs );
		fagRessurs = fil.lesFagRessurs( fagFilen, fagRessurs );
		laererRessurs = fil.lesLaererRessurs( laererFilen, laererRessurs );
		
		//******************************************************************************************
		//***************** TEST AV set og get metoder i klassene Aarstrinn, Fag og Laerer *********
		//******************************************************************************************
		String s = "";

		// ****** Test løkke for å lese ut trinnRessurs registrereinger
		for( int x = 0; x < 4; x++)
		{
			for ( int y = 0; y < 5; y++ )
			{
				s += trinnRessurs[x].getFag(y) + ", " + trinnRessurs[x].getTimer(y) + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, s, "", JOptionPane.PLAIN_MESSAGE );

		// ****** Test løkke for å lese ut fagRessurs registrereinger
		s = "";
		for( int x = 0; x < antFag; x++)
		{
				s += fagRessurs[x].getfagNavn() + "\n";
		}
		JOptionPane.showMessageDialog(null, s, "", JOptionPane.PLAIN_MESSAGE );

		// ****** Test løkke for å lese ut laererRessurs registrereinger
		s = "";
		for( int x = 0; x < antLaerer; x++)
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
			JOptionPane.showMessageDialog(null, s, "Ressursbehandling", JOptionPane.PLAIN_MESSAGE );
		}
		
		//****** Sjekker om set metoden for tilgjengeligeTimer i Laerer klassen fungerer
		laererRessurs[2].setTilgjengeligeTimer( 3 );
		s = "" + laererRessurs[2].getTilgjengeligeTimer();
		JOptionPane.showMessageDialog(null, "opprinnelige timetall er 21. Nå (-3): " + s, "Ressursbehandling", JOptionPane.PLAIN_MESSAGE );

	}

}
