package cn.hyr.callback;

public class MyTemplate {
	final int i = 300;
	final int j = 100;

	public void executeWithNativeMethod(TemplateCallBack templateCallBack) {
		try {
			System.out.println("i����" + this.i + "����" + "j����" + this.j);
			templateCallBack.����(this.i, this.j);
			System.out.println("�˷���������");
			System.out
					.println("=====================================================");
		} catch (Exception e) {
		}
	}

	public void ��() {
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void ����(int i, int j) {
				System.out.println("�ӷ�    " + i + j);
			}
		});
	}

	public void ��() {
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void ����(int i, int j) {
				System.out.println("����    " + (i - j));
			}
		});
	}

	public void ��() {
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void ����(int i, int j) {
				System.out.println("����    " + i * j);
			}
		});
	}

	public void ��() {
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void ����(int i, int j) {
				System.out.println("�˷�    " + i / j);
			}
		});
	}
}
