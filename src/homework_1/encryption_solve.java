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
import javax.swing.WindowConstants;

public class encryption_solve extends JFrame{
	public final int DEFAULT_WIDTH = 600;
	public final int DEFAULT_HEIGHT = 620;
	
	public static int GetNum(double num1,double num2){
		int s=(int)num1+(int)(Math.random()*(num2-num1));
		return s;
	}
	
	public static String solve(String from, int index) {
		from = reChange(from);
		String first = reChange(from.substring(0, from.length() - index));
		System.out.println(first);
		String second = reChange(from.substring(from.length() - index));
		System.out.println(second);
		from = first + second;
		return from;
	}

	public static String reChange(String from) {
		char[] froms = from.toCharArray();
		for (int i = 0; i < from.length() / 2; i++) {
			char temp = froms[i];
			froms[i] = froms[froms.length - 1 - i];
			froms[froms.length - 1 - i] = temp;
		}
		return String.valueOf(froms);
	}

	
	public encryption_solve(String s1,String s2){
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screensize=tk.getScreenSize();
		int w=(screensize.width-DEFAULT_WIDTH)>>1;
		int h=(screensize.height-DEFAULT_HEIGHT)>>1;
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setLocation(w, h);
		this.setTitle("加密结果");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		String abc="abcdefghijklmnopqrstuvwxyz";
		String tmp="";
		for(int i=0;i<s2.length();i++) {
			if(tmp.indexOf(s2.charAt(i)) ==-1 ) {
				tmp+=s2.charAt(i);
			}
		}
		for(int i=0;i<abc.length();i++) {
			if(tmp.indexOf(abc.charAt(i)) ==-1 ) {
				tmp+=abc.charAt(i);
			}
		}
		
		char []cc={'@','#','$','%','^','&','*','(',')','_'};
		
		String re="";
		for(int i=0;i<s1.length();i++) {
			char c=s1.charAt(i);
			if(c==' ') {
				int ran=GetNum(0,9);
				re+=cc[ran];
			}
			else {
				int k=c-'a';
				re+=tmp.charAt(k);
			}
		}
		
		String re_1=solve(re,re.length()/2);
		
		JLabel jlabel=new JLabel(re_1);
		JButton btn=new JButton("确定");
		
		Container c=this.getContentPane();
		GroupLayout layout=new GroupLayout(c);
		c.setLayout(layout);
		
		layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240)
                        .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250)
                        .addComponent(btn)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150)
                .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60)
                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				encryption en=new encryption();
				en.setVisible(true);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setVisible(false);
			}
			
		});
	}
}
