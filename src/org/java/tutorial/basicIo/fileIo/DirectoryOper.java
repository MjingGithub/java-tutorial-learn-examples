package org.java.tutorial.basicIo.fileIo;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

/**
 * 
 * @ClassName:DirectoryOper
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月10日 上午10:32:17
 */
public class DirectoryOper {

	public static void main(String[] args) {
		//list a file system`s root directories
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories() ;
		for(Path name:dirs){
			System.out.println(name) ;//C:\  D:\
		}
		//create a directory
		/*Path psth = Paths.get("D:\\newDir\\firstDeep") ;
		try {
			Files.createDirectories(psth) ;//createDirectories()可以新建多层不同的目录.而createDirectory()只能创建一层.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Creating a Temporary Directory
		/*try {
			Files.createTempDirectory(Paths.get("D:\\"), "tff");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Listing a Directory's Contents
		//定义filter过滤器只列出是目录的内容
		try {
			DirectoryStream<Path> stream  = Files.newDirectoryStream(Paths.get("D:\\"), new DirectoryStream.Filter<Path>() {
			    public  boolean accept(Path file){
			        return (Files.isDirectory(file));
			    }
			}) ;// Files.newDirectoryStream(dir, "*.{java,class,jar}"))
			for (Path file: stream) {
		        System.out.println(file.getFileName());
		    }
		} catch (IOException|DirectoryIteratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	//Writing Your Own Directory Filter
	DirectoryStream.Filter<Path> filter =
			    new DirectoryStream.Filter<Path>() {
			    public  boolean accept(Path file) {
			        return (Files.isDirectory(file));
			    }
			};*/

	}

}
