
public class edge implements EdgeInterface,Comparable<edge>{
	public point pt1;
	public point pt2;
	public int counter=1;
	public arraylist<triangle> mytriangles;
	public edge( point  pt1, point  pt2){
		this.pt1=pt1;
		this.pt2=pt2;
		mytriangles=new arraylist<triangle>();
	}
	public edge() {
		mytriangles=new arraylist<triangle>();
		
	}
	public PointInterface [] edgeEndPoints() {
		PointInterface edge[]=null;
		edge[0]=pt1;
		edge[1]=pt2;
		return edge;
	}
	public double lengthofedge() {
	  double f1=	pt1.getX()-pt2.getX();
	  double f2=	pt1.getY()-pt2.getY();
	  double f3=	pt1.getZ()-pt2.getZ();
	  double d = f1*f1 + f2*f2 + f3*f3;
	  return d;
	}
	public int compareTo(edge edge) {
		int count=0;
		if(lengthofedge()>edge.lengthofedge()) {
			count=-1;
			return count;
		}
		else if(lengthofedge()<edge.lengthofedge()) {
			count=1;
			return count;
		}
		else if(lengthofedge()==edge.lengthofedge()) {
			if(equalto(edge)!=0) {
				count=-1;
				return count;
			}
		}
		return count;
		
	}
	public int equalto(edge edge) {
		int count=0;
		if(pt1.equal(edge.pt1)==0 && pt2.equal(edge.pt2)==0) {
			return count;
		}
		else if(pt1.equal(edge.pt2)==0 && pt2.equal(edge.pt1)==0) {
			return count;
		}
		else {
			count=1;
			return count;
		}}
	public String toString(edge edge) {
		String str= String.valueOf(edge.pt1.x);
		return str;
	}
	public void print() {
		   System.out.println(pt1.x);
		   System.out.println(pt2.x);
		   System.out.println(counter);
		  
		   
		}
}
