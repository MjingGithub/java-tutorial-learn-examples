package org.java.tutorial.basicIo.fileIo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName:PathOper
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月3日 上午9:31:57
 */
public class PathOper {

	public static void main(String[] args){
		//createPath("D:\\source.txt") ;
		//Path path = Paths.get("D:\\xmind_dairy\\1.xmind") ;
		Path path = Paths.get("D:\\xmind_dairy\\sally\\..\\1.xmind") ;
		//normalize()方法移除所有冗余的元素,包括"."或者"directory/.."
		try {
			path = path.toRealPath(LinkOption.values()); //保证目录移除冗余前一定存在.调用该方法.没有该目录会抛出异常.
			System.out.format("toString: %s%n", path.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		path=path.normalize();// D:\xmind_dairy\舒适圈.xmind
		URI uri = path.toUri() ; //file:///D:/xmind_dairy/1.xmind
		Path realPath = Paths.get("jj/realPath.txt") ;
		System.out.println("realPath:"+realPath) ;
		path = path.toAbsolutePath() ;
		System.out.println("uri:"+uri);
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,1): %s%n", path.subpath(0,1));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		//使用FileSystem对象的getPath方法 获取Path对象
		//FileSystems的getDefault方法，会由JVM返回一个代表了当前文件系统的FileSystem对象，我们可以通过FileSystem来获得Path对象
		Path path1 = FileSystems.getDefault().getPath("D:\\source.txt");
		//直接使用Paths.get获取
		Path path2 = Paths.get("D:\\access.txt") ;
		/*try (
			BufferedReader reader = Files.newBufferedReader(path1, StandardCharsets.UTF_8);
			BufferedWriter writer = Files.newBufferedWriter(path2, StandardCharsets.UTF_8) ;
		){
			String c;
			while((c=reader.readLine())!=null){
					writer.write(c);
					writer.newLine();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
		//数据操作
		Path operPath = Paths.get("D:\\source.txt") ;
		//common used small file  操作
		byte[] allBytes;
		try {
			allBytes = Files.readAllBytes(operPath);
			Files.write(path2, allBytes, StandardOpenOption.WRITE) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Buffered I/O Methods for Text Files 操作
		Charset charset = Charset.forName("UTF-8") ;
		try (BufferedReader reader = Files.newBufferedReader(operPath,charset)){
			String l  ;
			while((l=reader.readLine())!=null){
				System.out.println(l);
			}
		} catch (IOException e) {
			 System.err.format("IOException: %s%n", e);
		}
		
		//Methods for Unbuffered Streams and Interoperable with java.io APIs
		try (InputStream in = Files.newInputStream(operPath);
			 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			 String line = null;
			 while ((line = reader.readLine()) != null) {
			      System.out.println(line);
			 }
		}catch(IOException e){
			System.err.println(e);
		}

		String s = "Hello World! ";
		byte data[] = s.getBytes();
		Path p = Paths.get("D:\\logfile.txt"); 
		//下面的例子会打开一个文件,如果这个文件不存在,会自动创建,如果存在,会打开文件,在在后面添加内容
		try (OutputStream out = new BufferedOutputStream(
				Files.newOutputStream(p, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
			out.write(data, 0, data.length);
		} catch (IOException x) {
			System.err.println(x);
		}
		//Methods for Channels and ByteBuffers
		try(SeekableByteChannel sbc = Files.newByteChannel(operPath))
		{
			ByteBuffer buf = ByteBuffer.allocate(10);
			String encoding = System.getProperty("file.encoding");
			while (sbc.read(buf) > 0) {
			      buf.rewind();
			      System.out.print(Charset.forName(encoding).decode(buf));
			      buf.flip();
			    }
		}catch (IOException e) {
			System.err.println(e);
		}
		
	}

}
