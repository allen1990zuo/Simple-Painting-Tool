import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import java.io.File;
import java.io.IOException;


public class Jiemian implements ActionListener,MouseListener,MouseMotionListener
{

	private JFrame frame;
	private JPanel panelmain;
	private Panelx panelcenter;
	private JCheckBox fill;
	private ButtonGroup group;
	private JToolBar tool;
	private JToggleButton oval;
	private JToggleButton rect;
	private JToggleButton line;
	private BufferedImage image;
	private JToggleButton color;
	private Graphics gimage;
	private int x1,y1,x2,y2,x3,y3;
	private char shape;
	private int n;//填充为1，不填为0
	private Tiaoseban tsb;
	private JToggleButton size;
	private Linesize ls;
	private Easer er;
	private Pen pensil;
	private JMenu menu;
	private JMenu edit;
	private JMenuBar menubar;
	private JMenu set;
	private JMenuItem file;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem exit;
	private JMenuItem colmenu;
	private JMenuItem sizemenu;
	private JFileChooser jfc;
	private JToggleButton easer;
	private JToggleButton pen;
	public void caidan()
	{
		menubar=new JMenuBar();
		menu=new JMenu("菜单(C)");
		edit=new JMenu("编辑(E)");
		set=new JMenu("设置(S)");
		file=new JMenuItem("新建");
		open=new JMenuItem("打开");
		save=new JMenuItem("保存");
		exit=new JMenuItem("退出");
		colmenu=new JMenuItem("颜色");
		sizemenu=new JMenuItem("粗细");
		menu.add(file);
		menu.addSeparator();
		menu.add(open);
		menu.addSeparator();
		menu.add(save);
		menu.addSeparator();
		menu.add(exit);
		edit.add(set);
		set.add(colmenu);
		menu.addSeparator();
		set.add(sizemenu);
		file.setPreferredSize(new Dimension(100,20));
		set.setPreferredSize(new Dimension(100,20));
		colmenu.setPreferredSize(new Dimension(100,20));
		menubar.add(menu);
		menubar.add(edit);
		KeyStroke ksfile=KeyStroke.getKeyStroke('F',InputEvent.CTRL_MASK);
		KeyStroke ksopen=KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK);
		KeyStroke kssave=KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK);
		KeyStroke ksexit = KeyStroke.getKeyStroke('Q', InputEvent.CTRL_MASK);
		KeyStroke ksopen1= KeyStroke.getKeyStroke(KeyEvent.VK_F6,InputEvent.CTRL_MASK);
		KeyStroke kscol = KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK);
		KeyStroke kssize = KeyStroke.getKeyStroke(KeyEvent.VK_F11, InputEvent.CTRL_MASK);
		file.setAccelerator(ksfile);
		open.setAccelerator(ksopen1);
		save.setAccelerator(kssave);
		exit.setAccelerator(ksexit);
		colmenu.setAccelerator(kscol);
		sizemenu.setAccelerator(kssize);
		menu.setMnemonic('C');
		edit.setMnemonic('E');
		set.setMnemonic('S');
	}
	public void chuangjianpaper()
	{
		image=new BufferedImage(650,750,BufferedImage.TYPE_INT_RGB);
		gimage=image.getGraphics();
		gimage.setColor(Color.white);
		gimage.fillRect(0, 0, 650, 750);
		gimage.setColor(Color.black);
		panelcenter.paper(image);
	}
	public void chuangjian()
	{
		frame=new JFrame();
		jfc=new JFileChooser();
		panelmain=new JPanel();
		panelcenter=new Panelx();
		tool=new JToolBar();
		line=new JToggleButton("直线");
		rect=new JToggleButton("矩形");
		oval=new JToggleButton("圆");
		fill=new JCheckBox("填充");
		color=new JToggleButton("颜色");
		size=new JToggleButton("粗细");
		easer=new JToggleButton("橡皮");
		pen=new JToggleButton("铅笔");
		group=new ButtonGroup();
		
		tsb=new Tiaoseban(frame);
		ls=new Linesize(frame);
		er=new Easer(frame);
		pensil=new Pen(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void zuzhuang()
	{
		panelmain.setLayout(new BorderLayout());
		panelmain.add(tool,BorderLayout.WEST);
		panelmain.add(panelcenter);
		Dimension ds=new Dimension(120,1);
		tool.setPreferredSize(ds);
		tool.setLayout(null);
		group.add(line);
		group.add(oval);
		group.add(rect);
		group.add(color);
		group.add(size);
		group.add(easer);
		group.add(pen);
		tool.add(line);
		tool.add(oval);
		tool.add(rect);
		tool.add(fill);
		tool.add(color);
		tool.add(size);
		tool.add(easer);
		tool.add(pen);
		line.setBounds(0,20,60,30);
		rect.setBounds(60,20,60,30);
		oval.setBounds(0,50,60,30);
		fill.setBounds(60,50,60,30);
		color.setBounds(0,80,60,30);
		size.setBounds(60,80,60,30);
		easer.setBounds(0,110,60,30);
		pen.setBounds(60,110,60,30);
	    frame.setJMenuBar(menubar);
		frame.add(panelmain);
	}
	public void zhuce()
	{
		line.addActionListener(this);
		rect.addActionListener(this);
		oval.addActionListener(this);
		fill.addActionListener(this);
		color.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		colmenu.addActionListener(this);
		sizemenu.addActionListener(this);
		file.addActionListener(this);
		size.addActionListener(this);
		easer.addActionListener(this);
		pen.addActionListener(this);
		panelcenter.addMouseListener(this);
		panelcenter.addMouseMotionListener(this);
	}
	public void xianshi()
	{
		frame.setVisible(true);
		frame.setSize(800,800);
	}
	public Jiemian()
	{
		this.chuangjian();
		this.chuangjianpaper();
		this.caidan();
		this.zuzhuang();
		this.zhuce();
		this.xianshi();
		
	}
	public static void main(String[] args) {
		new Jiemian();

	}
	
	public void mouseDragged(MouseEvent e) 
	{
		Object o=e.getSource();
		Graphics2D gd=(Graphics2D)gimage;	
		if(o==panelcenter)
		{
			x2=e.getX();
			y2=e.getY();
			panelcenter.get(x1, y1, x2, y2,n,shape);	
		}
		 if(shape=='p')
		 {
			 x2=e.getX();
			 y2=e.getY();
			 
			 BasicStroke bs1=new BasicStroke(Pen.n);
			 Stroke s1=(Stroke)bs1;
			 gd.setStroke(s1);
			 gimage.setColor(Tiaoseban.col);
			 gimage.drawLine(x1, y1, x2, y2);
			 x1=x2;
			 y1=y2;
		 }
		 if(shape=='e')
		   {
				x2=e.getX();
				y2=e.getY();
			    BasicStroke bs1=new BasicStroke(Easer.n);
				Stroke s1=(Stroke)bs1;
				gd.setStroke(s1);
				gimage.setColor(Color.WHITE);
				gimage.drawLine(x1, y1, x2, y2);
				x1=x2;
				y1=y2;
		   }
		 panelcenter.repaint();
		
	}
	
	public void mouseMoved(MouseEvent e) {
		
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
		
			
	}

	public void mousePressed(MouseEvent e) 
	{
		Object o=e.getSource();
//		Panelx.flag=1;
		if(o==panelcenter)
		{
			x1=e.getX();
			y1=e.getY();
			
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
//		Panelx.flag=0;
		x3=e.getX();
		y3=e.getY();
		x2=x3;
		y2=y3;
		int x,y;
		Graphics2D gd=(Graphics2D)gimage;
		BasicStroke bs=new BasicStroke(Linesize.x);
		Stroke s=(Stroke)bs;
		gd.setStroke(s);
		gimage.setColor(Tiaoseban.col);
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
			   gimage.drawLine(x1, y1, x2, y2);
		   }
		   if(shape=='r'&&n==0)
		   {
			   gimage.drawRect(x, y, Math.abs(x1-x2), Math.abs(y1-y2));
		   }
		   if(shape=='o'&&n==0)
		   {
			   gimage.drawOval(x, y, Math.abs(x1-x2), Math.abs(y1-y2));
		   }
		   if(shape=='r'&&n==1)
		   {
			   gimage.fillRect(x, y, Math.abs(x1-x2), Math.abs(y1-y2));
		   }
		   if(shape=='o'&&n==1)
		   {
			   gimage.fillOval(x, y, Math.abs(x1-x2), Math.abs(y1-y2));
		   }
		   
		   
	}
	
	public void mouseEntered(MouseEvent e) {
		
		
	}
	
	public void mouseExited(MouseEvent e) {
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		Object o=e.getSource();
		if(o==line)
		{
			fill.setEnabled(false);
			shape='l';
		}
		if(o==rect)
		{
			fill.setEnabled(true);
			shape='r';
		}
		if(o==oval)
		{
			fill.setEnabled(true);
			shape='o';
		}
		if(o==fill)
		{
			if(fill.isSelected()==true)
			{
				n=1;
			}
			else
			{
				n=0;
			}
		}
		if(o==color)
		{
			tsb.xianshi();
		}
		if(o==size)
		{
			ls.xianshi();
		}
		if(o==easer)
		{
			er.xianshi();
			shape='e';
			
		}
		if(o==pen)
		{
			pensil.xianshi();
			shape='p';
		}
		if(o==open)
		{
			jfc.showOpenDialog(frame);
			File file = jfc.getSelectedFile();
			try {
				BufferedImage image1=ImageIO.read(file);
				panelcenter.paper(image1);
				gimage=image1.getGraphics();
				gimage.setColor(Color.BLACK);
				gimage.setColor(Tiaoseban.col);
				Graphics2D gd=(Graphics2D)gimage;
				BasicStroke bs=new BasicStroke(Linesize.x);
				Stroke s=(Stroke)bs;
				gd.setStroke(s);
				panelcenter.repaint();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o==exit)
		{
			System.exit(0);
		}
		if(o==save)
		{
			jfc.showSaveDialog(frame);
		
		    File file = jfc.getSelectedFile();
		    try {
				ImageIO.write(image, "jpg", file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		}
		if(o==colmenu)
		{
			tsb.xianshi();
		}
		if(o==sizemenu)
		{
			ls.xianshi();
		}
		if(o==file)
		{
			shape='f';
			image=new BufferedImage(650,750,BufferedImage.TYPE_INT_RGB);
			gimage=image.getGraphics();
			gimage.setColor(Color.white);
			gimage.fillRect(0, 0, 650, 750);
			gimage.setColor(Color.black);
			panelcenter.paper(image);
			gimage=image.getGraphics();
			gimage.setColor(Color.BLACK);
			gimage.setColor(Tiaoseban.col);
			Graphics2D gd=(Graphics2D)gimage;
			BasicStroke bs=new BasicStroke(Linesize.x);
			Stroke s=(Stroke)bs;
			gd.setStroke(s);
			x1=0;
			x2=0;
			y1=0;
			y2=0;
			panelcenter.get(x1, y1, x2, y2, n, shape);
			panelcenter.repaint();
			
		}
	}

}
