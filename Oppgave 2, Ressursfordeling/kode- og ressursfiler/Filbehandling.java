/*********************************************************************
 * Klassen Filbehandling
 *
 * Programmerer: Rune Even Holmdal
 * Dato: 30.11.2014
 *
 *********************************************************************
 * Metoder for lesing av fil, tilpasset klassene Aarstrinn,
 * Fag og Laerer
 ********************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Filbehandling
{

	// Finner antall linjer i en fil
	public int antLinjer( String filNavn )
	{
		BufferedReader br = null;
		String lestData = "";
		int antLinjer = 0;
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			// Leser første linje, som bare er overskrift
			lestData = br.readLine();
			while( ( lestData = br.readLine() ) != null )
			{
				antLinjer++;
			}
		}
		catch ( IOException e )
		{
			JOptionPane.showMessageDialog( null, e.toString(),
				"Fil error!", JOptionPane.PLAIN_MESSAGE );
		}
		finally
		{
			if ( br != null )
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					JOptionPane.showMessageDialog( null, e.toString(),
						"Fil error!", JOptionPane.PLAIN_MESSAGE );
				}
			}
			return antLinjer;
		}
	} // slutt antLinjer

	// Metoden fyller array objektet av klassen Fag med innhold fra fil
	public Fag[] lesFagRessurs(String filNavn, Fag[] f)
	{
		String lestData = "";
		BufferedReader br = null;
		int i = 0;
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			// Leser første linje, som bare er overskrift
			lestData = br.readLine();
			while( ( lestData = br.readLine() ) != null )
			{
				f[i] = new Fag( lestData );
				i++;
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),
				"Fil error!", JOptionPane.PLAIN_MESSAGE );
		}
		finally
		{
			if ( br != null )
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					JOptionPane.showMessageDialog(null, e.toString(),
						"Fil error!", JOptionPane.PLAIN_MESSAGE );
				}
			}
			return f;
		}
	} // slutt lesFagRessurs

	// Metoden fyller array objektet av klassen Aarstrinn med
	// innhold fra fil
	public Aarstrinn[] lesAarstrinnRessurs(
		String filNavn, Aarstrinn[] trinn )
	{
		String lestData = "";
		BufferedReader br = null;
		int i = 0;
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			// Leser første linje, som bare er overskrift
			lestData = br.readLine();
			while( ( lestData = br.readLine() ) != null )
			{
				String[] data = lestData.split(";");
				String[] f = new String[ (data.length-1)/2 ];
				int[] t = new int [ (data.length-1)/2 ];
				int y = 0;
				String id = data[0];
				for ( int x = 1; x < data.length; x+=2 )
				{
					f[y] = data[x];
					t[y] = Integer.parseInt( data[x+1] );
					y++;
				}
				//Boolean xxx = tilFagArray( f );
				trinn[i] = new Aarstrinn( f, t, id );
				i++;
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog( null, e.toString(),
				"Fil error!", JOptionPane.PLAIN_MESSAGE );
		}
		finally
		{
			if ( br != null )
			{
				try
				{
					br.close();
				}
				catch ( IOException e )
				{
					JOptionPane.showMessageDialog( null, e.toString(),
						"Fil error!", JOptionPane.PLAIN_MESSAGE );
				}
			}
			return trinn;
		}
	} //slutt lesAarstrinnRessurs

	// Metoden fyller array objektet av klassen Laerer med innhold
	// fra fil
	public Laerer[] lesLaererRessurs(
		String filNavn, Laerer[] laererRessurs )
	{
		String lestData = "";
		String navn = "";
		String[] kompetanse = new String[3];
		String[] oppgaver = new String[3];
		int spesielleTimer;
		int tilgjengeligeTimer;
		BufferedReader br = null;
		int i = 0;
		String s = "";
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			// Leser første linje, som bare er overskrift
			lestData = br.readLine();
			while( ( lestData = br.readLine() ) != null )
			{
				String[] data = lestData.split( ";" );
				navn = data[0];
				kompetanse[0] = data[1];
				kompetanse[1] = data[2];
				kompetanse[2] = data[3];
				oppgaver[0] = data[4];
				oppgaver[1] = data[5];
				oppgaver[2] = data[6];
				s += data[7] + ", ";
				spesielleTimer = Integer.parseInt( data[7] );
				tilgjengeligeTimer = Integer.parseInt( data[8] );
				laererRessurs[i] = new Laerer( navn, kompetanse, oppgaver,
					spesielleTimer, tilgjengeligeTimer );
				i++;
			}
		}
		catch ( IOException e )
		{
			JOptionPane.showMessageDialog( null, e.toString(),
				"Fil error!", JOptionPane.PLAIN_MESSAGE );
		}
		finally
		{
			if ( br != null )
			{
				try
				{
					br.close();
				}
				catch ( IOException e )
				{
					JOptionPane.showMessageDialog( null, e.toString(),
						"Fil error!", JOptionPane.PLAIN_MESSAGE );
				}
			}
			return laererRessurs;
		}

	} // slutt lesLaererRessurs

	// Metoden skriver innholdet i to JTextArea	objekter til en
	// spesifisert fil
	public Boolean skrivResultatfil(
		String filNavn, JTextArea a, JTextArea b )
	{
		Boolean suksess = true;
		String resultat1 = a.getText();
		String resultat2 = b.getText();
		BufferedWriter bw = null;
		try
		{
			// Lager en ny fil hver gang
			bw = new BufferedWriter(new FileWriter(filNavn));
			bw.write( resultat1 );
			bw.newLine();
			bw.write ( resultat2 );
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),
				"Fil error!", JOptionPane.PLAIN_MESSAGE );
			suksess = false;
		}
		finally
		{
			if ( bw != null )
			{
				try
				{
					bw.close();
				}
				catch (IOException e)
				{
					JOptionPane.showMessageDialog(null, e.toString(),
						"Fil error!", JOptionPane.PLAIN_MESSAGE );
				}
			}
			return suksess;
		}
	} //  Slutt skrivResultatfil
}