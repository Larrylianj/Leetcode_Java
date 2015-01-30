
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point0 = new Point(0,0);
		Point point1 = new Point(1,1);
		Point point2 = new Point(1,-1);
//		Point point3 = new Point(2,3);
//		Point point4 = new Point(3,1);
//		Point point5 = new Point(4,0);
//		Point point6 = new Point(3,5);
//		Point point7 = new Point(4,4);
//		Point point8 = new Point(4,5);
//		Point[] points = {point0,point1,point2,point3,point4,point5,point6,point7,point8};
		Point[] points = {point0,point1,point2};
		System.out.println(maxPoints(points));
	}
    
    // 2nd trail, more concise
    static final double zero = 0.0001;
    public int maxPoints(Point[] points) {
        // O(n^3)
        int max = 1;
        for(int i = 0;i < points.length-1;i++){
            for(int j = i+1;j < points.length;j++){
                int count = 0;
                // case 1: no y parallel
                if(points[i].x!=points[j].x){
                    double k = (points[i].y - points[j].y)/(double)(points[i].x-points[j].x);
                    double b = (double)points[i].y - k*points[i].x;
                    for(int t = 0;t < points.length;t++){
                        if(Math.abs(k*points[t].x+b-points[t].y) < zero)
                            count++;
                    }
                    max = Math.max(max, count);
                }else{ // case 2: parallel to y axis
                    for(int t = 0;t < points.length;t++){
                        if(points[t].x == points[i].x)
                            count++;
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return points.length==0?0:max;
    }
	
//	static public int maxPoints(Point[] points) {
//        int len = points.length;
//        int i,j,u;
//        int count,max;
//        double k,b,threshold;
//        boolean flag;
//        threshold = 0.01;
//        flag = false;
//        max = 2;
//        if(len < 3){
//        	return len;
//        }
//        for(i = 0; i < len -1;i++){
//        	for(j = i+1;j < len; j++){
//        		
//        		count = 2;
//        		if(points[i].x == points[j].x && points[i].y == points[j].y){
//        			
//        		}else{
//        			flag = true;
//        			if(points[i].x == points[j].x){
//            			// use x axis to define a line
//            			for(u = 0;u < len;u++){
//            				if(u != i && u != j){
//            					if(points[u].x == points[i].x){
//            						count++;
//            					}
//            				}
//            			}
//                  		if(count > max){
//                			max = count;
//                		}
//            		}else if(points[i].y == points[j].y){
//            			// use y axis to define a line
//            			for(u = 0;u < len;u++){
//            				if(u != i && u != j){
//            					if(points[u].y == points[i].y){
//            						count++;
//            					}
//            				}
//            			}
//                  		if(count > max){
//                			max = count;
//                		}
//            		}else{
//            			// use k and b to define a line
//                		k = ((double)(points[i].y - points[j].y))/((double)(points[i].x - points[j].x));
//                		b = (double)points[i].y - k * (double)points[i].x;
//                		
//                		for(u = 0;u < len;u++){
//                			if(u != i && u != j){
//                				if(Math.abs((k * points[u].x + b) - (double)points[u].y) <= threshold){
//                					count++;
//                				}
//                			}
//                		}
//                  		if(count > max){
//                			max = count;
//                		}
//            		}
//        		}
//        		
//        	}
//        }
//        if(flag == true){
//        	return max;
//        }else{
//        	return len;
//        }
//		
//    }

}
