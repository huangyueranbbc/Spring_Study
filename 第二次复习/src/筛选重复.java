import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class 筛选重复
{
	public static void main(String[] args) throws Exception
	{
		Map result = new HashMap();
		FileInputStream fis = new FileInputStream(new File("info.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		while ((line = br.readLine()) != null)
		{
			dealLine(line, result);
		}
		softResult(result);
	}

	private static void softResult(Map result)
	{
		TreeSet treeSet = new TreeSet(new Comparator()
		{

			@Override
			public int compare(Object o1, Object o2)
			{
				User user1 = (User) o1;
				User user2 = (User) o2;
				if (user1.getValue() < user2.getValue())
				{
					return -1;
				} else if (user1.getValue() > user2.getValue())
				{
					return 1;
				} else
				{
					return user1.getName().compareTo(user2.getName());
				}
			}
		});

		Iterator iterator = result.keySet().iterator();
		while (iterator.hasNext())
		{
			String name = (String) iterator.next();
			Integer value =(Integer) result.get(name);
			if (value > 1)
			{
				treeSet.add(new User(name, value));
			}
		}
		
		printResult(treeSet);
	}

	private static void printResult(TreeSet treeSet)
	{
			Iterator iterator=treeSet.iterator();
			while(iterator.hasNext()){
				User user=(User) iterator.next();
				System.out.println(user.getName()+user.getValue());
			}
	}

	private static void dealLine(String line, Map result)
	{
		String[] results = line.split(",");

		if (results.length == 3)
		{
			String name = results[1];
			// 去除该名称的次数
			Integer times = (Integer) result.get(name);
			if (times == null)
			{
				times = 0;
			}
			result.put(name, times+1);
		}

	}

}

class User
{
	private String name;
	private Integer value;

	public User(String name, Integer value)
	{
		super();
		this.name = name;
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getValue()
	{
		return value;
	}

	public void setValue(Integer value)
	{
		this.value = value;
	}

}
