public class 冒泡
{
	static int[] a = new int[]
	{ 2, 7, 3, 1, 6, 9, 4 };

	public static void main(String[] args)
	{
		
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"   ");
		}
		
	}
}
