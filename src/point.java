
public class point implements PointInterface,Comparable<point>{
	public float x;
	public float y;
	public float z;
	public arraylist<triangle> cmntriangle;
	public arraylist<point> cmnpts=new arraylist<point>();;
	public point temppts;
	public point(float x,float y,float z) {
		this.x=x;
		this.y=y;
		this.z=z;
		cmntriangle=new arraylist<triangle>();
		
		
	}
	public float getX() {
		return x;
	}
	
	public float getY() {
		   return y;
	   }
	public  float getZ() {
		   return z;
	   }
	 public  float [] getXYZcoordinate() {
		   float temp[]=null;
		   temp[0]=x;
		   temp[1]=y;
		   temp[2]=z;
		   return temp;
	   }
	 public int equal(point p) {
		 int count=0;
		 if(x==p.getX() && y==p.getY() && z==p.getZ()) {
			 return count;
		 }
		 else {
			 count=1;
			 return count;
		 }
		 
	 }
	 public int compareTo(point p) {
		 
		 if(x==p.x && y==p.y && z==p.z) {
			 return 0;
		 }
		 if(x>p.getX()) {
			 return -1;
			 
		 }
		 else if(x<p.getX()) {
			 return 1;
		 }
		 else if(x==p.getX()) {
			 if(y>p.getY()) {
				 return -1;
				 
			 }
			 else if(y<p.getY()) {
				 return 1;
			 }
			 else if(y==p.getY()) {
				 if(z>p.getZ()) {
					 return -1;
					 
				 }
				 else if(z<p.getZ()) {
					 return 1;
				 }
				 else if(z==p.getZ()) {
					 return 0;
				 }
			 }
		 }
		 return 0;
		 
	 }
	 public String toString() {
			return Float.toString(x);
		}
	 public double distance(point p) {
		 double f1=	p.getX()-x;
		  double f2=	p.getY()-y;
		  double f3=	p.getZ()-z;
		  double d = f1*f1 + f2*f2 + f3*f3;
		  return d;
	 }
}
