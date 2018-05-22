package homework_1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;

public class startpage extends JFrame{
	public final int DEFAULT_WIDTH = 600;
	public final int DEFAULT_HEIGHT = 620;
	
	public startpage() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screensize=tk.getScreenSize();
		int w=(screensize.width - DEFAULT_WIDTH)>>1;
		int h=(screensize.height - DEFAULT_HEIGHT)>>1;
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		this.setLocation(w, h);
		this.setTitle("首页");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton btn_1=new JButton("加密");
		JButton btn_2=new JButton("解密");
		JButton btn_3=new JButton("退出");
		
		Container c=this.getContentPane();
		GroupLayout layout=new GroupLayout(c);
		c.setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
					.addGroup(GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING,false)
									.addComponent(btn_1,GroupLayout.DEFAULT_SIZE,160,Short.MAX_VALUE)
									.addComponent(btn_2,GroupLayout.DEFAULT_SIZE,160,Short.MAX_VALUE)
							)
							.addGap(220)
					)
					.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_3)
							.addContainerGap(GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
					)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addGap(150)
							.addComponent(btn_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(btn_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(250)
							.addComponent(btn_3)
							.addContainerGap()
					)
		);
		
		
		btn_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				encryption en=new encryption();
				en.setVisible(true);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setVisible(false);
			}
			
		});
		
		btn_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				decryption de=new decryption();
				de.setVisible(true);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setVisible(false);
			}
			
		});
		
		btn_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=JOptionPane.showConfirmDialog(null, "确定退出？","",JOptionPane.YES_NO_OPTION);
				if(i==0)
					System.exit(0);
			}
			
		});
		
	}

}
