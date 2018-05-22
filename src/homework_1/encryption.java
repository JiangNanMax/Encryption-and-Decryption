package homework_1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;

public class encryption extends JFrame{
	public final int DEFAULT_WIDTH = 600;
	public final int DEFAULT_HEIGHT = 620;
	
	public encryption() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screensize=tk.getScreenSize();
		int w=(screensize.width - DEFAULT_WIDTH)>>1;
		int h=(screensize.height - DEFAULT_HEIGHT)>>1;
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		this.setLocation(w, h);
		this.setTitle("明文加密");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel jlabel1=new JLabel();
		JLabel jlabel2=new JLabel();
		JTextField jtextfield1=new JTextField();
		JTextField jtextfield2=new JTextField();
		JButton btn_1=new JButton("加密");
		JButton btn_2=new JButton("返回");
		jlabel1.setText("明文：");
		jlabel2.setText("密钥：");
		jtextfield1.setText("");
		jtextfield2.setText("");
		
		Container c=this.getContentPane();
		GroupLayout layout=new GroupLayout(c);
		c.setLayout(layout);
		
		layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(170)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            //.addComponent(btn_1)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addComponent(jlabel2)
	                                    .addComponent(jlabel1))
	                                .addGap(18, 18, 18)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                	   .addComponent(btn_1)
	                                    .addComponent(jtextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jtextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(btn_2)))
	                .addContainerGap(200, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(150)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jlabel1)
	                    .addComponent(jtextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(10)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jlabel2)
	                    .addComponent(jtextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(31, 31, 31)
	                .addComponent(btn_1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
	                .addComponent(btn_2)
	                .addContainerGap())
	        );
		
		
		
		btn_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag=0;
				if(jtextfield1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入明文!");
					flag=1;
				}
				else if(jtextfield2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入密钥!");
					flag=1;
				}
				
				if(flag==0) {
					int flag1=0;
					int flag2=0;
					String str1=jtextfield1.getText();
					for(int i=0;i<str1.length();i++) {
						if((str1.charAt(i)>='A' && str1.charAt(i)<='Z') || (str1.charAt(i)>='a' && str1.charAt(i)<='z') || (str1.charAt(i) == ' ')) {
							continue;
						}
						else {
							//JOptionPane.showMessageDialog(null, "明文中只允许有大小写字母!");
							flag1=1;
						}
					}
					
					String str2=jtextfield2.getText();
					for(int i=0;i<str2.length();i++) {
						if((str2.charAt(i)>='A' && str2.charAt(i)<='Z') || (str2.charAt(i)>='a' && str2.charAt(i)<='z')) {
							continue;
						}
						else {
							//JOptionPane.showMessageDialog(null, "密钥中只允许有大小写字母!");
							flag2=1;
						}
					}
					
					if(flag1==1) {
						JOptionPane.showMessageDialog(null, "明文中只允许有大小写字母和空格!");
					}
					else if(flag2==1) {
						JOptionPane.showMessageDialog(null, "密钥中只允许有大小写字母!");
					}
					else {
						String s1=jtextfield1.getText();
						String s2=jtextfield2.getText();
						encryption_solve en=new encryption_solve(s1,s2);
						en.setVisible(true);
						setDefaultCloseOperation(EXIT_ON_CLOSE);
						setVisible(false);
					}
				}
			}
			
		});
		btn_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startpage s=new startpage();
				s.setVisible(true);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setVisible(false);
			}
			
		});
		
	}
}
