

public class Nodetree<K extends Comparable<K>> extends BST<K>{
  
   K Key;
   Nodetree leftchild;
   Nodetree rightchild;
   int counter;
   public Nodetree(K Key,int counter) {
	   leftchild=null;
	   rightchild=null;
	   
	   this.Key=Key;
	   this.counter=counter;
   }
   
}
