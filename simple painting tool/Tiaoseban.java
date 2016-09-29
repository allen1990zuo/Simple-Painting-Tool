import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;




public class Tiaoseban implements MouseMotionListener,ActionListener
{
	
   
	private JDialog dia;
	private JPanel panel;
	private JSlider sr;
	private JSlider sg;
	private JSlider sb;
	private JButton but;
	private JButton ok;
	private JLabel srl;
	private JLabel sgl;
	private JLabel sbl;
	private int r,g,b;
	static Color col;
	private Color color;//记录滑动调出的颜色
	public void chuangjian(JFrame x)
   {
	  
	  dia=new JDialog(x,true);
	  panel=new JPanel();
	  sr=new JSlider();
	  sg=new JSlider();
	  sb=new JSlider();
	  but=new JButton();
	  srl=new JLabel("red");
	  sgl=new JLabel("green");
	  sbl=new JLabel("blue");
	  ok=new JButton("确定");
	  color=new Color(0,0,0);
	  sr.setValue(0);
	  sg.setValue(0);
	  sb.setValue(0);
	  sr.setMinimum(0);
	  sg.setMinimum(0);
	  sb.setMinimum(0);
	  sr.setMaximum(255);
	  sg.setMaximum(255);
	  sb.setMaximum(255);
	  but.setBackground(color);
   }
   public void zuzhuang()
   {
	  panel.setLayout(null);
	  srl.setBounds(0,10,50,30);
	  sgl.setBounds(0,60,50,30);
	  sbl.setBounds(0,110,50,30);
	  sr.setBounds(50,10,150,30);
	  sg.setBounds(50,60,150,30);
	  sb.setBounds(50,110,150,30);
	  but.setBounds(210,10,80,80);
	  ok.setBounds(50,150,60,30);
	  panel.add(sr);
	  panel.add(sg);
	  panel.add(sb);
	  panel.add(ok);
	  panel.add(but);
	  panel.add(srl);
	  panel.add(sgl);
	  panel.add(sbl);
	  dia.add(panel); 
   }
   public void zhuce()
   {
		 sr.addMouseMotionListener(this);
		 sg.addMouseMotionListener(this);  
		 sb.addMouseMotionListener(this);  
		 ok.addActionListener(this);
   }
   public void xianshi()
  {
	  dia.setSize(300,300);
	  dia.setVisible(true);
	 
   }
   public Tiaoseban(JFrame m)
  {
	this.chuangjian(m);
	this.zuzhuang();
	this.zhuce();
	
   }

public void mouseDragged(MouseEvent e) {
	
	 r=sr.getValue();
	 g=sg.getValue();
	 b=sb.getValue();
	 color=new Color(r,g,b);
	 but.setBackground(color);
}

public void mouseMoved(MouseEvent e) {
	
	
}

public void actionPerformed(ActionEvent e) {
	Object o=e.getSource();
	if(o==ok)
	{
		
		col=color;
		dia.setVisible(false);
	}
	
}
   

}
