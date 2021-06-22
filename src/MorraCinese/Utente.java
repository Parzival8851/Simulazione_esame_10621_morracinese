package MorraCinese;

public class Utente
{
	private int vittorie=0;
	private int sconfitte=0;
	private int pareggi=0;


	public Utente()
	{
	}

	public int getPareggi() {
		return pareggi;
	}

	public int getSconfitte() {
		return sconfitte;
	}

	public int getVittorie() {
		return vittorie;
	}

	public void aumentaVittorie()
	{
		vittorie++;
	}

	public void aumentaSconfitte()
	{
		sconfitte++;
	}

	public void aumentaPareggi()
	{
		pareggi++;
	}

}
