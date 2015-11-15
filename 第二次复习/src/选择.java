public class 选择

{
	static int[]  a= new int[]
	{ 2, 7, 3, 1, 6, 9, 4 };

	public static void main(String[] args)
	{
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){
				if(a[i]>a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"   ");
		}
	}
}
