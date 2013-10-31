package tareafinal1;
import java.util.Comparator;



public class ArrayListImproved<E> extends java.util.ArrayList <E> implements Accumulable { //agregar , Comparable para el sort comparador

	
	//Metodos que hay que agregar en esta clase 

	public void sort (int start, int end){

		//Ordenamiento usando burbuja
		for (int i = 0; i < this.size(); i++)
		{
			for (int j = i+1; j < this.size(); j++)
			{
				if(((Comparable) this.get(i)).compareTo(this.get(j)) > 0 )
				{
					E tmp = this.get(i);
					this.set(i, this.get(j));
					this.set(j,tmp);
				}
			}
		}	
	}
	public void sort (int start, int end, Comparator<E> c){

		//Ordenamiento usando burbuja
		for (int i = 0; i < this.size(); i++)
		{
			for (int j = i+1; j < this.size(); j++)
			{
				if(c.compare(this.get(i),this.get(j)) > 0 )
				{
					E tmp = this.get(i);
					this.set(i, this.get(j));
					this.set(j,tmp);
				}
			}
		}	
	}
	public void randomize(int start, int end)
	{
		for (int i = start; i <= end; i++)
		{
			//numero aleatorio en [start,end]
			int random = (int)(Math.random()*(end-start+1)) + start;
			E tmp = this.get(i);
			this.set(i, this.get(random));
			this.set(random,tmp);
		}
	}
	
	
	@Override
	public String accumulate(String a, String b) {
		String  concatenado;
		concatenado = a +b;
		return concatenado;
		
	}

	@Override
	public int accumulate(int a, int b) {
		int suma;
		suma = a +b;
		return suma;
	}

	@Override
	public double accumulate(double a, double b) {
		double suma;
		suma = a +b;
		return suma;
		
	}
	
	@Override
	public Object accumulate(Object a, Object b) {

		if( a == null )
			return b;
		if( b == null )
			return a;
		if( ((Comparable) a).compareTo(b) > 0 )
			return a;
		return b;
	}

	
	public E fold()
	{
		E answer = null;

		for( int i = 0; i < this.size(); ++ i )
			answer = (E) accumulate(answer, this.get(i));

		return answer;
	}

	public static void main(String[] args) {


		ArrayListImproved <String> a = new ArrayListImproved <>() ; //lista a es de palabras
		ArrayListImproved <Integer> b= new ArrayListImproved<>();//lista b es de enteros
		ArrayListImproved <Double> c= new ArrayListImproved<>();//lsita c es  de doubles
		ArrayListImproved <String> d= new ArrayListImproved<>();//lsita c es  de doubles

		//aca agrego dos palabras a la lista de palabras
		a.add("mundo");
		a.add("hola");

		//aca la lista de enteros es la lista b
		b.add(20);
		b.add(10);
		b.add(-1);

		MyComparator myCmp = new MyComparator();

		b.sort(0, b.size()-1, myCmp);

		//la lista de doubles lista c
		c.add (12.4);
		c.add(11.6);

		System.out.println("La lista a de palabras antes de usar el sort es " +a); //imprime la lista de palabras
		System.out.println( "La lista b de enteros es " +b);
		System.out.println("La lista c de dobules es " +c  +"  hasta aqui  todas las listas estan desordenadas ");

		a.sort(0, 1);//Primer  metodo sort usado en la lista a de palabras 

		//probar el sort en las otras dos listas 
		b.sort(0, 1);
		c.sort(0, 1);

		System.out.println("Probando el primer sort en la lista de palabras "  +a);
		System.out.println("Probando el primer sort en lista de enteros  " +b);
		System.out.println("Probando el primer sort en lista de doubles " +c);



		//			aca se prueba la interfaz acumulable
		System.out.println("Probando la interfaz Accumulable a un lista de palabras lista a  " + a.accumulate(a.get(0), a.get(1)) );
		System.out.println("Probando la interfaz Accumulable a un lista de enteros lista b " + b.accumulate(b.get(0), b.get(1)));
		System.out.println("Probando la interfaz Accumulable a un lista de doubles lista c " + c.accumulate(c.get(0), c.get(1)));
		
		d.add("hola");
		d.add("mundo");
		d.add("zmundo");
		
System.out.println("Probando el metodo fold lista d " + d.fold());
System.out.println("Probando el metodo fold lista c " + c.fold());
System.out.println("Probando el metodo fold lista b " + b.fold());
	}

	}

