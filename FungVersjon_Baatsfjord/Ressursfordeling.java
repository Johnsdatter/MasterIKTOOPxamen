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
		int maksoppfoeringer = 25; //Samme som i klassen Aarstrinn
		String aarstrinnFilen = "aarstrinnRessurs.csv";
		String laererFilen = "l�rerRessurs.csv";
		String fagFilen = "fagRessurs.csv";

		// For � f� tilgang til metodene i klassen Filbehandling
		Filbehandling fil = new Filbehandling();

		//**** Leser filene for � dimmensjonere arrayene av ressursklassene.
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


		// ****** Test l�kke for � lese ut trinnRessurs registrereinger
		for( int x = 0; x < antAarstrinn; x++)
		{
			String s = "";
			for ( int y = 0; y < 11; y++ )
			{
					s += trinnRessurs[x].getFag(y) + ", " + trinnRessurs[x].getTimer(y) + "\n";
			}
			JOptionPane.showMessageDialog(null, s, "�rstrinn", JOptionPane.PLAIN_MESSAGE );
		}

/*********************************************************************************************
*************                  TESTER INNHOLD I OBJEKTENE                      ***************
*************        trinnRessurs, fagRessurs og laererRessurs                 ***************
**********************************************************************************************/
		// ****** Test l�kke for � lese ut fagRessurs registrereinger
		String s = "";
		for( int x = 0; x < antFag; x++)
		{
				s += fagRessurs[x].getFagNavn() + "\n";
		}
		JOptionPane.showMessageDialog(null, s, "Fag", JOptionPane.PLAIN_MESSAGE );

		// ****** Test l�kke for � lese ut laererRessurs registrereinger
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
			JOptionPane.showMessageDialog(null, s, "L�rer", JOptionPane.PLAIN_MESSAGE );
		}
		laererRessurs[2].setTilgjengeligeTimer( 3 );
		s = "" + laererRessurs[2].getTilgjengeligeTimer();
		JOptionPane.showMessageDialog(null, "Endring av timetall:\n Opprinnelige timetall er 21 og reduseres med 3:\n Gjeldende timetall er: " + s, "L�rer", JOptionPane.PLAIN_MESSAGE );

		Fordeling skoleplan = new Fordeling(fagRessurs, trinnRessurs, laererRessurs);
		skoleplan.fordelLaerere(fagRessurs, trinnRessurs, laererRessurs);
		JOptionPane.showMessageDialog(null, skoleplan.trinnPlan(laererRessurs), "Fordeling", JOptionPane.PLAIN_MESSAGE );
	}
//********************************** TEST SLUTT ***********************************************

}