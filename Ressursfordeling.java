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
		String årsTrinnFilen = "aarstrinnRessurs.txt";
		String lærerFilen = "lærerRessurs.txt";
		String fagFilen = "fagRessurs.txt";
		Filbehandling fil = new Filbehandling();

		//Må finne størrelser til å dimmensjonere arrayene med
		// Alt 1: Lese årsTrinnFilen for å finneut hvor mange rader og kolonner filen består av.
		int[] årsTrinnRoK = fil.antRogK( årsTrinnFilen ); //finner ant rader og (maks) antall kolonner i fila
		// Alt 2: Finne antall linjer (rader) i fila
		//int antÅrsTrinn = fil.antLinjer( årsTrinnFilen );

		// Lager et array objekt av klassen Årstrinn
		Årstrinn[] trinn = new Årstrinn[årsTrinnRoK[0]];
		trinn = fil.lesÅrsTrinnRessurs(årsTrinnFilen, trinn);
		/*String s = "";
		for( int x = 0; x < trinn.length; x++)
		{
			for ( int y = 0; y < 5; y++ )
			{
				s += trinn[x].getFag(y) + trinn[x].getTimer(y) + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, s, "", JOptionPane.PLAIN_MESSAGE );*/



		//int antFag = antLinjer( fagFil );
		//int antLærere = antLinjer( lærerFil );*/

		/*Lager arrayene i riktig størrelse
		Årstrinn[] trinn;
		Fag[] fag = new Fag[antFag];
		Lærer[] lærere = new Lærer[antLærere];*/

	}
}