package frame;

import java.awt.*;

public class LoginFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginFrame()
	{
		this.setTitle("User Login");
		this.setBackground(Color.gray);
		this.setSize(250, 300);
		this.setLocation(100, 100);
		this.setLayout(new FlowLayout());
		this.add(new Label("用户名"));
		this.add(new TextField("shenshaowei",20));
		this.add(new Label("密    码"));
		this.add(new TextField(20));
		this.add(new Button("登录"));
		this.add(new Button("取消"));
		
		this.setVisible(true);
	}
	
	public static void main(String arg[])
	{
		new LoginFrame();
	}

}
