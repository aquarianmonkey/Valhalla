package com.berns.model.shapes;

public class Rectangle
{
	private Point leftLowerPt;
	private Point leftUpperPt;
	private Point rightLowerPt;
	private Point rightUpperPt;
	
	public Rectangle(Point leftLowerPt, Point rightUpperPt)
	{
		this.leftLowerPt = leftLowerPt;
		this.rightUpperPt = rightUpperPt;
		this.leftUpperPt = new Point(leftLowerPt.x(), rightUpperPt.y());
		this.rightLowerPt = new Point(rightUpperPt.x(), leftLowerPt.y());
	}
	
	public int area(){
		
		int length = leftUpperPt.y() - leftLowerPt.y();
		int width = rightLowerPt.x() - leftLowerPt.x();
		
		return length * width;
	}
	
	public static void main(String[] args)
	{
		Rectangle box1 = new Rectangle(new Point(-4,1), new Point(2,6));
		System.out.println(box1);
		System.out.println("Area = " + box1.area());

		Rectangle box2 = new Rectangle(new Point(1,-1), new Point(5,3));
		System.out.println(box2);
		System.out.println("Area = " + box2.area());
		
		Rectangle box3 = new Rectangle(new Point(-5,-5), new Point(-1,-2));
		System.out.println(box3);
		System.out.println("Area = " + box3.area());
		
	}

	@Override
	public String toString()
	{
		return "Rectangle [leftLowerPt=" + leftLowerPt + ", leftUpperPt=" + leftUpperPt + ", rightLowerPt="
				+ rightLowerPt + ", rightUpperPt=" + rightUpperPt + "]";
	}

}
