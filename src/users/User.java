package users;
/*
 * 用于存储用户信息的类
 */
public class User extends Student{

	//private Image head;
	private String nickname;
	private String motto;
	private String hobby;
	private int    birthday;
	private String email;
	private String address;
	private String telephone;
	private String password;
	
	//构造函数
	public User(String nickname,String motto,String hobby,int birthday,String email,
			String address,String telephone,String password) {
		this.nickname = nickname;
		this.motto = motto;
		this.hobby = hobby;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
		this.password = password;
	}
	
	public void SetNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public void SetMotto(String motto)
	{
		this.motto = motto;
	}
	
	public void SetHobby(String hobby)
	{
		this.hobby = hobby;
	}
	
	public void SetBirthday(int birthday)
	{
		this.birthday = birthday;
	}
	
	public void SetEmail(String email)
	{
		this.email = email;
	}
	
	public void SetAddress(String address)
	{
		this.address = address;
	}
	
	public void SetTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	
	public void SetPassword(String password)
	{
		this.password = password;
	}
	
	public String GetNickname()
	{
		return nickname;
	}
	
	public String GetMotto()
	{
		return motto;
	}
	
	public String GetHobby()
	{
		return hobby;
	}
	
	public int GetBirthday()
	{
		return birthday;
	}
	
	public String GetEmail()
	{
		return email;
	}
	
	public String GetAddress()
	{
		return address;
	}
	
	public String GetTelephone()
	{
		return telephone;
	}
	
	public String GetPassword()
	{
		return password;
	}
	
}
