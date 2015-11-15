package cn.单例;

public class bhms
{
	Session session = Session.getInstance();
}

class Session
{
	private static Session session = new Session();

	public static Session getInstance()
	{
		return session;
	}

	private Session()
	{

	}

}
