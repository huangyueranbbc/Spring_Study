import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 编写一个程序，将d:\java目录下的所有.java文件复制到d:\jad目录下，并将原来文件的扩展名从.java改为.jad。
 */
public class 复制目录文件并修改扩展名 {
	
	public static void main(String[] args) throws Exception {
		File file = new File("JAVADIR");
		if ((file.isDirectory()) && !(file.exists())) {
			throw new Exception("目录不存在");
		}

		File[] files = file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		
		File file2=new File("jad");
		if(!file2.exists()){
			file2.mkdir();
		}
		
		//复制
		for(File f:files){
			FileInputStream fis=new FileInputStream(f);
			String destFileName=f.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream fos=new FileOutputStream(new File(file2,destFileName));
			copy(fis,fos);
			fis.close();
			fos.close();
		}
		
	}
	
	private static void copy(InputStream ips,OutputStream ops) throws Exception{
		int len=0;
		byte[] buf=new byte[1024];
		while ((len=ips.read(buf))!=-1) {
			ops.write(buf);
		}
	}	
	
}
