//"C:\Program Files (x86)\Java\jdk1.7.0_55\bin"
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.Random;

public class Panel extends JPanel implements MouseListener{
 Timer gameLoop;
 boolean odd = true;
 boolean collide = false;
 double inVelX, inVelY;
 Random rand = new Random();
 int x,y;
 int turnLength = 100;
 double XDir,YDir;
 double force = .05;
 Sprite ship = new Sprite(500,500,0,0,turnLength);
	public Panel(){
		//System.out.println("Start");

		gameLoop = new Timer(5, new GameLoop());

	}
	public void paintComponent(Graphics g){
    super.paintComponent(g);
    ship.paint(g,this);
	}
	void gravity(){
			double YDist=0;
			double XDist=0;
			double Dist=0;
			double force2=0;
			double xforce=0;
			double yforce=0;
			/*for(int n = 0; n<particle.length; n++){
				if(n!=i){
					YDist = particle[n].getY() - particle[i].getY();
					XDist = particle[n].getX() - particle[i].getX();
					Dist = Math.sqrt(Math.pow(YDist, 2)+(Math.pow(XDist, 2)));
					force2 = force/(Math.pow(Dist, 1));
					xforce += force2*XDist/Dist;
					yforce += force2*YDist/Dist;
				}
				particle[i].setXDir(xforce);
				particle[i].setYDir(yforce);
			}*/

		}
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    /* Empty method definition. */
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    /* Empty method definition. */
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    /* Empty method definition. */
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
      if(ship.startTurn(e.getX(),e.getY()))
        gameLoop.start();
    }

	class GameLoop implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ship.move();
			repaint();
      if(!ship.go)
        gameLoop.stop();
		}
  }
}
