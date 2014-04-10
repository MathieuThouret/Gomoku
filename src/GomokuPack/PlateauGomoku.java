package GomokuPack;

public class PlateauGomoku extends Plateau {
    
    public PlateauGomoku()
    {
        super(9,9);
    }
    
    public PlateauGomoku(int _longueur, int _largeur)
    {
        super(_longueur,_largeur);
    }

    public boolean CheckLigneId(Position pos, int n,int id)
    {
        int x=pos.x;
        int y=pos.y;
        int y_end=y + n;  
        while(y <= largeur && y< y_end && etatPlateau[x-1][y-1] == id)
        {
            y++;
        }
        if(y == y_end )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean CheckColonneId(Position pos, int n,int id)
    {
        int x=pos.x;
        int y=pos.y;
        int x_end=x + n;  
        while(x <= longueur && x< x_end && etatPlateau[x-1][y-1] == id)
        {
            x++;
        }
        if(x == x_end )
        {
            return true;
        }
        else
        {
            return false;
        }
    }   
}
