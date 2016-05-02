package robotStuff;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class RobotTest {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		Robot x = new Robot();
		for(int i = 0; i < 10000; i++)
		{
		Point y = MouseInfo.getPointerInfo().getLocation();
		System.out.println("X: " + y.x + "\tY: " + y.y);
		}
	}

}
//X: 218 Y: 879              X: 351 Y: 762              X: 397 Y: 304      
