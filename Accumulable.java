package tareafinal1;
public interface Accumulable<E>
{
	public E accumulate (E a, E b);	
	
    public String accumulate (String a, String b);
	
	public int accumulate (int a, int b);
	
	public double accumulate (double a, double b);
}
