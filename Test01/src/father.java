
public class father extends grandpa{
	private int x;
	protected int z;
	
	public father()
	{
		x = 0;
	}
	
	public String toString()
	{
		return "x= "+x;
	}
	
	public boolean check(father f)
	{
		return true;
	}
}
