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
		this.add(new Label("�û���"));
		this.add(new TextField("shenshaowei",20));
		this.add(new Label("��    ��"));
		this.add(new TextField(20));
		this.add(new Button("��¼"));
		this.add(new Button("ȡ��"));
		
		this.setVisible(true);
	}
	
	public static void main(String arg[])
	{
		new LoginFrame();
	}

}
