
public class 递归乘2不小于5000
{
	public static void main(String[] args)
	{
		run(1237);
	}

	private static void run(int i)
	{
		
		System.out.println(i);
		if((i=i*2)<5000){
			run(i);
		}
	}
}
