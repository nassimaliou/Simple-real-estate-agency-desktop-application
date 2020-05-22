package kernel;
public class Wilaya
{
    private long prix_metre_carre;
    private int num_wilaya;

    private static long Tab[] = {100_000 , 30_000 , 60_000};

    public Wilaya (int num_wilaya)
    {
        this.prix_metre_carre = Tab[num_wilaya-1];
        this.num_wilaya = num_wilaya;
    }

    public static long[] getTab() {
        return Tab;
    }

    public static void setTab(long[] tab) {
        Tab = tab;
    }

    public int getNum_wilaya()
    {
        return num_wilaya;
    }
    public void setNum_wilaya(int num_wilaya)
    {
        this.num_wilaya = num_wilaya;
    }
    public long getPrix_metre_carre()
    {
        return prix_metre_carre;
    }
    public void setPrix_metre_carre(long prix_metre_carre)
    {
        this.prix_metre_carre = prix_metre_carre;
    }
}