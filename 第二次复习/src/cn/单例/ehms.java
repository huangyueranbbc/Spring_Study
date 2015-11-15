package cn.单例;

public class ehms
{
	public static void main(String[] args)
	{
		User user = User.getInstance();
	}
}

class User
{
	private static User user;

	public static User getInstance()
	{
		if (user == null)
		{
			user = new User();
		}
		return user;
	}

	private User()
	{

	}

}
