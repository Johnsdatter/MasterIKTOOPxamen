import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Filbehandling
{

	private String test = "Fuck";
	public int antLinjer(String filNavn)
	/* Finner antall linjer i filen. */
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

	//Aarstrinn[] trinn = new Aarstrinn[aarstrinnRoK[0]];
	public int[] antRogK(String filNavn)
	/* Finner antall rader og (maks) antall kolonner i filen. */
	{
		BufferedReader br = null;
		String lestData = "";
		int[] rk = { 0, 0 };
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			while( ( lestData = br.readLine() ) != null )
			{
				String[] data = lestData.split(";");
				rk[0]++;
				if ( data.length > rk[1] )
					rk[1] = data.length;
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
			return rk;
		}
	}

	public Fag[] lesFagRessurs(String filNavn, Fag[] f)
	{
		String lestData = "";
		BufferedReader br = null;
		int i = 0;
		//String s = "filinnhold ikke lest";
		try
		{
			//s = "";
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

	public Aarstrinn[] lesAarstrinnRessurs(String filNavn, Aarstrinn[] trinn)
	{
		String lestData = "";
		BufferedReader br = null;
		int i = 0;
		String s = "filinnhold ikke lest";
		try
		{
			s = "";
			br = new BufferedReader( new FileReader(filNavn) );
			while( ( lestData = br.readLine() ) != null )
			{
				String[] data = lestData.split(";");
				String[] f = new String[data.length/2];
				int[] t = new int [data.length/2];
				int y = 0;
				for ( int x = 0; x < data.length; x+=2 )
				{
					f[y] = data[x];
					t[y] = Integer.parseInt( data[x+1] );
					y++;
				}
				trinn[i] = new Aarstrinn( f, t );
				test += "kkk";// + trinn[0].getFag(0);
				/*JOptionPane.showMessageDialog(null, i + "\t" + f[0] + ", " + f[1] + ", " + f[2] + ", " + f[3] + ", " + f[4] + "\n" +
													"\t" + t[0] + ", " + t[1] + ", " + t[2] + ", " + t[3] + ", " + t[4],
													"Les while løkke", JOptionPane.PLAIN_MESSAGE );*/
				/*for ( int v = 0; v < data.length/2; v++ )
				{

					test += trinn[i].getFag(v) + trinn[i].getTimer(v) + "\n";
				}*/
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

	//************ lesLaererRessurs
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
			s = "";
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

				//Viser hver linje som leses fra fil
				//melding( kompetanse[0] + ", " + kompetanse[1] + ", " +kompetanse[2] );

				/*for ( int v = 0; v < data.length/2; v++ )
				{

					test += trinn[i].getFag(v) + trinn[i].getTimer(v) + "\n";
				}*/
				i++;
			}
			//melding( laererRessurs[2].getSpesialKompetanse(1) + ", " + laererRessurs[3].getSpesialKompetanse(1) );
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
	//************ slutt lesLaererRessurs

	private void melding( String m )
	{
		JOptionPane.showMessageDialog(null, m, "Fra filbehandling", JOptionPane.PLAIN_MESSAGE );
	}
}