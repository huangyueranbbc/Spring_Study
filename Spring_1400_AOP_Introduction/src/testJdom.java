import java.util.*; 
import org.jdom.*; 
import org.jdom.input.SAXBuilder; 
public class testJdom { 
  public static void main(String[] args) throws Exception{  
    SAXBuilder sb=new SAXBuilder(); 
    Document doc=sb.build(testJdom.class.getClassLoader().getResourceAsStream("test.xml")); //�����ĵ�����
    Element root=doc.getRootElement(); //��ȡ��Ԫ��
    List list=root.getChildren("disk");//ȡ����Ϊdisk������Ԫ�� 
    for(int i=0;i<list.size();i++){ 
       Element element=(Element)list.get(i); 
       String name=element.getAttributeValue("name"); 
       String capacity=element.getChildText("capacity");//ȡdisk��Ԫ��capacity������ 
       String directories=element.getChildText("directories"); 
       String files=element.getChildText("files"); 
       System.out.println("������Ϣ:"); 
       System.out.println("�����̷�:"+name); 
       System.out.println("��������:"+capacity); 
       System.out.println("Ŀ¼��:"+directories); 
       System.out.println("�ļ���:"+files); 
       System.out.println("-----------------------------------"); 
    }   
  } 
}