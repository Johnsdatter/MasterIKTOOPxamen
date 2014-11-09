import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Filbehandling
{
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

	≈rstrinn[] trinn = new ≈rstrinn[ÂrsTrinnRoK[0]];
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

	public ≈rsTrinn[] les≈rsTrinnRessurs(String filNavn, ≈rstrinn[] trinn)
	{
		String lestData = "";
		BufferedReader br = null;
		int i = 0;
		try
		{
			br = new BufferedReader( new FileReader(filNavn) );
			while( ( lestData = br.readLine() ) != null )
			{
				String s = "";
				String[] data = lestData.split(";");
				trinn[i] = new ≈rstrinn( data );
				for ( int y = 0; y < 5; y++ )
				{
					s += trinn[i].getFag(y) + trinn[i].getTimer(y) + "\n";
				}
				JOptionPane.showMessageDialog(null, s, "", JOptionPane.PLAIN_MESSAGE );
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
}