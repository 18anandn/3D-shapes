
public class BST<K extends Comparable<K>> {
   public Nodetree<K> root;
  // public Nodetree<K> global;
   public BST(){
	  
   }
   public int icounter=1;
  
  
   public int insert(K Key) {
	   if(root==null) {
		   root = new Nodetree<K>(Key,1);
		  // System.out.println("myroot" +root.Key.toString());
		   return 1;
		   
	   }
        int n=recursive(root,Key);
        //System.out.println("return"+n);
        return n;
      
   }

   public int recursive(Nodetree<K> node, K key) {
	  // System.out.println("inside recursicv");
	   int num=0;
	   boolean check=false;
	   
	   if(node.Key.compareTo(key)==0) { 
		   //System.out.println("num "+num);
       	return 0;
       }
	        if(node.Key.compareTo(key)<0) {
	        //	System.out.println("goes left"+node.Key.toString());
	        	if(node.leftchild==null) {
	        		// System.out.println("my left child");
	        		 node.leftchild = new Nodetree<K>(key,1);
	        		num=1;
	        		return num;
	        	}
	        
			 // System.out.println("s1");
			 return  recursive(node.leftchild,key);
			   
	        }
	        else if(node.Key.compareTo(key)>0) {
	        	//System.out.println("goes right"+node.Key.toString());
	        	if(node.rightchild==null) {
	        		 node.rightchild = new Nodetree<K>(key,1);

	        		// System.out.println("my right child");
	        		num=1;
	        		return num;
	        	}
	        
			//  System.out.println("s2");
			  return recursive(node.rightchild,key);
			   
	        }   
	        
//	        else if(root.Key.compareTo(key)>0){
//	       	System.out.println("goes right"+root.Key.toString());
//			   if(root.rightchild==null) {
//	        		root.rightchild = new Nodetree<K>(key,1);
//					   System.out.println("my right child" + root.toString());
//	        		return 1;
//	        	}
//			   System.out.println("s2");
//			   recursive(root.rightchild,key);
//		   }
	       // System.out.println("outside");
	         
	        	
	        	
	       return 1;
	        
			
   }
      
   public int counter(K key) {
	   int counter1=1;
	   Nodetree<K> node = root;
	   while(node.Key.compareTo(key)!=0) {
        
       // System.out.println(node.Key);
	    if(node.Key.compareTo(key)<0) {
	    	node=node.leftchild;
		   counter1++;
	   }
	   else if(node.Key.compareTo(key)>0) {
		   node=node.rightchild;
		   counter1++;
	   }}
	  // System.out.println(key.toString());
	  // System.out.println(node.Key.toString());
	/*   if(node.Key.toString().compareTo(key.toString())!=0) {
		  // System.out.println("qwer");
		   while(node!=null) {
			   //System.out.println("qwer3");
		   if(node.Key.toString().compareTo(key.toString())>0) {
			  // System.out.println("qwer1");
		    	node=node.leftchild;
			   counter1++;
		   }
		   else if(node.Key.toString().compareTo(key.toString())<0) {
			   //System.out.println("qwer2");
			   node=node.rightchild;
			   counter1++;}
		   else if(node.Key.toString().compareTo(key.toString())==0) {
			   break;
		   }
		   }
	   }*/
	   return counter1;
   }
   public boolean contains(K key) {
	   Nodetree<K> node=root;
	   
	   boolean contain=false;
	   while(node!=null) {
		  /* System.out.println(node.Key + " simply key");
		   System.out.println(key + " simply key");
		   System.out.println(node.Key.toString() + " concat key");
		   System.out.println(key.toString() + " concat key");*/
		   
		   if(node.Key.compareTo(key)<0) {
			   
			   node=node.leftchild;
		   }
		   else if(node.Key.compareTo(key)>0){
			   
			/*   System.out.println(" goes in the right" + key.toString());
			   System.out.println(node.Key + " simply key");
			   System.out.println(key + " simply key");
			   System.out.println(node.Key.toString() + " concat key");
			   System.out.println(key.toString() + " concat key");*/
			   node=node.rightchild;
			  // System.out.println(node);
		   }
		   else if(node.Key.compareTo(key)==0){
			/*   System.out.println(node.Key + " simply key");
			   System.out.println(key + " simply key");
			   System.out.println(node.Key.toString() + " concat key");
			   System.out.println(key.toString() + " concat key"); */
			   
			  contain=true;
			  break;}
		   
	   }
	   
	   return contain;
   }
 /*  public int update(K key) {
	   Nodetree<K> node=root;
	   if(contains(key)) {
		   int counter=1;
		   while(node!=null) {
			   
			   if(node.Key.compareTo(key)>0) {
				   counter++;
				   node=node.leftchild;
			   }
			   else if(node.Key.compareTo(key)<0){
				   counter++;
				   node=node.rightchild;
			   }
			   else if(node.Key.compareTo(key)==0){
				   if(node.Key.toString().compareTo(key.toString())==0) {
					   node.value=value;
					   break;
					   }
					   else {
						   counter++;
						   node=node.rightchild;
					   }
				   
			   }
			   
		   }
		   return counter;
	   }
	   else {
		   return -1;
	   }
   }*/
   public  K get(K key) {
	   Nodetree<K> node=root;
	   K getvalue=null;

		   if(contains(key)) {
		   while(node!=null) {
			   
			   if(node.Key.compareTo(key)<0) {
				   
				   node=node.leftchild;
			   }
			   else if(node.Key.compareTo(key)>0){
				   node=node.rightchild;
			   }
			   else if(node.Key.compareTo(key)==0){
				       getvalue=node.Key;
					   break;
					   }
					   
				   
			 
			   
		   }
		   }
		   return getvalue;

}
  
   
       }
   
   
