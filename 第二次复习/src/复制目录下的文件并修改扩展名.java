import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

public class 复制目录下的文件并修改扩展名
{
	public static void main(String[] args) throws Exception
	{
		File file1 = new File("JAVADIR");
		if (!file1.exists() & !file1.isDirectory())
		{
			throw new Exception("文件夹不存在");
		}

		File[] files = file1.listFiles(new FilenameFilter()
		{

			@Override
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".java");
			}
		});

		File file2 = new File("JAD");
		if (!file2.exists())
		{
			file2.mkdir();
		}

		// 修改文件名并进行复制
		for (File f : files)
		{
			FileInputStream fis = new FileInputStream(f);
			String filedestname = f.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream fos = new FileOutputStream(new File(file2,
					filedestname));

			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) != -1)
			{
				fos.write(buf);
			}
			// 关闭资源
			fis.close();
			fos.close();
		}

	}
}
