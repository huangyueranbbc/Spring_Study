import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

/**
 * 编写一个程序，将d:\java目录下的所有.java文件复制到d:\jad目录下，并将原来文件的扩展名从.java改为.jad。
 */

public class 复制目录文件并改名
{
	public static void main(String[] args) throws Exception
	{
		// 读取要复制目录中的所有文件，并筛选出后缀名为java的
		File file = new File("JAVADIR");
		if (!(file.exists() & file.isDirectory()))
		{
			throw new Exception("目录不存在");
		}

		File[] files = file.listFiles(new FilenameFilter()
		{

			@Override
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".java");
			}
		});

		File file2 = new File("jad");
		if (!file2.exists())
		{
			file2.mkdirs();
		}

		for (File f : files)
		{
			String destname = f.getName().replaceAll("\\.java$", ".jad");
			FileInputStream fis = new FileInputStream(f);
			FileOutputStream fos = new FileOutputStream(new File(file2,
					destname));
			int len = 0;
			byte[] buf = new byte[1024000];
			while ((len = fis.read(buf)) != -1)
			{
				fos.write(buf);
			}
			fis.close();
			fos.close();
		}

	}
}
