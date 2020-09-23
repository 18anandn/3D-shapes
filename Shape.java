

public class Shape implements ShapeInterface
{
     arraylist<edge> myedges=new arraylist<edge>();
     BST<edge> mytree = new BST<edge>();
     BST<point> mypoints=new BST<point>();
     arraylist<triangle> my_triangles=new arraylist<triangle>();
     public int no_of_triangles=0;
     public int no_of_points=0;
     long t=0;
	 public boolean ADD_TRIANGLE(float [] triangle_coord){
		point pt1=new point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		point pt2=new point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		point pt3=new point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		
		float condx=(pt2.getX()-pt1.getX());
		float cond1x=(pt3.getX()-pt1.getX());
		float condy=(pt2.getY()-pt1.getY());
		float cond1y=(pt3.getY()-pt1.getY());
		float condz=(pt2.getZ()-pt1.getZ());
		float cond1z=(pt3.getZ()-pt1.getZ());
		//PointInterface tr[]=null;
		
		if((condy*cond1z-cond1y*condz==0) && (condx*cond1z-cond1x*condz==0)&&(condx*cond1y-condy*cond1x==0)) {
			//System.out.println("collinear");
			return false;
		}
		else {
		//	System.out.println("inside");
			triangle tr=new triangle(pt1,pt2,pt3);
			//System.out.println("inside");
			no_of_triangles=no_of_triangles+1;
			edge edge1 = new edge(pt1,pt2);
			edge edge2 = new edge(pt2,pt3);
			edge edge3 = new edge(pt3,pt1);
			boolean ptchecker1=false;
			boolean ptchecker2=false;
			boolean ptchecker3=false;
			//without removing duplicacy
		/*	System.out.println("triangle start");
			System.out.println(tr.pt1.x);
			System.out.println(tr.pt1.y);
			System.out.println(tr.pt1.z);
			
			System.out.println(tr.pt2.x);
			System.out.println(tr.pt2.y);
			System.out.println(tr.pt2.z);
			
			System.out.println(tr.pt3.x);
			System.out.println(tr.pt3.y);
			System.out.println(tr.pt3.z);
			System.out.println("triangle end");*/
			
			point p1=null;
			point p2=null;
			point p3=null;
			
			if(mypoints.insert(pt1)!=0) {
				pt1.cmntriangle.add(tr);
				pt1.cmnpts.add(pt2);
				pt1.cmnpts.add(pt3);
				//mypoints.insert(pt1);
				no_of_points+=1;
				
			}
			
			else {
				ptchecker1=true;
				//System.out.println("ptchecker1" + ptchecker1);
				//System.out.println(mypoints.root.Key.cmnpts.size);
				p1=mypoints.get(pt1);
				mypoints.get(pt1).cmntriangle.add(tr);
				//mypoints.get(pt1).cmnpts.add(pt2);
				//mypoints.get(pt1).cmnpts.add(pt3);
			}
			if(mypoints.insert(pt2)!=0) {
				pt2.cmntriangle.add(tr);
				pt2.cmnpts.add(pt1);
				pt2.cmnpts.add(pt3);
				//mypoints.insert(pt2);
				no_of_points+=1;
			}
			else {
				ptchecker2=true;
				p2=mypoints.get(pt2);
				mypoints.get(pt2).cmntriangle.add(tr);
				//mypoints.get(pt2).cmnpts.add(pt1);
				//mypoints.get(pt2).cmnpts.add(pt3);
			}
			if(mypoints.insert(pt3)!=0) {
				pt3.cmntriangle.add(tr);
				pt3.cmnpts.add(pt2);
				pt3.cmnpts.add(pt1);
				//mypoints.insert(pt3);
				no_of_points+=1;
			}
			else {
				ptchecker3=true;
				p3=mypoints.get(pt3);
				mypoints.get(pt3).cmntriangle.add(tr);
				//mypoints.get(pt3).cmnpts.add(pt1);
				//mypoints.get(pt3).cmnpts.add(pt2);
			}
	/*		System.out.println("size"+mypoints.get(pt1).cmnpts.size);
for(int q=0;q<mypoints.get(pt1).cmnpts.size;q++) {
	System.out.println("size"+mypoints.get(pt1)
			}*/
			//for edge 1
			
			
			
		//	System.out.println("size before insertion"+ myedges.size);
			//tr.commontri.add(tr);
			
			boolean check=false;
			boolean check1=false;
			boolean check2=false;
			
			
			
			for(int i=0;i<myedges.size;i++) {
				edge local=myedges.get(i);
				if(local.equalto(edge1)==0) {
					local.counter+=1;
				//	System.out.println("edge1" +myedges.get(i).counter);
					local.mytriangles.add(tr);
					if(ptchecker1==true) {
						if(pt1.temppts==null) {
							pt1.temppts=pt3;
						}
						else {
							pt1.temppts=null;
						}
					}
					if(ptchecker2==true) {
						
						if(pt2.temppts==null) {
							pt2.temppts=pt3;
						}
						else {
							pt2.temppts=null;
						}
						
					}
					check=true;
					
					
					
				}
				else if(myedges.get(i).equalto(edge2)==0) {
					myedges.get(i).counter+=1;
				//	System.out.println("edge2" +myedges.get(i).counter);
					myedges.get(i).mytriangles.add(tr);
					if(ptchecker3==true) {
						if(pt3.temppts==null) {
							pt3.temppts=pt1;
						}
						else {
							pt3.temppts=null;
						}
					}
					if(ptchecker2==true) {
						
						if(pt2.temppts==null) {
							pt2.temppts=pt1;
						}
						else {
							pt2.temppts=null;
						}
					
					}
					check1=true;
					
				}
				else if(myedges.get(i).equalto(edge3)==0) {
					myedges.get(i).counter+=1;
				//	System.out.println("edge3" +myedges.get(i).counter);
					myedges.get(i).mytriangles.add(tr);
					if(ptchecker1==true) {
						if(pt1.temppts==null) {
							pt1.temppts=pt2;
						}
						else {
							pt1.temppts=null;
						}
					}
					if(ptchecker3==true) {
						
						if(pt3.temppts==null) {
							pt3.temppts=pt2;
						}
						else {
							pt3.temppts=null;
						}
					
					
					
				}
					check2=true;
			}
			//	System.out.println("inside"+ check);
				}
			
		//	System.out.println(t);
			//System.out.println("outside"+ check);
			//pt to pt 
			
			
			if(ptchecker1==true) {
			if(check==false & check2==false) {
				p1.cmnpts.add(pt2);
				p1.cmnpts.add(pt3);
			}
			else {
				//System.out.println("inside"+ pt1.temppts.x);
			if(pt1.temppts!=null) {
				//System.out.println(mypoints.get(pt1).cmnpts.get(0));
				p1.cmnpts.add(pt1.temppts);
				pt1.temppts=null;
			}}}
			if(ptchecker2==true) {
			if(check==false && check1==false) {
				p2.cmnpts.add(pt1);
				p2.cmnpts.add(pt3);
			}
			else {
				
			if(pt2.temppts!=null) {
				p2.cmnpts.add(pt2.temppts);
				pt2.temppts=null;
			}}}
			if(ptchecker3==true) {
			if(check1==false && check2==false) {
				p3.cmnpts.add(pt1);
				p3.cmnpts.add(pt2);
			}
			else {
			if(pt3.temppts!=null) {
				p3.cmnpts.add(pt3.temppts);
				pt3.temppts=null;
			}}}
			
			
			//pt to pt end
			
		//	System.out.println(check);
			if(check==false) {
				edge1.mytriangles.add(tr);
				
				myedges.add(edge1);
				
				
			}
			
			
			//for second edge

			
			
		/*	for(int i=0;i<myedges.size;i++) {
				if(myedges.get(i).equalto(edge2)==0) {
					myedges.get(i).counter+=1;
				//	System.out.println("edge2" +myedges.get(i).counter);
					myedges.get(i).mytriangles.add(tr);
					check1=true;
					break;
					
				}
			}*/
			if(check1==false) {
				edge2.mytriangles.add(tr);
				
				myedges.add(edge2);
			}
			
			//for edge 3

			
		/*	for(int i=0;i<myedges.size;i++) {
				if(myedges.get(i).equalto(edge3)==0) {
					myedges.get(i).counter+=1;
				//	System.out.println("edge3" +myedges.get(i).counter);
					myedges.get(i).mytriangles.add(tr);
					check2=true;
					break;
					
				}
			}*/
			if(check2==false) {
				edge3.mytriangles.add(tr);
				myedges.add(edge3);
			}
			
				for(int j=0;j<my_triangles.size;j++) {
					
					if(tr.adjacenttriangle(my_triangles.get(j))==0) {
						tr.commontri.add(my_triangles.get(j));
					my_triangles.get(j).commontri.add(tr);}
				}
				my_triangles.add(tr);
			/*	System.out.println();
	            System.out.println();
	            System.out.println();
	            System.out.println(my_triangles.size);
	            
	            for(int a=0;a<my_triangles.size;a++) {
	            	System.out.println("inside"+my_triangles.get(a));
	            	for(int q=0;q<my_triangles.get(a).commontri.size;q++) {
	            System.out.println(my_triangles.get(a).commontri.get(q));}}*/
		/*	System.out.println();
            System.out.println();
            System.out.println("Stored pts");
          System.out.println(mypoints.get(pt1).x);
          System.out.println(mypoints.get(pt1).y);
          System.out.println(mypoints.get(pt1).z);
          System.out.println("common points");
          System.out.println(mypoints.get(pt1).cmnpts.size);
          for(int r=0;r<mypoints.get(pt1).cmnpts.size;r++) {
        	  System.out.println(mypoints.get(pt1).cmnpts.get(r).x);
        	  System.out.println(mypoints.get(pt1).cmnpts.get(r).y);
        	  System.out.println(mypoints.get(pt1).cmnpts.get(r).z);
          }
          System.out.println();
          System.out.println();
          System.out.println("Stored pts");
          System.out.println(mypoints.get(pt2).cmnpts.size);
        System.out.println(mypoints.get(pt2).x);
        System.out.println(mypoints.get(pt2).y);
        System.out.println(mypoints.get(pt2).z);
        System.out.println("common points");
        for(int r=0;r<mypoints.get(pt2).cmnpts.size;r++) {
      	  System.out.println(mypoints.get(pt2).cmnpts.get(r).x);
      	  System.out.println(mypoints.get(pt2).cmnpts.get(r).y);
      	  System.out.println(mypoints.get(pt2).cmnpts.get(r).z);
        }
        System.out.println();
        System.out.println();
        System.out.println("Stored pts");
        System.out.println(mypoints.get(pt3).cmnpts.size);
      System.out.println(mypoints.get(pt3).x);
      System.out.println(mypoints.get(pt3).y);
      System.out.println(mypoints.get(pt3).z);
      System.out.println("common points");
      for(int r=0;r<mypoints.get(pt3).cmnpts.size;r++) {
    	  System.out.println(mypoints.get(pt3).cmnpts.get(r).x);
    	  System.out.println(mypoints.get(pt3).cmnpts.get(r).y);
    	  System.out.println(mypoints.get(pt3).cmnpts.get(r).z);
      }*/
        /*    for(int s=0;s<myedges.size;s++) {
            	System.out.println("edge"+s);
            	System.out.println(myedges.get(s).counter);
            	 System.out.println(myedges.get(s).pt1.x);
            	 
            	 System.out.println(myedges.get(s).pt1.y);
            	 System.out.println(myedges.get(s).pt1.z);
            }*/
            
           
         /*   System.out.println();
            System.out.println();
            System.out.println("bst edges");
            System.out.println(mytree.get(edge1));*/
			return true;
				}
			
		 }

