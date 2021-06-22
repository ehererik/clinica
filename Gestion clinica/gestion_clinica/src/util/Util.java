package util;

import java.util.Random;

public class Util
{
	private static Random r = new Random();

	public static void espera()
	{
		try
		{
			Thread.sleep(r.nextInt(5000));
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void espera(int num)
	{
		try
		{
			Thread.sleep(num);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void esperaRandom(int num)
	{
		try
		{
			Thread.sleep(r.nextInt(num));
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
