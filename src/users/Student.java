package users;
/*
 * User�ĸ��࣬�洢��һЩ������Ϣ
 */
public class Student {
	public String stuId;
	public String name;
	protected boolean sex;
	protected String ssn;
	
	public Student() {
		//���캯��
		stuId = "";
		name = "";
		sex = true;
		ssn = "";
	}
	
	public void setStuId(String StuId)
	{
		stuId = StuId;
	}
	public void setName(String Name)
	{
		name = Name;
	}
	
	public void setSex(boolean Sex)
	{
		sex = Sex;
	}
	
	public void setSsn(String Ssn)
	{
		ssn = Ssn;
	}
	
	public String setStuId()
	{
		return stuId;
	}
	
	public String setName()
	{
		return name;
	}
	
	public boolean setSex()
	{
		return sex;
	}
	
	public String setSsn()
	{
		return ssn;
	}
}
