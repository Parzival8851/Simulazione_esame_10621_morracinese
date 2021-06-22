package MorraCinese;

import it.unibs.fp.mylib.InputDati;

public class Giocatore extends Utente
{

	public static final String ELEMENTI_DELLA_MORRA = "Ecco gli elementi della morra: ";
	public static final String GIOCARE_CONTRO_IL_COMPUTER = "Quale vuoi giocare contro il Computer?";
	public static final String OPEN = "(";
	public static final String CLOSE = ")";

	public Giocatore()
	{
	}

	public int scegliereElemento(Elemento elem)
	{
		System.out.println(ELEMENTI_DELLA_MORRA);
		for(String e : elem.getElementi())
		{
			System.out.println(e + OPEN +elem.getElementi().indexOf(e)+ CLOSE);
		}
		return InputDati.leggiIntero(GIOCARE_CONTRO_IL_COMPUTER,0,elem.getElementi().size()-1);
	}
}
