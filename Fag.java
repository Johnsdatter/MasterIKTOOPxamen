/*
*
*
*
*/

public class Fag
{
	private String fagNavn;
	private int l�rerIndeks;
	//private int ressurs;

	//konstrukt�r
	public Fag()
	{
		fagNavn = "";
		l�rerIndeks = 0;
	}

	//Konstrukt�r
	public Fag(String f, int l)
	{
		fagNavn = f;
		l�rerIndeks = metode_som_finner_indeksen_til(f);//??
	}

	public String setFag(String f)
	{
		fagNavn = f;
		l�rerIndeks = metode_som_finner_indeksen_til(f);//???
	}

	/*Fag fagData = new Fag(); // opprettet konstrukt�r
	//Fag fagData = new Fag("jens", 4)

	// skal vi legge inn mulige fag, og ha boks der bruker kan huke av fag? Hvis vi er S� gode, da :P

	fagData.setFag(fagInput);
	fagData.setLarere(larerInput);
	fagData.setRessurser(ressursInput) */

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