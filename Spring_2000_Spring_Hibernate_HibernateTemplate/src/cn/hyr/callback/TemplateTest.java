package cn.hyr.callback;

public class TemplateTest {
	private static void p(Object object) {
		System.out.println(object);
		
	}
	public static void main(String[] args) {
		MyTemplate myTemplate=new MyTemplate();
		myTemplate.��();
		myTemplate.��();
		myTemplate.��();
		myTemplate.��();
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void ����(int i, int j) {
				System.out.println("�������û�����ָ��");
			}
		});
	}
}
