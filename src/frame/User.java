package frame;

import javax.swing.JFrame;



public class User extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1000;

	public User()
	{
		this.setTitle("我的资料");
		this.setSize(250, 450);
		this.setLocation(300, 240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setVisible(true);
		

	}

}
