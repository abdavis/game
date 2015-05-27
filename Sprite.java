import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sprite {
	private int x,y;//location
	private double xspeed = 0, yspeed = 0;
	private double xp, yp;
	double xDir, yDir;//direction
	int width = 10,accelWidth=150;
	int turnLength, turnCount=0;
	int coastX, coastY;
	public boolean go=false;
	Color color = Color.BLACK;
	public Sprite(int xp, int yp, double xDir, double yDir,int turnLength){
		this.xp = xp;
		this.yp = yp;
		x = xp;
		y = yp;
		this.xDir = xDir;
		this.yDir = yDir;
		this.turnLength = turnLength;
		coastX=xp;
		coastY=yp;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public void setxDir(double xDir){
		this.xDir = xDir;
	}
	public void setyDir(double yDir){
		this.yDir = yDir;
	}
	public void setX(int x){
		this.x = x;
		xp = x;
	}
	public void setY(int y){
		this.y = y;
		yp = y;
	}
	public void setColor(Color color){
		this.color = color;
	}

	public double getXspeed(){
		return xspeed;
	}
	public double getYspeed(){
		return yspeed;
	}
	public void setXspeed(double xvelocity){
		this.xspeed = xvelocity;
	}
	public void setYspeed(double yvelocity){
		this.yspeed = yvelocity;
	}

	public void move(){
		if(go){
			xspeed+=xDir;
			yspeed+=yDir;
			xp += xspeed;
			yp += yspeed;
			turnCount++;
		}
		if(turnCount==turnLength){
			go=false;
			xDir=0;
			yDir=0;
			turnCount=0;
			coastX=x+(int)xspeed*turnLength;
			coastY=y+(int)yspeed*turnLength;
		}

		x = (int)xp;
		y = (int)yp;

	}
	public void paint(Graphics g, JPanel panel){
		if(!go){
			g.setColor(Color.BLUE);
			g.fillOval(coastX-accelWidth/2, coastY-accelWidth/2,accelWidth,accelWidth);
			g.setColor(color);
			g.fillOval(x-width/2, y-width/2,width,width);
		}
		else{
			g.setColor(color);
			g.fillOval(x-width/2, y-width/2,width,width);
		}
	}
	public boolean startTurn(int targetX, int targetY){
		double distance = Math.abs(Math.sqrt(Math.pow(targetX-coastX,2) + Math.pow(targetY-coastY,2)));
		if( distance <= accelWidth/2){
			int deltaX=targetX-x;
			int deltaY=targetY-y;

			xDir = (2*deltaX-2*xspeed*turnLength)/Math.pow(turnLength,2);
			yDir = (2*deltaY-2*yspeed*turnLength)/Math.pow(turnLength,2);
			System.out.println(" x ")
			go=true;
			return true;
		}
		return false;
	}
}
