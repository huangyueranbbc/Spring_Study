public class 线程打印12A34B
{
	public static void main(String[] args)
	{
		final Print print = new Print();
		new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				for (int i = 1; i <= 52; i++)
				{
					print.printNumber(i);
				}
			}
		}).start();
		new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				for (char c = 'a'; c <= 'z'; c++)
				{
					print.printChar(c);
				}
			}
		}).start();
	}
}

class Print
{
	int index = 1;

	public synchronized void printNumber(int i)
	{
		while (index % 3 == 0)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print(" " + i);
		index++;
		notifyAll();
	}

	public synchronized void printChar(char c)
	{
		while (index % 3 != 0)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print(" " + c);
		index++;
		notifyAll();
	}
}