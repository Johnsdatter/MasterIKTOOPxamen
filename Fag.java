import javax.swing.JOptionPane;

public class Fag
{

	public Fag() // opprettet konstruktør uten parametre, initialiserer klassen
	{

	}

	// skal vi legge inn mulige fag, og ha boks der bruker kan huke av fag? Hvis vi er SÅ gode, da :P



	public String getFag() // lager en get-metode som returnerer faget
	{
		return fag;
	}
	public String getLarere() // lager en get-metode som returnerer lærere
	{
		return larere;
	}
	public String getRessurser() // lager en get-metode som returnerer ressurser
	{
		return ressurser;
	}
}

// for-løkke for å se etter hvor mange timer lærerne har igjen (hvem har mest?)