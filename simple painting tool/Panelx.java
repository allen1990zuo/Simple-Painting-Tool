import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Panelx extends JPanel 
{
   public BufferedImage image;
   private int x1,y1,x2,y2,n;//Ω” ‹
   private char shape;
   private int x,y;
   public Color color=Color.black;
   public void get(int x,int y,int xx,int yy,int n1,char s)
   {
	   x1=x;
	   y1=y;
	   x2=xx;
	   y2=yy;
	   n=n1;
	   shape=s;
   }
   public void paper(BufferedImage x)
   {
	   image=x;
   }
   public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);
	   Graphics2D gd=(Graphics2D)g;
	   BasicStroke bs=new BasicStroke(Linesize.x);
	   Stroke s=(Stroke)bs;
	   gd.setStroke(s);
	   g.setColor(Tiaoseban.col);
	   g.drawImage(image, 0, 0, null);
	   if(x1<x2)
	   {
		   x=x1;
	   }
	   else
	   {
		   x=x2;
	   }
	   if(y1<y2)
	   {
		   y=y1;
	   }
	   else
	   {
		   y=y2;
	   }
	   if(shape=='l')
	   {
		   g.drawLine(x1, y1, x2, y2);
	   }
	   if(shape=='r'&&n==0)
	   {
		   g.drawRect(x, y, Math.abs(x1-x2), Math.abs(y1-y2));
	   }
	   if(shape=='o'&&n==0)
	   {
		   g.drawOval(x, y, Math.abs(x1-x2), Math.abs(y1-y2));
	   }
	   if(shape=='r'&&n==1)
	   {
		   g.fillRect(x, y, Math.abs(x1-x2), Math.abs(y1-y2));
	   }
	   if(shape=='o'&&n==1)
	   {
		   g.fillOval(x, y, Math.abs(x1-x2), Math.abs(y1-y2));
	   }	   
	      
   }
}
