import java.util.ArrayList;
public class Assigment2P2 {
	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);
		ArrayList<Integer> newList = removeDuplicates(list);
		System.out.print(newList);
	}
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
   	 {
      	   for(int i = 0; i < list.size(); i++)
      	  {
         	  for(int j=0;j < list.size(); j++)
         	    {
           	      if( i!=j && list.get(i)==list.get(j))
          	       {
          	         list.remove(j);
          	       }
        	     }
   	  }
 	 return list;
   	 }
}
