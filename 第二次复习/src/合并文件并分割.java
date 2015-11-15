import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;

/**
 * 编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用回车符分隔，b.
 * txt文件中用回车或空格进行分隔。
 */
public class 合并文件并分割
{
	public static void main(String[] args) throws Exception
	{
		FileManager file1 = new FileManager("a.txt", new char[]
		{ '\n' });
		FileManager file2 = new FileManager("b.txt", new char[]
		{ ' ' });

		// 进行合并
		FileWriter fw = new FileWriter(new File("c.txt"));
		String aWord = null;
		String bWord = null;
		
		while((aWord=file1.nextWord())!=null){
			fw.write(aWord+"\n");
			if((bWord=file2.nextWord())!=null){
				fw.write(bWord+"\n");
			}
		}
		
		//a写完后 b可能没写完
		while((bWord=file2.nextWord())!=null){
			fw.write(bWord+"\n");
		}
		fw.close();

	}

}

class FileManager
{

	String[] words = null;
	int pos = 0;

	public FileManager(String filename, char[] seperators) throws Exception
	{
		File file = new File(filename);
		FileReader fr = new FileReader(file);
		char[] buf = new char[(int) file.length()];
		int len = fr.read(buf);
		String result = new String(buf, 0, len);
		String regex = null;
		if (seperators.length > 1)
		{
			regex = seperators[0] + "/" + seperators[1];
		} else
		{
			regex = seperators[0] + "";
		}

		words = result.split(regex);

	}

	public String nextWord()
	{
		if (pos == words.length)
			return null;
		return words[pos++];

	}
}
