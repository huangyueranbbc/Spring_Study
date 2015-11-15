public class hashcode
{
	public static void main(String[] args)
	{
		UserO u1 = new UserO("aa", 1);
		UserO u2 = new UserO("aa", 1);
		System.out.println(u1.equals(u2));

	}

}

class UserO
{
	private String name;
	private int age;

	public UserO(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		return true;
	}

}