package MorraCinese;

import java.util.ArrayList;

public class Elemento
{
	public static final String SASSO = "Sasso";
	public static final String CARTA = "Carta";
	public static final String FORBICE = "Forbice";
	public static final String SPOCK = "Spock";
	public static final String LUCERTOLA = "Lucertola";
	private ArrayList<String> elementi = new ArrayList<>();

	public Elemento()
	{
		elementi.add(FORBICE); // 0
		elementi.add(SASSO); // 1
		elementi.add(CARTA); // 2
	}

	public void aggiungereMorraAvanzata()
	{
		elementi.add(LUCERTOLA); // 3
		elementi.add(SPOCK); // 4
	}

	public String getElemento(int i)
	{
		return elementi.get(i);
	}

	public ArrayList<String> getElementi() {
		return elementi;
	}
}
