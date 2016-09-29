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


public class Linesize implements MouseMotionListener,ActionListener
{

	
	private JDialog dia;
	private JPanel panel;
	private JSlider sline;
	private JLabel lab;
	private JButton ok;
    static int x;//记录字体大小
    private int n;//记录滑块的值
	public void chuangjian(JFrame x)
	{
		dia=new JDialog(x,true);
		panel=new JPanel();
		sline=new JSlider();
        sline.setValue(1);
        sline.setMinimum(1);
        sline.setMaximum(100);
		lab=new JLabel("1");
		ok=new JButton("确定");
	}
	public void zuzhuang()
	{
		panel.setLayout(null);
		sline.setBounds(0,10,130,30);
		lab.setBounds(0,50,60,30);
		ok.setBounds(0,90,60,30);
		panel.add(sline);
		panel.add(lab);
		panel.add(ok);
		dia.add(panel);
	}
	public void zhuce()
	{
		sline.addMouseMotionListener(this);
		ok.addActionListener(this);
	}
	public void xianshi()
	{
		dia.setSize(150,150);
		dia.setVisible(true);
	}
	public Linesize(JFrame x)
	{
		this.chuangjian(x);
		this.zuzhuang();
		this.zhuce();
	}
	public void actionPerformed(ActionEvent e) {
		
		Object o=e.getSource();
		if(o==ok)
		{   x=n;
			dia.setVisible(false);
		}
	}

	
	public void mouseDragged(MouseEvent e) {
		n=sline.getValue();
		lab.setText(""+n);
		
		
	}

	
	public void mouseMoved(MouseEvent e) {
		
		
	}

}
