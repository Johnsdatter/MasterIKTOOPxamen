import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Filbehandling
{
	// Finner antall linjer i filen.
	public int antLinjer(String filNavn)
	{
		BufferedReader br = null;
		String lestData = "";
		int antLinjer = 0;
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			while( ( lestData = br.readLine() ) != null )
			{
				antLinjer++;
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "",
				e.toString(), JOptionPane.PLAIN_MESSAGE );
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
					JOptionPane.showMessageDialog(null, "",
						e.toString(), JOptionPane.PLAIN_MESSAGE );
				}
			}
			return antLinjer;
		}
	}

	// Fyller et array objekt av klassen Fag med innhold fra fil
	public Fag[] lesFagRessurs(String filNavn, Fag[] f)
	{
		String lestData = "";
		BufferedReader br = null;
		int i = 0;
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			while( ( lestData = br.readLine() ) != null )
			{
				f[i] = new Fag( lestData, 0 );
				i++;
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "",
				e.toString(), JOptionPane.PLAIN_MESSAGE );
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
					JOptionPane.showMessageDialog(null, "",
						e.toString(), JOptionPane.PLAIN_MESSAGE );
				}
			}
			return f;
		}
	}

		// Fyller et array objekt av klassen Aarstreinn med innhold fra fil
	public Aarstrinn[] lesAarstrinnRessurs(String filNavn, Aarstrinn[] trinn)
	{
		String lestData = "";
		BufferedReader br = null;
		int i = 0;
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
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
				trinn[i] = new Aarstrinn( f, t, id );
				i++;
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "",
				e.toString(), JOptionPane.PLAIN_MESSAGE );
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
					JOptionPane.showMessageDialog(null, "",
						e.toString(), JOptionPane.PLAIN_MESSAGE );
				}
			}
			return trinn;
		}
	}

	// Fyller et array objekt av klassen Laerer med innhold fra fil
	public Laerer[] lesLaererRessurs(String filNavn, Laerer[] laererRessurs)
	{
		String lestData = "";
		String navn = "";
		String[] kompetanse = new String[3];
		String[] oppgaver = new String[3];
		int spesielleTimer;
		int stillingsProsent;
		int tilgjengeligeTimer;
		BufferedReader br = null;
		int i = 0;

		String s = "filinnhold ikke lest";
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			while( ( lestData = br.readLine() ) != null )
			{
				String[] data = lestData.split(";");
				navn = data[0];
				kompetanse[0] = data[1];
				kompetanse[1] = data[2];
				kompetanse[2] = data[3];
				oppgaver[0] = data[4];
				oppgaver[1] = data[5];
				oppgaver[2] = data[6];
				spesielleTimer = Integer.parseInt( data[7] );
				stillingsProsent = Integer.parseInt( data[8] );
				tilgjengeligeTimer = Integer.parseInt( data[9] );
				laererRessurs[i] = new Laerer( navn, kompetanse, oppgaver, spesielleTimer, stillingsProsent, tilgjengeligeTimer );
				i++;
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "",
				e.toString(), JOptionPane.PLAIN_MESSAGE );
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
					JOptionPane.showMessageDialog(null, "",
						e.toString(), JOptionPane.PLAIN_MESSAGE );
				}
			}
			return laererRessurs;
		}

	}

	// Lokal metode for å sende ut debug informasjon
	private void debugMelding( String m )
	{
		JOptionPane.showMessageDialog(null, m, "Fra filbehandling", JOptionPane.PLAIN_MESSAGE );
	}

}
