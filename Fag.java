import javax.swing.JOptionPane;

public class Fag
{

	Fag fagData = new Fag(); // opprettet konstrukt�r

	// skal vi legge inn mulige fag, og ha boks der bruker kan huke av fag? Hvis vi er S� gode, da :P

	fagData.setFag(fagInput);
	fagData.setLarere(larerInput);
	fagData.setRessurser(ressursInput);

	public String getFag() // lager en get-metode som returnerer faget
	{
		return fag;
	}
	public String getLarere() // lager en get-metode som returnerer l�rere
	{
		return larere;
	}
	public String getRessurser() // lager en get-metode som returnerer ressurser
	{
		return ressurser;
	}
}

// for-l�kke for � se etter hvor mange timer l�rerne har igjen (hvem har mest?)