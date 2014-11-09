/***** Oppgave Ressursfordeling ********
* Hovedklasse
* Programmet skal ta i bruk to datasett,
* ett med skolens behov for timefordeling pr. fag pr. �rstrinn og
* ett med tilgjengelige ressurser
* (dvs. tilgjengelige l�rere med ulik arbeidstid og kompetanse).
* Ressursene lagres i klassene L�rer, �rstrinn og Fag, for � bli hentet inn
* i klassen Fordeling som leser inn skolens behov og fordeler ressursene i
* henhold til disse. Resultatet av fordelinga skal s� lagres og visualiseres
* i klassen Fordeling.

< Opprette array av klassene �rstrinn-, fag - og l�rer  >
< Lese fra fil for � definere array st�rrelser og hente data til hvert objekts datafelter.
	Mulig utvidelse: Lage bruker-input >

< Fordele timer og ressurser. Gj�res i/av klassen Fordeling >
	< Opprette Fordelings-objekt og utf�re n�dvendige kall p� dets metoder >

< Gj�re kall p� Fordelings-objektets metoder for � skrive oversikter til fil/dialogboks >

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
		String �rsTrinnFilen = "aarstrinnRessurs.txt";
		String l�rerFilen = "l�rerRessurs.txt";
		String fagFilen = "fagRessurs.txt";
		Filbehandling fil = new Filbehandling();

		//M� finne st�rrelser til � dimmensjonere arrayene med
		// Alt 1: Lese �rsTrinnFilen for � finneut hvor mange rader og kolonner filen best�r av.
		int[] �rsTrinnRoK = fil.antRogK( �rsTrinnFilen ); //finner ant rader og (maks) antall kolonner i fila
		// Alt 2: Finne antall linjer (rader) i fila
		//int ant�rsTrinn = fil.antLinjer( �rsTrinnFilen );

		// Lager et array objekt av klassen �rstrinn
		�rstrinn[] trinn = new �rstrinn[�rsTrinnRoK[0]];
		trinn = fil.les�rsTrinnRessurs(�rsTrinnFilen, trinn);
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
		//int antL�rere = antLinjer( l�rerFil );*/

		/*Lager arrayene i riktig st�rrelse
		�rstrinn[] trinn;
		Fag[] fag = new Fag[antFag];
		L�rer[] l�rere = new L�rer[antL�rere];*/

	}
}