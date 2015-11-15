
public class 递归求年龄
{
	static int  result=0;
	public static void main(String[] args)
	{
		int  age=10;
		int nownum=1;
		run(8,nownum,age);
		System.out.println(result);
	}

	private static void run(int num,int nownum,int age)
	{
		if(nownum<num){
			nownum++;
			age+=2;
			result=age;
			run(num, nownum,age);
			
		}
		
	}
}
