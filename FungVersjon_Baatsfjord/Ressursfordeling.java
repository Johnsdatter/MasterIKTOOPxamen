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
		int maksoppfoeringer = 25; //Samme som i klassen Aarstrinn
		String aarstrinnFilen = "aarstrinnRessurs.csv";
		String laererFilen = "lærerRessurs.csv";
		String fagFilen = "fagRessurs.csv";

		// For å få tilgang til metodene i klassen Filbehandling
		Filbehandling fil = new Filbehandling();

		//**** Leser filene for å dimmensjonere arrayene av ressursklassene.
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


		// ****** Test løkke for å lese ut trinnRessurs registrereinger
		for( int x = 0; x < antAarstrinn; x++)
		{
			String s = "";
			for ( int y = 0; y < 11; y++ )
			{
					s += trinnRessurs[x].getFag(y) + ", " + trinnRessurs[x].getTimer(y) + "\n";
			}
			JOptionPane.showMessageDialog(null, s, "Årstrinn", JOptionPane.PLAIN_MESSAGE );
		}

/*********************************************************************************************
*************                  TESTER INNHOLD I OBJEKTENE                      ***************
*************        trinnRessurs, fagRessurs og laererRessurs                 ***************
**********************************************************************************************/
		// ****** Test løkke for å lese ut fagRessurs registrereinger
		String s = "";
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

		Fordeling skoleplan = new Fordeling(fagRessurs, trinnRessurs, laererRessurs);
		skoleplan.fordelLaerere(fagRessurs, trinnRessurs, laererRessurs);
		JOptionPane.showMessageDialog(null, skoleplan.trinnPlan(laererRessurs), "Fordeling", JOptionPane.PLAIN_MESSAGE );
	}
//********************************** TEST SLUTT ***********************************************

}