package cn.hyr.callback;

public class MyTemplate {
	final int i = 300;
	final int j = 100;

	public void executeWithNativeMethod(TemplateCallBack templateCallBack) {
		try {
			System.out.println("i等于" + this.i + "——" + "j等于" + this.j);
			templateCallBack.运算(this.i, this.j);
			System.out.println("此方法结束！");
			System.out
					.println("=====================================================");
		} catch (Exception e) {
		}
	}

	public void 加() {
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void 运算(int i, int j) {
				System.out.println("加法    " + i + j);
			}
		});
	}

	public void 减() {
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void 运算(int i, int j) {
				System.out.println("减法    " + (i - j));
			}
		});
	}

	public void 乘() {
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void 运算(int i, int j) {
				System.out.println("除法    " + i * j);
			}
		});
	}

	public void 除() {
		new MyTemplate().executeWithNativeMethod(new TemplateCallBack() {
			@Override
			public void 运算(int i, int j) {
				System.out.println("乘法    " + i / j);
			}
		});
	}
}
