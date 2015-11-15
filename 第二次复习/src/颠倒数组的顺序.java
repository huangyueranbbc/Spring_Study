import java.util.Arrays;

public class 颠倒数组的顺序
{
	public static void main(String[] args)
	{
		int[] a = new int[]
		{ (int) (Math.random() * 1000), (int) (Math.random() * 1000),
				(int) (Math.random() * 1000), (int) (Math.random() * 1000),
				(int) (Math.random() * 1000) };
		
		System.out.println(Arrays.toString(a));
		swap(a);
		System.out.println(Arrays.toString(a));
	}

	private static void swap(int[] a)
	{
		int len=a.length;
		for(int i=0;i<len/2;i++){
			int temp=a[i];
			a[i]=a[len-i-1];
			a[len-i-1]=temp;
		}
	}
}
