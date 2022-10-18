package com.berns.model.shapes;

public class TestBox
{
    public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S)
    {
        int areaA = (M-K)*(N-L);
        System.out.println("Area X : " + areaA);
        int areaB = (R-P)*(S-Q);
        System.out.println("Area Y : " + areaB);
        int areaOverlap = 0;

        if((M>=P)&&(S>=L)) {
            int x1 = (K - P) > 0 ? (K - P) : 0;
            int x2 = (M - R) > 0 ? (M - R) : 0;
            int x_overlap = (M - P) - x1 - x2;
            System.out.println(x_overlap);

            int y1 = (S - N) > 0 ? (S - N) : 0;
            int y2 = (Q - L) > 0 ? (Q - L) : 0;
            int y_overlap = (S - L) - y1 - y2;
            System.out.println(y_overlap);

            areaOverlap = x_overlap * y_overlap;
            System.out.println("Overlap : " + areaOverlap);
        }
        return (areaA + areaB - areaOverlap);
    }

    
    public static void main(String [] args)
    {
//        System.out.println("Case 1: "  + solution(-4,1,2,6,0,-1,4,3));
//          System.out.println("Case 2: "  + solution(-4,1,2,6,0,-1,4,7));
        //System.out.println("Case 3A: "  + solution(-4,1,2,6,-5,-1,4,3));
//        System.out.println("Case 4 (B is inside A): "  + solution(-4,1,2,6,0,2,2,3));
//        System.out.println("Case 5 (A is inside B): "  + solution(2,1,2,2,0,-1,4,3));
//    	System.out.println("Case 3: "  + solution(-4,1,2,6,-10,-3,-7,3));
    	System.out.println("Case 3: "  + solution(1,1,7,6,3,4,6,8));
    }

    

}
