
public class child extends father{
	private int y;
	
	public child()
	{
		super.
		
		z = 0;
		y = 0;
	}
	
	public String toString()
	{
		return super.toString()+" y = "+y;
	}
	
	public static void main(String arg[])
	{
		child c = new child();
		father f = new father();
		
		System.out.println(f.check(c));
	}
}
