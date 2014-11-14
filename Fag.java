/*
*
*
*
*/

public class Fag
{
	private String fagNavn;
	private int lærerIndeks;
	//private int ressurs;

	//konstruktør
	public Fag()
	{
		fagNavn = "";
		lærerIndeks = 0;
	}

	//Konstruktør
	public Fag(String f, int l)
	{
		fagNavn = f;
		lærerIndeks = metode_som_finner_indeksen_til(f);//??
	}

	public String setFag(String f)
	{
		fagNavn = f;
		lærerIndeks = metode_som_finner_indeksen_til(f);//???
	}

	/*Fag fagData = new Fag(); // opprettet konstruktør
	//Fag fagData = new Fag("jens", 4)

	// skal vi legge inn mulige fag, og ha boks der bruker kan huke av fag? Hvis vi er SÅ gode, da :P

	fagData.setFag(fagInput);
	fagData.setLarere(larerInput);
	fagData.setRessurser(ressursInput) */

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