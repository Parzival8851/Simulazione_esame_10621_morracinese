package MorraCinese;

import it.unibs.fp.mylib.NumeriCasuali;

public class Computer extends Utente
{
	private int forzaPredizione=0;

	public Computer(int p) // costruttore per predizione
	{
		forzaPredizione=p;
	}

	public Computer() // costruttore per random
	{
	}

	public int decisioneElementoRandom(int dim)
	{
		return NumeriCasuali.estraiIntero(0,dim-1);
	}


	public int decisioneElementoPredetto(int[][] tabella, int sceltaGiocatore)
	{
		if(NumeriCasuali.estraiIntero(0,100)<=forzaPredizione) // vinco solo il
		{
			for (int i = 0; i < tabella.length; i++)
			{
				if (tabella[sceltaGiocatore][i]<0)
					return i;
				// scelgo nella riga dell'elemento del giocatore il primo che vince
				// cioè il primo dove tabella[a][b]=-1
			}
		}

		return decisioneElementoRandom(tabella.length); // il resto del casi (100-forzaPredizione)% è casuale
	}

	public int getForzaPredizione() {
		return forzaPredizione;
	}
}