	//
	 public int TYPE_MESH(){
		int check=1;
  	edge edge1=new edge();
		int i=0;
		 for( i=0;i<myedges.size;i++) {
			 
			 edge1=myedges.get(i);
			 if(edge1.counter!=2) {
				// System.out.println(i);
				// System.out.println("check" + myedges.get(i).pt1.y);
				 break;
			 }
			
		 }
		 if(i<myedges.size) {
		 if(edge1.counter>2) {
			 return 3;
		 }
		 else {
			 check=2;
			 
			 for(int j=i;j<myedges.size;j++) {
				
				 if(myedges.get(j).counter>2) {
					// System.out.println("check" + myedges.get(j).pt1.y);
					 return 3;
				 }
			 }
		 }}
		 
		 return check;}

	//
	 public EdgeInterface [] BOUNDARY_EDGES(){
		 arraylist<edge> sorted=new arraylist<edge>();
		 
		 for(int i=0;i<myedges.size;i++) {
			 if(myedges.get(i).counter==1) {
				 //System.out.println(myedges.get(i).counter + "inside");
				 sorted.add(myedges.get(i));
				
			 }
		 }
		 
		// System.out.println(sorted.size);
		 if(sorted.size==0) {
			 return null;
		 }
		 int p=0;
		 edge[] sorted1=new edge[sorted.size];
		for(int k=0;k<sorted.size;k++) {
			sorted1[k]=sorted.get(k);
		}
		 sort(sorted1,0,sorted.size-1);
		// System.out.println("sorted");
		/* for(int k=0;k<sorted1.length;k++) {
			 System.out.println(k);
			 System.out.println(sorted1[k].pt1.x);
			 System.out.println(sorted1[k].pt1.y);
			 System.out.println(sorted1[k].pt1.z);
			 System.out.println(sorted1[k].pt2.x);
			 System.out.println(sorted1[k].pt2.y);
			 System.out.println(sorted1[k].pt2.z);
			 System.out.println("exit");
		 }*/
		 
		
		 
		 return sorted1;}
	 void merge(edge a[], int l, int m, int r) 
	    { 
	        
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        
	        edge L[] = new edge [n1]; 
	        edge R[] = new edge [n2]; 
	  
	       
	        for (int i=0; i<n1; ++i) 
	            L[i] = a[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = a[m + 1+ j]; 
	  
	  
	       
	        int i = 0, j = 0; 
	  
	        
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i].compareTo(R[j]) > 0) 
	            { 
	                a[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                a[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        
	        while (i < n1) 
	        { 
	            a[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	       
	        while (j < n2) 
	        { 
	            a[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	 void sort(edge a[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	           
	            int m = (l+r)/2; 
	  
	           
	            sort(a, l, m); 
	            sort(a , m+1, r); 
	  
	           
	            merge(a, l, m, r); 
	        } 
	    } 

	//
	 public int COUNT_CONNECTED_COMPONENTS(){
		  int count=0;
		 BST<triangle> forsearching = new BST<triangle>();
		 Queue<triangle> pathcheck = new Queue<triangle>(no_of_triangles);
		 for(int j=0;j<my_triangles.size;j++) {
			 if(forsearching.contains(my_triangles.get(j))==false) {
				 count=count+1;
				 triangle tr1=my_triangles.get(j);
				 pathcheck.enqueue(tr1);
					// System.out.println("phase1");
					 forsearching.insert(tr1);
					// System.out.println("phase2");
					 while(pathcheck.size()!=0) {
						 triangle temp=pathcheck.dequeue();
						// System.out.println(temp.commontri.size);
						 
						 for(int i=0;i<temp.commontri.size;i++) {
							 triangle trtemp=temp.commontri.get(i);
							// System.out.println("phase41");
							if(forsearching.contains(trtemp)==false) {
								//System.out.println("phase4");
								
								pathcheck.enqueue(trtemp);
								forsearching.insert(trtemp);
							}
						 }
						 
					 }
			 }
		 }
		 
		 //System.out.println("count" + count);
		 return count;}


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	 public TriangleInterface [] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord){
		 point p1=new point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		 point p2=new point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		 point p3=new point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		 triangle tr=new triangle(p1,p2,p3);
		 triangle tr1=new triangle(p1,p2,p3);
         int i=0;
         boolean check=false;
		 for( i=0;i<my_triangles.size;i++) {
			 tr1=my_triangles.get(i);
			 if(tr1.equaltriangle(tr)==0) {
				 check=true;
				 break;
			 }
			 
		 }
		 if(check==false) {
			 return null;
		 }
		 triangle giventr=tr1;
		 TriangleInterface[] arr=new  TriangleInterface[giventr.commontri.size];
		 int k=0;
		 for(int j=0;j<giventr.commontri.size;j++) {
			
			 arr[k]=giventr.commontri.get(j);
			 k++;
		 }
		/* for(int a=0;a<arr.length;a++) {
			 System.out.print(arr[a].pt1.x + " ");
			 System.out.print(arr[a].pt1.y + " ");
			 System.out.print(arr[a].pt1.z + " ");
			 System.out.println();
			 System.out.print(arr[a].pt2.x + " ");
			 System.out.print(arr[a].pt2.y + " ");
			 System.out.print(arr[a].pt2.z + " ");
			 System.out.println();
			 System.out.print(arr[a].pt3.x + " ");
			 System.out.print(arr[a].pt3.y + " ");
			 System.out.print(arr[a].pt3.z + " ");
			 System.out.println();
			 System.out.println();

		 }*/
		 
		 return arr;}


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	 public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		 point p1=new point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		 point p2=new point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		 point p3=new point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		 triangle tr=new triangle(p1,p2,p3);
		 int i=0;
		 boolean check=false;
		 for( i=0;i<my_triangles.size;i++) {
			 if(my_triangles.get(i).equaltriangle(tr)==0) {
				 check=true;
				 break;
			 }
		 }
		 EdgeInterface[] ed=new EdgeInterface[3];
		 if(check=true) {
			 edge e1=new edge(p1,p2);
			 edge e2=new edge(p2,p3);
			 edge e3=new edge(p3,p1);
			 
			 ed[0]=e1;
			 ed[1]=e2;
			 ed[2]=e3;
			/* for(int j=0;j<ed.length;j++) {
				 System.out.println();
				 System.out.print(ed[j].pt1.x + " ");
				 System.out.print(ed[j].pt1.z);
				 System.out.println();
				 System.out.print(ed[j].pt2.x + " ");
				 System.out.print(ed[j].pt2.z);
				 
			 }*/
			 return ed; 
		 }
		
		 return null;
		}

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	 public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		 point p1=new point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		 point p2=new point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		 point p3=new point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		 triangle tr=new triangle(p1,p2,p3);
		 int i=0;
		 boolean check=false;
		 for( i=0;i<my_triangles.size;i++) {
			 if(my_triangles.get(i).equaltriangle(tr)==0) {
				 check=true;
				 break;
			 }
		 }
		 if(check==true) {
			 PointInterface [] ptarr=new  PointInterface[3];
			 ptarr[0]=p1;
			 ptarr[1]=p2;
			 ptarr[2]=p3;
			 return ptarr;
		 }
		 
		 
		 return null;}


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	 public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		 point p1=new point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		 point p2=new point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		 point p3=new point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		 triangle tr=new triangle(p1,p2,p3);
		 
		 int i=0;
		 for( i=0;i<my_triangles.size;i++) {
			if(my_triangles.get(i).equaltriangle(tr)==0) {
				break;
			}
		 }
		 triangle tr1=my_triangles.get(i);
		 TriangleInterface [] arr=new TriangleInterface[tr1.commontri.size];
		 int k=0;
		 for(int j=0;j<tr1.commontri.size;j++) {
			arr[k]= tr1.commontri.get(j);
			k++;
		 }
		 return arr;}


	//INPUT [x,y,z]
	 public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates){
		 point pt=new point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
			point p1= mypoints.get(pt);
		 TriangleInterface[] arr=new TriangleInterface[p1.cmntriangle.size];
		 int j=0;
		 for(int i=0;i<p1.cmntriangle.size;i++) {
			//	triangle e=new triangle(p1,p1.cmntriangle.get(i));
				arr[j]=p1.cmntriangle.get(i);
				j++;
			}
		 
		 return arr;}


	// INPUT [x,y,z]
	 public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates){
		 point pt=new point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
		point p1= mypoints.get(pt);
		PointInterface[] arr=new PointInterface[p1.cmnpts.size];
		int j=0;
		for(int i=0;i<p1.cmnpts.size;i++) {
			arr[j]=p1.cmnpts.get(i);
			j++;
		}
		 return arr;}


	// INPUT[x,y,z]
	 public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates){
		 point pt=new point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
			point p1= mypoints.get(pt);
			EdgeInterface[] arr=new EdgeInterface[p1.cmnpts.size];
			int j=0;
			for(int i=0;i<p1.cmnpts.size;i++) {
				edge e=new edge(p1,p1.cmnpts.get(i));
				arr[j]=e;
				j++;
			}
		 
		 
		 
		 return arr;}


