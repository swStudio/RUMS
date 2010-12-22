package friends;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class FriendsInformation extends JFrame
{
    private JButton button1;
    private JTextArea textArea;   
    public FriendsInformation(){
    	super("显示好友类");
    	setSize(250, 800);
        
        //设置外观
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}
        //获取内容面板 
	    Container container = getContentPane();
	    //设置内容面板的布局管理器
	    container.setLayout(new FlowLayout());
	    container.setBackground(Color.YELLOW);
	    
	    //创建按钮对象
	    button1 = new JButton("好友列表>>");
	    button1.setSize(100,100);
	    button1.setFont(new Font("Serif", Font.PLAIN, 12));
	    textArea = new JTextArea("        ");
	    
	    //为组件注册监听器
	    ButtonHandler handler = new ButtonHandler();
	    button1.addActionListener(handler);
	    
	    //将各种组件添加到内容面板
	    container.add(button1);
	    container.add(textArea);
	    
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		FriendsInformation info = new FriendsInformation();
		//demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == button1)
			{
				FriendsList List = new FriendsList();
				try {
					List.output_list("08386231");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i = 0;
				String result = "";
				while (List.list != null && i < List.list.length)
				{
					result = result + List.list[i] + "\n";
					
					i++; 
				}
				textArea.setText(result + "\n");
				//System.out.println(List.string.length);
			}
		}
	}
	

}
