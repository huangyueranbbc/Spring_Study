public class 二叉树
{
	int value;
	二叉树 leftnode;
	二叉树 rightnode;

	public void add(int value)
	{
		if (value <= this.value)
		{
			if (leftnode == null)
			{
				leftnode = new 二叉树();
				leftnode.add(value);
			} else
			{
				leftnode.add(value);
			}
		} else
		{
			if (rightnode == null)
			{
				rightnode = new 二叉树();
				rightnode.add(value);
			} else
			{
				rightnode.add(value);
			}
		}

	}

	public void xianxu()
	{
		System.out.println(this.value);
		if (leftnode != null)
		{
			leftnode.xianxu();
		}
		if (rightnode != null)
		{
			rightnode.xianxu();
		}
	}

	public void zhongxu()
	{
		if (leftnode != null)
		{
			leftnode.xianxu();
		}
		System.out.println(this.value);
		if (rightnode != null)
		{
			rightnode.xianxu();
		}
	}

	public void houxu()
	{
		if (leftnode != null)
		{
			leftnode.xianxu();
		}
		if (rightnode != null)
		{
			rightnode.xianxu();
		}
		System.out.println(this.value);
	}

}
