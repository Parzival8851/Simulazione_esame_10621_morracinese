package MorraCinese;
import it.unibs.fp.mylib.*;

public class Gioco
{
	public static final String SPOCK_E_LUCERTOLA = "Vuoi giocare anche con Spock e Lucertola?  ";
	public static final int ELEMENTI_MORRA_AVANZATA = 5;
	public static final int ELEMENTI_MORRA_TRADIZIONALE = 3;
	public static final String VITTORIE_DA_RAGGIUNGERE_PER_TERMINARE = "Inserisci il numero di vittorie da raggiungere per terminare:  ";
	public static final String COMPUTER_PREDICE = "Inserire la percentuale di partite che il computer predice: ";
	public static final String HA_VINTO_IL_GIOCATORE = "Ha vinto il giocatore!";
	public static final String HA_VINTO_IL_COMPUTER = "Ha vinto il computer! ";
	public static final String PAREGGIO = "Pareggio!";
	public static final String IL_GIOCATORE_SCEGLIE = "Il giocatore sceglie ";
	public static final String IL_COMPUTER_CHE_SCEGLIE = " contro il computer che sceglie ";
	public static final String MARGINE_DI_VANTAGGIO = "Vuoi che il computer abbia un margine di vantaggio? ";
	private static Elemento elem = new Elemento();
	private static int vittorieDaRaggiungere;
	private static Equilibrio equi;
	private static Giocatore giocatore=new Giocatore();
	private static Computer computer;

	public static void main(String[] args)
	{
		sceltaMorra();
		vittorieDaRaggiungere=sceltaVittorie();
		sceltaPredizione();
		giocata();
		vincitore();
		statistiche();
		Scrittura scrittura = new Scrittura(giocatore,computer,vittorieDaRaggiungere);
	}


	private static void sceltaPredizione()
	{
		if(InputDati.yesOrNo(MARGINE_DI_VANTAGGIO))
			computer = new Computer(InputDati.leggiIntero(COMPUTER_PREDICE,1,100));
		else
			computer = new Computer();
	}

	private static void sceltaMorra()
	{
		if(InputDati.yesOrNo(SPOCK_E_LUCERTOLA))
		{
			elem.aggiungereMorraAvanzata();
			equi=new Equilibrio(ELEMENTI_MORRA_AVANZATA);

		}
		else
		{
			equi=new Equilibrio(ELEMENTI_MORRA_TRADIZIONALE);

		}

	}

	private static int sceltaVittorie()
	{
		return InputDati.leggiInteroPositivo(VITTORIE_DA_RAGGIUNGERE_PER_TERMINARE);
	}

	private static void giocata()
	{
		while(computer.getVittorie()<vittorieDaRaggiungere && giocatore.getVittorie()<vittorieDaRaggiungere)
		{
			int sceltaGiocatore=giocatore.scegliereElemento(elem);
			int sceltaComputer;
			if(computer.getForzaPredizione()>0)
				sceltaComputer=computer.decisioneElementoPredetto(equi.getTabella(), sceltaGiocatore);
			else
				sceltaComputer=computer.decisioneElementoRandom(elem.getElementi().size());

			System.out.println(IL_GIOCATORE_SCEGLIE +elem.getElemento(sceltaGiocatore)+ IL_COMPUTER_CHE_SCEGLIE +elem.getElemento(sceltaComputer));

			if(equi.getEquilibrio(sceltaGiocatore,sceltaComputer)>0)
			{
				System.out.println(HA_VINTO_IL_GIOCATORE);
				giocatore.aumentaVittorie();
				computer.aumentaSconfitte();
			}
			else if(equi.getEquilibrio(sceltaGiocatore,sceltaComputer)<0)
			{
				System.out.println(HA_VINTO_IL_COMPUTER);
				computer.aumentaVittorie();
				giocatore.aumentaSconfitte();
			}
			else
			{
				System.out.println(PAREGGIO);
				computer.aumentaPareggi();
				giocatore.aumentaPareggi();
			}
		}
	}

	private static void vincitore()
	{
		if (giocatore.getVittorie()==vittorieDaRaggiungere)
			System.out.println(HA_VINTO_IL_GIOCATORE);
		else
			System.out.println(HA_VINTO_IL_COMPUTER);


	}

	private static void statistiche()
	{
		System.out.println("Su "+vittorieDaRaggiungere+" vittorie da ottenere per vincere la partita, il giocatore ne ha: ");
		System.out.println("vinte "+giocatore.getVittorie());
		System.out.println("perse "+giocatore.getSconfitte());
		System.out.println("pareggiate  "+giocatore.getPareggi());
	}



}
