 //2016/11/11  By: LR3800
//��������,ϣ�����ܺ���һ�����Ƹ���Ŀ
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class GoogleHosts {
	public static void main( String[] args ) throws Exception
	{
		
		System.out.println("���ڻ�ȡ���� Hosts�ļ�... ...");
		/*���� */
		String			remoteFilePath	= "https://hosts2017.github.io/Hosts/hosts";
		String			localFilePath	= System.getProperty( "user.dir" ) + "/hosts";
		URL			urlfile		= null;
		HttpURLConnection	httpUrl		= null;
		BufferedInputStream	bis		= null;
		BufferedOutputStream	bos		= null;
		File			f		= new File( localFilePath );
		try
		{
			urlfile = new URL( remoteFilePath );
			httpUrl = (HttpURLConnection) urlfile.openConnection();
			httpUrl.connect();
			bis	= new BufferedInputStream( httpUrl.getInputStream() );
			bos	= new BufferedOutputStream( new FileOutputStream( f ) );
			int len = 2048;
			byte[] b = new byte[len];
			while ( (len = bis.read( b ) ) != -1 )
			{
				bos.write( b, 0, len );
			}
			bos.flush();
			bis.close();
			httpUrl.disconnect();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bis.close();
				bos.close();
			}
			catch ( IOException e )
			{
				e.printStackTrace();
			}
		}
		/*���� */


		/* OSinfo.getOSname(); */
		System.out.println("��GoogleHostsAidesv1.0 Hosts��������  ��ƽ̨Windows Unix��linux��Macintosh��");
		
		System.out.println( " ��ѡ�����Ĳ���ϵͳ?(��������)" + "\n" + " 1.Microsoft Windows NT��2000��XP��2003��Vista��2008��7��2012��8��8.1��10  \n 2.Unix��linuxϵͳ��  Apple Macintosh " );
		Scanner in2	= new Scanner( System.in );
		int	a	= in2.nextInt();
		if ( a == 1 )
		{
			try{
				FileInputStream		input	= new FileInputStream( System.getProperty( "user.dir" ) + "/hosts" );
				FileOutputStream	output	= new FileOutputStream( "C://Windows//System32//drivers//etc//hosts" );
				int			in	= input.read();
				while ( in != -1 ) /* win */
				{
					output.write( in );
					in = input.read();
				}
			}catch ( IOException e ) {
				System.out.println( e.toString() );
			}
			System.out.println( "---------- \n  �ɹ�д�먌 \n  ---------- \n ע��: Google ����վ��ͨ�� https ��ʽ���ʣ��� https://www.google.com/ncr" );
			BufferedReader br = null;
			try {
				Process p = Runtime.getRuntime().exec( "ipconfig /flushdns" );
				br = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
				String line = null;
				while ( (line = br.readLine() ) != null )
				{
					System.out.println( line );
				}
			} catch ( Exception e ) {
				e.printStackTrace();
			} finally {
				if ( br != null )
				{
					try {
						br.close();
					} catch ( Exception e ) {
						e.printStackTrace();
					}
				}
				int	c	= in2.nextInt();}
		}

		if ( a == 2 ) /* linux */
		{
			try{
				FileInputStream		input	= new FileInputStream( System.getProperty( "user.dir" ) + "/hosts" );
				FileOutputStream	output	= new FileOutputStream( "/etc/hosts" );
				int			in	= input.read();
				while ( in != -1 )
				{
					output.write( in );
					in = input.read();
				}
			}catch ( IOException e ) {
				System.out.println( e.toString() );
			}
			System.out.println( "---------- \n  �ɹ�д�먌 \n  ---------- \n ע��: Google ����վ��ͨ�� https ��ʽ���ʣ��� https://www.google.com/ncr" );
			//String[] cmds = { "/bin/sh", "-c", "ps -ef|grep java" };
			Process pro = Runtime.getRuntime().exec( "sudo systemctl restart NetworkManager" );
			pro.waitFor();
			InputStream	in	= pro.getInputStream();
			BufferedReader	read	= new BufferedReader( new InputStreamReader( in ) );
			String		line	= null;
			while ( (line = read.readLine() ) != null )
			{
				System.out.println( line );
				
				
				int	b	= in2.nextInt();
			}
		}
		
		
	}
}
