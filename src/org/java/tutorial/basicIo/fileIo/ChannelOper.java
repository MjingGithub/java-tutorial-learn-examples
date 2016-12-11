package org.java.tutorial.basicIo.fileIo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @ClassName:ChannelOper
 * @Description:操作文件,在某个位置写入数据
 * @author jing.ming
 * @date 2016年12月10日 上午9:33:31
 */
public class ChannelOper {

	public static void main(String[] args) {
		String s = "I was here!\n" ;
		byte[] bytes = s.getBytes() ;
		ByteBuffer bbf = ByteBuffer.wrap(bytes) ;
		System.out.println("position before:"+bbf.position());//0
		ByteBuffer copy= ByteBuffer.allocate(s.length()) ;
		System.out.println("copy position before:"+copy.position());//0
		Path file = Paths.get("D:\\source.txt") ;
		System.out.println("position after:"+bbf.position());//0
		try(FileChannel fc=(FileChannel.open(file, StandardOpenOption.READ,StandardOpenOption.WRITE))){
			//从文件开始位置取12 bytes,I was here 被写在开始的位置
			int  nread = 0 ;
			do{nread=fc.read(copy);}
			while(nread!=-1&&copy.hasRemaining());
			//Write "I was here!" at the beginning of the file.
			fc.position(0) ;
			while (bbf.hasRemaining())
		        fc.write(bbf);
			System.out.println("position now:"+bbf.position());//12
			bbf.rewind() ;//The position is set to zero and the mark is discarded. 
			System.out.println("position now1:"+bbf.position());//0
			fc.position(fc.size()-1);
			copy.flip() ;
			System.out.println("copy position now:"+copy.position());//0
			while(copy.hasRemaining()){
				fc.write(copy);
			}
			while(bbf.hasRemaining()){
				fc.write(bbf) ;
			}

		}catch(IOException e){
			System.out.println("I/O Exception: " + e);
		}

	}

}
