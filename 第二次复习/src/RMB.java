public class RMB
{
	private final static char[] arr1 =
	{ '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
	private final static char[] arr2 =
	{ '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿' };

	public static void main(String[] args)
	{
		System.out.println(rum(1356389103));
	}

	private static String rum(int money)
	{
		int arrindex = 0;
		StringBuffer sb = new StringBuffer();

		while (money != 0)
		{
			//可能会越界
			if(arrindex<arr2.length){
				sb.insert(0, arr2[arrindex]);
				arrindex++;
			}else {
				arrindex=1;
				sb.insert(0, arr2[arrindex]);
				arrindex++;
			}
			
			int num1 = money % 10;
			sb.insert(0, arr1[num1]);
			money = money / 10;
		}

		return sb.toString();
	}

}
