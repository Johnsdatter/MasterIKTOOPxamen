/**********************************************************************
* Oppgave2: Ressursfordeling
* *********************************************************************
* Programmerer: Rune Even Holmdal
* Dato: 30.11.2014
* *********************************************************************
************************ Hovedklasse **********************************
* Programmet leser datafiler for skolens undervisningstilbud
* (ressursbehovet) og hvilke ressurser som er tilgjengelige
* (ressurstilgangen). Dataene lagres i tre array objekter av klassene
* Aarstrinn, Laerer og Fag.
*
* Klassen Fordeling fordeler ressurstilgangen i forhold til
* ressursbehovet.
*
* Resultatet av fordelinga blir visualiseres og lagret til fil.
*
* Alle datafiler er på csv-formatet, mens resultat er på txt-formatet.
*
**********************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Ressursfordeling
{
	public static void main( String[] args )
	{
		//int maksoppfoeringer = 25; //Samme som i klassen Aarstrinn
		String aarstrinnFilen = "aarstrinnRessurs.csv";
		String laererFilen = "laererRessurs.csv";
		String fagFilen = "fagRessurs.csv";
		String resultatFilen = "resultat.txt";

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
		trinnRessurs = fil.lesAarstrinnRessurs(
			aarstrinnFilen, trinnRessurs );
		fagRessurs = fil.lesFagRessurs(
			fagFilen, fagRessurs );
		laererRessurs = fil.lesLaererRessurs(
			laererFilen, laererRessurs );

		// Fordeler ressurstilgangen etter ressursbehovet
		Fordeling skoleplan = new Fordeling(
			fagRessurs, trinnRessurs, laererRessurs);
		skoleplan.fordelLaerere(
			fagRessurs, trinnRessurs, laererRessurs);

		// Skriver resultatet ut på skjermen.
		JOptionPane.showMessageDialog(
			null, skoleplan.laererRessursEtterFordeling(laererRessurs),
			"Fordeling", JOptionPane.PLAIN_MESSAGE );
		JOptionPane.showMessageDialog(
			null, skoleplan.trinnPlan(laererRessurs),
			"Fordeling", JOptionPane.PLAIN_MESSAGE );

		// Skriver resultat til fil.
		Boolean filOK = fil.skrivResultatfil(
			resultatFilen,
			skoleplan.laererRessursEtterFordeling(laererRessurs),
			skoleplan.trinnPlan(laererRessurs) );
		if (filOK)
			JOptionPane.showMessageDialog(
				null,
				"Resultatfilen resultat.txt er generert.",
				"Slutt", JOptionPane.PLAIN_MESSAGE );
		else
			JOptionPane.showMessageDialog(
				null,
				"FEIL! Resultatfilen ble ikke generert.",
				"Slutt", JOptionPane.PLAIN_MESSAGE );
	}
}