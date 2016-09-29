
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


public class Pen implements ActionListener,MouseMotionListener
{
  private JDialog dia;
private JSlider se;
private JLabel lab;
private JButton ok;
private JPanel panel;
static int n;
private int x;
public void chuangjian(JFrame x)
  {
	  dia=new JDialog(x,true);
	  panel=new JPanel();
	  se=new JSlider();
	  se.setValue(1);
	  se.setMinimum(1);
	  se.setMaximum(20);
	  lab=new JLabel("1");
	  ok=new JButton("È·¶¨");
  }
  public void zuzhuang()
  {
	  panel.setLayout(null);
	  se.setBounds(0,10,120,30);
	  lab.setBounds(0,40,60,30);
	  ok.setBounds(0,80,60,30);
	  panel.add(se);
	  panel.add(lab);
	  panel.add(ok);
	  dia.add(panel);
  }
  public void zhuce()
  {
	  ok.addActionListener(this);
	  se.addMouseMotionListener(this);
  }
  public void xianshi()
  {
	  dia.setSize(150,150);
	  dia.setVisible(true);
  }
  public Pen(JFrame x)
  {
	  this.chuangjian(x);
	  this.zuzhuang();
	  this.zhuce();
  }

public void actionPerformed(ActionEvent e) {
	Object o=e.getSource();
	if(o==ok)
	{
		n=x;
		dia.setVisible(false);
	}
}

public void mouseDragged(MouseEvent e) {
	
	x=se.getValue();
	lab.setText(""+x);
}

public void mouseMoved(MouseEvent e) {
	
	
}
}
