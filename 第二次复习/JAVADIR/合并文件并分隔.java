import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用回车符分隔，b.
 * txt文件中用回车或空格进行分隔。
 */
public class 合并文件并分隔 {

	public static void main(String[] args) throws Exception {
		FileManager a = new FileManager("a.txt", new char[] { '\n' });
		FileManager b = new FileManager("b.txt", new char[] {' ' });
		FileWriter writer = new FileWriter("c.txt");
		String aWord = null;
		String bWord = null;

		while ((aWord = a.nextWord()) != null) {
			writer.write(aWord + "\n");
			if ((bWord = b.nextWord()) != null) {
				writer.write(bWord + "\n");
			}
		}
		// 如果a文件的内容写完了，则判断B是否写完
		while ((bWord = b.nextWord()) != null) {
			writer.write(bWord+"\n");
		}
		writer.close();

	}

}

// 讲文件内容整理格式以单词的形式存入一个String数组
class FileManager {
	String[] words = null;
	int pos = 0;

	public FileManager(String filename, char[] seperators) throws Exception {
		File file = new File(filename);
		FileReader reader = new FileReader(file);
		char[] buf = new char[(int) file.length()];
		int len = reader.read(buf);
		String result = new String(buf, 0, len);
		String regex = null;
		if (seperators.length > 1) {
			regex = seperators[0] + "/" + seperators[1];
		} else {
			regex = seperators[0] + "";
		}
		words = result.split(regex);
	}

	public String nextWord() {
		if (pos == words.length)
			return null;
		return words[pos++];
	}
}
