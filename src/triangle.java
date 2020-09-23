
public class triangle implements TriangleInterface,Comparable<triangle>{
	public point pt1;
	public point pt2;
	public point pt3;
	public edge edge1;
	public edge edge2;
	public edge edge3;
	arraylist<triangle> commontri;
	
	public triangle(point p1,point p2,point p3) {
		
		
		pt1=p1;
		pt2=p2;
		pt3=p3;
		if (pt1.compareTo(pt2)<0) {
		//	System.out.println("compare1");
			point temp;
			temp=pt1;
			pt1=pt2;
		     pt2=temp;}
		  
		    // Insert arr[2] 
		    if (pt2.compareTo(pt3)<0) 
		    {  
		    	//System.out.println("compare2");
		    	point temp;
				temp=pt2;
				pt2=pt3;
			     pt3=temp;
		    	
		       if (pt1.compareTo(pt2)<0) {
		    	//   System.out.println("compare3");
		    	 point temp1;
				temp1=pt1;
				pt1=pt2;
			     pt2=temp1;}
		      
		    } 
		    edge1=new edge(pt1,pt2);
		       edge2=new edge(pt2,pt3);
		       edge3=new edge(pt3,pt1);
		
		commontri=new arraylist<triangle>();
	}
	public triangle() {
		// TODO Auto-generated constructor stub
	}
	public PointInterface [] triangle_coord() {
		
		float condx=(pt2.getX()-pt1.getX());
		float cond1x=(pt3.getX()-pt1.getX());
		float condy=(pt2.getY()-pt1.getY());
		float cond1y=(pt3.getY()-pt1.getY());
		float condz=(pt2.getZ()-pt1.getZ());
		float cond1z=(pt3.getZ()-pt1.getZ());
		PointInterface tr[]=null;
		if((condy*cond1z-cond1y*condz==0) && (condx*cond1z-cond1x*condz==0)&&(condx*cond1y-cond1y*condx==0)) {
			
		}
	/*	double length1=edge1.lengthofedge();
		double length2=edge2.lengthofedge();
		double length3=edge3.lengthofedge();
		
		
	    if(length1+length2>length3 && length3+length2>length1 && length1+length3>length2) {
		 
	     
	    }*/
		else {
			tr[0]=pt1;
		     tr[1]=pt2;
		     tr[2]=pt3;
		}
	    return tr;
	}
	public int adjacenttriangle(triangle tr) {
	/*	edge edge1=new edge(pt1,pt2);
		edge edge2=new edge(pt2,pt3);
		edge edge3=new edge(pt3,pt1);
		edge edge1tr=new edge(tr.pt1,tr.pt2);
		edge edge2tr=new edge(tr.pt2,tr.pt3);
		edge edge3tr=new edge(tr.pt3,tr.pt1);*/
		if(edge1.equalto(tr.edge1)==0 || edge1.equalto(tr.edge2)==0 || edge1.equalto(tr.edge3)==0 ) {
			return 0;
		}
		if(edge2.equalto(tr.edge1)==0 || edge2.equalto(tr.edge2)==0 || edge2.equalto(tr.edge3)==0) {
			return 0;
		}
		if(edge3.equalto(tr.edge1)==0 || edge3.equalto(tr.edge2)==0 || edge3.equalto(tr.edge3)==0) {
			return 0;
		}
		
		return 1;
	}
	public int equaltriangle(triangle tr) {
		
		if(pt1.equal(tr.pt1)==0 && pt2.equal(tr.pt2)==0 && pt3.equal(pt3)==0){
			return 0;
		}
		if(pt1.equal(tr.pt1)==0 && pt2.equal(tr.pt3)==0 && pt3.equal(pt2)==0){
			return 0;
		}
		if(pt1.equal(tr.pt2)==0 && pt2.equal(tr.pt1)==0 && pt3.equal(pt3)==0){
			return 0;
		}
		if(pt1.equal(tr.pt2)==0 && pt2.equal(tr.pt3)==0 && pt3.equal(pt1)==0){
			return 0;
		}
		if(pt1.equal(tr.pt3)==0 && pt2.equal(tr.pt1)==0 && pt3.equal(pt2)==0){
			return 0;
		}
		if(pt1.equal(tr.pt3)==0 && pt2.equal(tr.pt2)==0 && pt3.equal(pt1)==0){
			return 0;
		}
		return 1;
	}
	public int compareTo(triangle tr) {
		
		if(pt1.equal(tr.pt1)!=0) {
			if(pt1.compareTo(tr.pt1)>0) {
				return -1;
			}
			else {
				return 1;
			}
		}
		else {
			if(pt2.equal(tr.pt2)!=0) {
				if(pt2.compareTo(tr.pt2)>0) {
					return -1;
				}
				else {
					return 1;
				}
			}
			else {
				if(pt3.equal(tr.pt3)!=0) {
					if(pt3.compareTo(tr.pt3)>0) {
						return -1;
					}
					else {
						return 1;
					}
				}
			}
		}
		
		 
		 
			
			
				
		
		 return 0;
	}
	public point centroid() {
		float x=pt1.x + pt2.x +pt3.x;
		float y=pt1.y + pt2.y +pt3.y;
		float z=pt1.z + pt2.z +pt3.z;
		point pt=new point(x/3,y/3,z/3);
		return pt;
	}
	
}
