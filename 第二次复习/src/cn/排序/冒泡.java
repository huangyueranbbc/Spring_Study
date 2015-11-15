package cn.排序;

/**
 * @author Administrator
 *	冒泡
 */
//啊啊啊啊啊第四次提交
public class 冒泡
{
	public static void main(String[] args)
	{
		int[] a =
		{ 1, 3, 2, 6, 4, 5 };

		for (int i = 0; i < a.length - 1; i++)
		{
			for (int j = 0; j < a.length - i - 1; j++)
			{
				if (a[j] > a[j + 1])
				{
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + "  ");
		}
	}
}
