package MorraCinese;

public class Equilibrio
{
	private int[][] tabella;

	public Equilibrio(int n)
	{
		tabella=new int[n][n];
		for (int i= 0; i <n ; i++)
		{
			tabella[i][i]=0; // pareggio
			if(i<n-1)
			{
				tabella[i][i+1]=1;
				tabella[i+1][i]=-1;
			}

			for (int j = i+2; j < n; j++)
			{
				tabella[i][j]=-tabella[i][j-1];
				tabella[j][i]=-tabella[i][j];
			}
		}
	}

	public int getEquilibrio(int i, int j)
	{
		return tabella[i][j];
	}

	public int[][] getTabella() {
		return tabella;
	}


}
