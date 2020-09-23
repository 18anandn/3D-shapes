
public class arraylist<T> {
   public T obj[];
   public int size=0;
   public arraylist() {
	   obj = (T[])new Object[100];
   }
   public void add(T key) {
	   if(size==obj.length) {
		//   System.out.println
		   T obj1[]=(T[])new Object[2*size];
		   for(int i=0;i<size;i++) {
			   obj1[i]=obj[i];
		   }
		  
		   obj=obj1;
		 
	   }
	   
		   obj[size++]=key;
	   
   }
   public T get(int i) {
	  return obj[i];
   }
   
}