	// INPUT[x,y,z]
	 public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates){ 
		 point pt=new point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
			point p1= mypoints.get(pt);
		 TriangleInterface[] arr=new TriangleInterface[p1.cmntriangle.size];
		 int j=0;
		 for(int i=0;i<p1.cmntriangle.size;i++) {
			//	triangle e=new triangle(p1,p1.cmntriangle.get(i));
				arr[j]=p1.cmntriangle.get(i);
				j++;
			}
		 
		 return arr;}



	// INPUT // [xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 , xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3]   where xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 are 3 coordinates of first triangle and xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3 are coordinates of second triangle as given in specificaition.

	 public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2){
		 BST<triangle> forsearching = new BST<triangle>();
		 Queue<triangle> pathcheck = new Queue<triangle>(no_of_triangles);
		 point p1=new point(triangle_coord_1[0],triangle_coord_1[1],triangle_coord_1[2]);
		 point p2=new point(triangle_coord_1[3],triangle_coord_1[4],triangle_coord_1[5]);
		 point p3=new point(triangle_coord_1[6],triangle_coord_1[7],triangle_coord_1[8]);
		 triangle tr1=new triangle(p1,p2,p3);
		 point p1t=new point(triangle_coord_2[0],triangle_coord_2[1],triangle_coord_2[2]);
		 point p2t=new point(triangle_coord_2[3],triangle_coord_2[4],triangle_coord_2[5]);
		 point p3t=new point(triangle_coord_2[6],triangle_coord_2[7],triangle_coord_2[8]);
		 triangle tr2=new triangle(p1t,p2t,p3t);
		 
		 int j=0;
		 for( j=0;j<my_triangles.size;j++) {
			 if(tr1.equaltriangle(my_triangles.get(j))==0) {
				 break;
			 }
		 }
		 pathcheck.enqueue(my_triangles.get(j));
		// System.out.println("phase1");
		 forsearching.insert(tr1);
		// System.out.println("phase2");
		 while(pathcheck.size()!=0) {
			 triangle temp=pathcheck.dequeue();
			 //System.out.println(temp.commontri.size);
			 
			 for(int i=0;i<temp.commontri.size;i++) {
				 triangle trtemp=temp.commontri.get(i);
				// System.out.println("phase41");
				if(forsearching.contains(trtemp)==false) {
					//System.out.println("phase4");
					
					pathcheck.enqueue(trtemp);
					forsearching.insert(trtemp);
				}
			 }
			 
		 }
		 if(forsearching.contains(tr2)==true) {
			// System.out.println("12345");
			 return true;
		 }
		// System.out.println("12345asdf");
		 return false;}


	// INPUT [x1,y1,z1,x2,y2,z2] // where (x1,y1,z1) refers to first end point of edge and  (x2,y2,z2) refers to the second.
	 public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates){ 
		 point p1=new point(edge_coordinates[0],edge_coordinates[1],edge_coordinates[2]);
		 point p2=new point(edge_coordinates[3],edge_coordinates[4],edge_coordinates[5]);
         edge e1=new edge(p1,p2);
         int i=0;
         for( i=0;i<myedges.size;i++) {
        	 if(myedges.get(i).compareTo(e1)==0) {
        		 break;
        	 }
         }
         edge givenedge=myedges.get(i);
         TriangleInterface[] arr=new TriangleInterface[givenedge.mytriangles.size];
         int k=0;
         for(int j=0;j<givenedge.mytriangles.size;j++) {
            arr[k]=givenedge.mytriangles.get(j);
       //     System.out.println(myedges.get(i).mytriangles.get(j));
            k++;
		 }
         
         return arr;
	 }
	 public int MAXIMUM_DIAMETER(){
		 
		
    	 Queue<triangle> pathcheck = new Queue<triangle>(no_of_triangles);
    	 
    	 arraylist<triangle> maxcomponent=new arraylist<triangle>();
    	 
    	 
    	 for(int j=0;j<my_triangles.size;j++) {
    		
    		 BST<triangle> forsearching = new BST<triangle>();
    		 arraylist<triangle> maxcomponenttemp=new arraylist<triangle>();
			 if(forsearching.contains(my_triangles.get(j))==false) {
				
				
				 triangle tr1=my_triangles.get(j);
				 pathcheck.enqueue(tr1);
					// System.out.println("phase1");
					 forsearching.insert(tr1);
					 maxcomponenttemp.add(tr1);
					
					// System.out.println("phase2");
					 while(pathcheck.size()!=0) {
						 triangle temp=pathcheck.dequeue();
						// System.out.println(temp.commontri.size);
						 
						 for(int i=0;i<temp.commontri.size;i++) {
							 triangle trtemp=temp.commontri.get(i);
							// System.out.println("phase41");
							if(forsearching.contains(trtemp)==false) {
								//System.out.println("phase4");
								forsearching.insert(trtemp);
								pathcheck.enqueue(trtemp);
								 maxcomponenttemp.add(tr1);
							//	centroids.add(trtemp.centroid());
								
								
							}
							
						 }
						 
					 }
					// System.out.println("insidecentroid");

					
					
					
					 }
			 if(maxcomponenttemp.size>maxcomponent.size) {
				 maxcomponent=maxcomponenttemp;}
			 }
    	// System.out.println(maxcomponent.size);
    	  int maxdia=0;
    	 for(int j=0;j<maxcomponent.size;j++) {
     		
    		 BST<triangle> forsearching = new BST<triangle>();
    		 int maxdiameter=0;
			 if(forsearching.contains(maxcomponent.get(j))==false) {
				
				
				 triangle tr1=maxcomponent.get(j);
				 pathcheck.enqueue(tr1);
					// System.out.println("phase1");
					 forsearching.insert(tr1);
					 
					 
					// System.out.println("phase2");
					 int size=1;
					 while(pathcheck.size()!=0) {
						 triangle temp=pathcheck.dequeue();
						 size--;
						// System.out.println("sizee"+temp.commontri.size);
						 
						 for(int i=0;i<temp.commontri.size;i++) {
							 triangle trtemp=temp.commontri.get(i);
							 
							// System.out.println("phase41");
							if(forsearching.contains(trtemp)==false) {
								//System.out.println("phase4");
								forsearching.insert(trtemp);
								pathcheck.enqueue(trtemp);
							//	if(check==false) {
							//	maxdiameter=maxdiameter+1;}
								
								// System.out.println(maxdiameter);
								
								
							//	centroids.add(trtemp.centroid());
								
								
							}
							
						 }
						 if(size==0 && pathcheck.size()!=0) {
							 size=pathcheck.size();
							 maxdiameter=maxdiameter+1;}
					 }
					 
					// System.out.println("insidecentroid");

					// System.out.println("mid"+maxdiameter);
					 
					
					
					 }
			 if(maxdia<maxdiameter) {
				 maxdia=maxdiameter;
			 }
			
			 
			
			 }
			
		// System.out.println("maxdiameter"+maxdia);
		 
		 
		 return maxdia;}



     public PointInterface [] CENTROID (){
    	 BST<triangle> forsearching = new BST<triangle>();
    	 Queue<triangle> pathcheck = new Queue<triangle>(no_of_triangles);
    	 
    	 arraylist<point> centroids=new arraylist<point>();
    	 int qwe=0;
    	 
    	 for(int j=0;j<my_triangles.size;j++) {
    		 BST<point> forsearchingpts = new BST<point>();
    		 float sumx=0;
    		 float sumy=0;
    		 float sumz=0;
    		 int size=0;
    		 boolean check=false;
			 if(forsearching.contains(my_triangles.get(j))==false) {
				 check=true;
				
				 triangle tr1=my_triangles.get(j);
				 pathcheck.enqueue(tr1);
					// System.out.println("phase1");
					 forsearching.insert(tr1);
					 
					 if(forsearchingpts.insert(tr1.pt1)>0) {
						 sumx=sumx+tr1.pt1.x;
						 sumy=sumy+tr1.pt1.y;
						 sumz=sumz+tr1.pt1.z;
						 size=size+1;
						 
					 //forsearchingpts.insert(tr1.pt1);
					 
					 }
					 if(forsearchingpts.insert(tr1.pt2)>0) {
						 sumx=sumx+tr1.pt2.x;
						 sumy=sumy+tr1.pt2.y;
						 sumz=sumz+tr1.pt2.z;
						 size=size+1;
					
					 //forsearchingpts.insert(tr1.pt2);
					 
					 }
					 if(forsearchingpts.insert(tr1.pt3)>0) {
						 sumx=sumx+tr1.pt3.x;
						 sumy=sumy+tr1.pt3.y;
						 sumz=sumz+tr1.pt3.z;
						// System.out.println("inside3");
						// System.out.println(sumx);
						 //System.out.println(sumy);
						 //System.out.println(sumz);
						 size=size+1;
					 //forsearchingpts.insert(tr1.pt3);
					 }	 
					// System.out.println("phase2");
					 while(pathcheck.size()!=0) {
						 triangle temp=pathcheck.dequeue();
						// System.out.println(temp.commontri.size);
						 
						 for(int i=0;i<temp.commontri.size;i++) {
							 triangle trtemp=temp.commontri.get(i);
							// System.out.println("phase41");
							if(forsearching.contains(trtemp)==false) {
								//System.out.println("phase4");
								forsearching.insert(trtemp);
								pathcheck.enqueue(trtemp);
							//	centroids.add(trtemp.centroid());
								if(forsearchingpts.insert(trtemp.pt1)!=0) {
									 sumx=sumx+trtemp.pt1.x;
									 sumy=sumy+trtemp.pt1.y;
									 sumz=sumz+trtemp.pt1.z;
									 size=size+1;
								 //forsearchingpts.insert(trtemp.pt1);
								 }
								 if(forsearchingpts.insert(trtemp.pt2)!=0) {
									 sumx=sumx+trtemp.pt2.x;
									 sumy=sumy+trtemp.pt2.y;
									 sumz=sumz+trtemp.pt2.z;
									 size=size+1;
								// forsearchingpts.insert(trtemp.pt2);
								 }
								 if(forsearchingpts.insert(trtemp.pt3)!=0) {
									 sumx=sumx+trtemp.pt3.x;
									 sumy=sumy+trtemp.pt3.y;
									 sumz=sumz+trtemp.pt3.z;
									 size=size+1;
								// forsearchingpts.insert(trtemp.pt3);
								 }
								
							}
							
						 }
						 
					 }
					// System.out.println("insidecentroid");

					 if(check==true) {
					 point centroid=new point(sumx/size,sumy/size,sumz/size);
					// System.out.println("size"+size);
					 centroids.add(centroid);
					//System.out.println(centroids.get(0).x);
					
					 }
			 }

			
		 }
    	// System.out.println()
    	 point arr[]=new point[centroids.size];
    	 //point centroid=new point(sumx/size,sumy/size,sumz/size);
    	 int a=0;
    	 //System.out.println("size"+size);
    	 //System.out.println("centroid");
    	 int k=0;
    	 for( k=0;k<centroids.size;k++) {
    		 arr[a]=centroids.get(k);
    		 
    		 a++;
    	 }
    	 sort1(arr,0,k-1);
	
	return arr; 
	
	}
     void merge1(point a[], int l, int m, int r) 
	    { 
	        
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        
	        point L[] = new point [n1]; 
	        point R[] = new point [n2]; 
	  
	       
	        for (int i=0; i<n1; ++i) 
	            L[i] = a[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = a[m + 1+ j]; 
	  
	  
	       
	        int i = 0, j = 0; 
	  
	        
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i].compareTo(R[j]) > 0) 
	            { 
	                a[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                a[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        
	        while (i < n1) 
	        { 
	            a[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	       
	        while (j < n2) 
	        { 
	            a[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	 void sort1(point a[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	           
	            int m = (l+r)/2; 
	  
	           
	            sort1(a, l, m); 
	            sort1(a , m+1, r); 
	  
	           
	            merge1(a, l, m, r); 
	        } 
	    } 
	// INPUT [x,y,z]
	 public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates){
		 point p=new point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
		 
		 BST<point> forsearching = new BST<point>();
		 Queue<point> pathcheck = new Queue<point>(no_of_points);
		 
		 float sumx=0;
		 float sumy=0;
		 float sumz=0;
		 int size=0;
		 int j=0;
		 
		 pathcheck.enqueue(mypoints.get(p));
		// System.out.println("phase1");
		 forsearching.insert(p);
		 sumx=sumx+p.x;
		 sumy=sumy+p.y;
		 sumz=sumz+p.z;
		 size=size+1;
		// System.out.println("phase2");
		 while(pathcheck.size()!=0) {
			 point temp=pathcheck.dequeue();
			// System.out.println(temp.commontri.size);
			 
			 for(int i=0;i<temp.cmnpts.size;i++) {
				 point pttemp=temp.cmnpts.get(i);
				// System.out.println("phase41");
				if(forsearching.insert(pttemp)!=0) {
					//System.out.println("phase4");
					
					pathcheck.enqueue(pttemp);
					//forsearching.insert(pttemp);
					sumx=sumx+pttemp.x;
					 sumy=sumy+pttemp.y;
					 sumz=sumz+pttemp.z;
					 size=size+1;
				}
				//System.out.println();
				//System.out.println(forsearching.insert(pttemp));
			 }
			
			 
		 }
		 point centroid=new point(sumx/size,sumy/size,sumz/size);
		// System.out.println(centroid.x +"centroid");
		 //System.out.println(centroid.y);
		 //System.out.println(centroid.z);
	return centroid;
	}


	 public 	PointInterface [] CLOSEST_COMPONENTS(){
		 
		 arraylist<arraylist<point>> components =new  arraylist<arraylist<point>>();
		 point[] mindistance=new point[2];
		 BST<triangle> forsearching = new BST<triangle>();
    	 Queue<triangle> pathcheck = new Queue<triangle>(no_of_triangles);
    	 double mindis=10000000;
    	
    	// int qwe=0;
    	 
    	 for(int j=0;j<my_triangles.size;j++) {
    		 
    		 boolean check=false;
    		 triangle tr1=my_triangles.get(j);
			 if(forsearching.insert(tr1)!=0) {
				 check=true;
				 arraylist<point> comp=new arraylist<point>();
				 BST<point> forsearchingpts = new BST<point>();
				
				 pathcheck.enqueue(tr1);
					// System.out.println("phase1");
					// forsearching.insert(tr1);
					 
					 if(forsearchingpts.insert(tr1.pt1)!=0) {
						comp.add(tr1.pt1);
					 //forsearchingpts.insert(tr1.pt1);
					 
					 }
					 if(forsearchingpts.insert(tr1.pt2)!=0) {
						 comp.add(tr1.pt2);
					
					// forsearchingpts.insert(tr1.pt2);
					 
					 }
					 if(forsearchingpts.insert(tr1.pt3)!=0) {
						comp.add(tr1.pt3);
						// System.out.println("inside3");
						// System.out.println(sumx);
						 //System.out.println(sumy);
						 //System.out.println(sumz);
						
					// forsearchingpts.insert(tr1.pt3);
					 }	 
					// System.out.println("phase2");
					 while(pathcheck.size()!=0) {
						 triangle temp=pathcheck.dequeue();
						// System.out.println(temp.commontri.size);
						 
						 for(int i=0;i<temp.commontri.size;i++) {
							 triangle trtemp=temp.commontri.get(i);
							// System.out.println("phase41");
							if(forsearching.insert(trtemp)!=0) {
								//System.out.println("phase4");
								//forsearching.insert(trtemp);
								pathcheck.enqueue(trtemp);
							//	centroids.add(trtemp.centroid());
								if(forsearchingpts.insert(trtemp.pt1)!=0) {
									 comp.add(trtemp.pt1);
								// forsearchingpts.insert(trtemp.pt1);
								 
								}
								 if(forsearchingpts.insert(trtemp.pt2)!=0) {
									 comp.add(trtemp.pt2);
								// forsearchingpts.insert(trtemp.pt2);
								 }
								 if(forsearchingpts.insert(trtemp.pt3)!=0) {
									 comp.add(trtemp.pt3);
								// forsearchingpts.insert(trtemp.pt3);
								 }
								
							}
							
						 }
						 
					 }
					// System.out.println("insidecentroid");

					components.add(comp);
			 }

			
		 }
    	// System.out.println("size"+components.size);
    	for(int q=0;q<components.size;q++) {
    		arraylist<point> qtemp=components.get(q);
    		 for(int p=q+1;p<components.size;p++) {
    			 arraylist<point> ptemp=components.get(p);
    			 for(int r=0;r<qtemp.size;r++) {
    				 point rtemp= qtemp.get(r);
    				 for(int s=0;s<ptemp.size;s++) {
    					 point stemp=ptemp.get(s);
    					if(mindis> rtemp.distance(stemp)) {
    						mindistance[0]=stemp;
    						mindistance[1]=rtemp;
    						mindis=rtemp.distance(stemp);
    					}
    					
    				 }
    			 }
    		 }
    	 }
		// System.out.println(mindistance[0].x);
		 //System.out.println(mindistance[0].y);
		 //System.out.println(mindistance[0].z);
		 //System.out.println(mindistance[1].x);
		 //System.out.println(mindistance[1].y);
		 //System.out.println(mindistance[1].z);
	return mindistance;
	}


}

