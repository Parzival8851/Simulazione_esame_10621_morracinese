package MorraCinese;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Scrittura
{


	public static final String STATS_TXT = "stats.txt";
	public static final String STATISTICHE_DELLA_PARTITA = "Statistiche della partita";
	public static final String ERRORE_NELL_APERTURA_DEL_FILE = "Errore nell'apertura del file  ";
	public static final String PREVISIONE = "Il computer poteva prevedere le mosse con un accuratezza del ";
	public static final String GIOCATORE_HA_VINTO_LA_PARTITA = "Il giocatore ha vinto la partita";
	public static final String COMPUTER_HA_VINTO_LA_PARTITA = "Il computer ha vinto la partita";
	public static final String SU = "Su ";
	public static final String VITTORIE_DA_OTTENRE = " vittorie da ottenere per vincere la partita, il giocatore ne ha: ";
	public static final String VINTE = "vinte ";
	public static final String PERSE = "perse ";
	public static final String PAREGGIATE = "pareggiate ";
	public static final String PERC = "%";
	public static final String FILE_DELLE_STATISTICHE_CREATO = "File delle statistiche creato";
	private PrintWriter p;

	public Scrittura(Giocatore giocatore, Computer computer, int v)
	{

		try
		{
			p = new PrintWriter(new FileWriter(STATS_TXT));
			p.println(STATISTICHE_DELLA_PARTITA);
			if(computer.getForzaPredizione()>0)
			{
				p.println(PREVISIONE +computer.getForzaPredizione()+ PERC);
			}
			if (giocatore.getVittorie()==v)
				p.println(GIOCATORE_HA_VINTO_LA_PARTITA);
			else
				p.println(COMPUTER_HA_VINTO_LA_PARTITA);

			p.println(SU +v+ VITTORIE_DA_OTTENRE);
			p.println(VINTE +giocatore.getVittorie());
			p.println(PERSE +giocatore.getSconfitte());
			p.println(PAREGGIATE +giocatore.getSconfitte());
		}
		catch(IOException e)
		{
			System.out.println(ERRORE_NELL_APERTURA_DEL_FILE +e.getMessage());
		}
		finally
		{
			p.close();
		}

		System.out.println(FILE_DELLE_STATISTICHE_CREATO);

	}
}
