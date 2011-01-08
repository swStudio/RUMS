package activities;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import users.Register;


public class Activity extends JDialog implements ItemListener,ActionListener{
	private int actId;
	private String title;
	private String content;
	private Date date;
	private String place;
	private int number;
	
	JPanel panel = new JPanel();
	JLabel _actid = new JLabel("活动编号：");
	JLabel _title = new JLabel("         主题：");
	JLabel _content = new JLabel("主要内容：");
	JLabel _date = new JLabel("活动时间：");
	JLabel _place = new JLabel("活动地点：");
	JLabel numberOf = new JLabel("活动人数：");
	
	Container container;

	public Activity() {
		
		JFrame mainFrame = new JFrame("活动面板");
		
		panel.setLayout(new FlowLayout());
		
		panel.add(_actid);
		panel.add(_title);
		panel.add(_content);
		panel.add(_date);
		panel.add(_place);
		panel.add(numberOf);
		
		mainFrame.add(panel);
		mainFrame.setLocation(500, 250);
		mainFrame.setVisible(true);
		
		//container.add(panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
    public static void main(String[] args) throws Exception {
		Activity activity = new Activity();
	
		activity.setBounds(500, 250, 240, 380);
		activity.setVisible(true);
	}
}
