package cn.hyr.callback;

public class TemplateTest {
	private static void p(Object object) {
		System.out.println(object);
		
	}
	public static void main(String[] args) {
		MyTemplate myTemplate=new MyTemplate();
		myTemplate.加();
		myTemplate.减();
		myTemplate.乘();
		myTemplate.除();
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void 运算(int i, int j) {
				System.out.println("可以有用户进行指定");
			}
		});
	}
}
