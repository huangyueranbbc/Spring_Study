import java.io.UnsupportedEncodingException;

public class 截取字节数
{
	public static void main(String[] args) throws UnsupportedEncodingException
	{
		String str1 = "我a爱中华abc我爱传智def";
		int num = trim(str1.getBytes("GBK"), 6);
		System.out.println(str1.substring(0, num));
	}

	private static int trim(byte[] bytes, int len)
	{
		int num = 0;
		boolean isch = false;
		for (int i = 0; i < len; i++)
		{
			if (bytes[i] < 0 & !isch)
			{
				isch = true;
			} else
			{
				num++;
				isch = false;
			}
		}

		return num;
	}

}
