package org.java.tutorial.basicIo.fileIo;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @ClassName:OtherFileIOper
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月10日 下午6:28:26
 */
public class OtherFileIOper {

	public static void main(String[] args) {
		// MIME Type
		// probeContentType returns null if the content type cannot be determined.
		Path path = Paths.get("D:\\study\\github_workSpace\\jvm-core-learning-example\\src\\org\\jvmcore\\classloader\\ClassLoaderInfoT.java") ;
		try {
			String type = Files.probeContentType(path) ;
			if (type == null) {
		        System.err.format("'%s' has an" + " unknown filetype.%n", path);
		    }else if(!type.equals("text/plain")){
		        System.err.format("'%s' is not" + " a plain text file.%n", path);
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fileStore,
		for (FileStore store: FileSystems.getDefault().getFileStores()) {
			  System.out.println("file store:"+store.toString());//DATA (D:),OS (C:)
   
			}
		

	}

}
