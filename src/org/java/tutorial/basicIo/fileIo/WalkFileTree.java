package org.java.tutorial.basicIo.fileIo;

import java.io.IOException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * @ClassName:WalkFileTree
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月10日 下午2:46:21
 */
public class WalkFileTree extends SimpleFileVisitor<Path>{
/**
 * 实现FileVistor接口或者继承SimpleFileVisitor 遍历一个file directory
 */
    // Print information about each type of file.
	@Override
	public FileVisitResult visitFile(Path file,
            BasicFileAttributes attr) {
		 if (attr.isSymbolicLink()) {
	            System.out.format("Symbolic link: %s ", file);
	        } else if (attr.isRegularFile()) {
	            System.out.format("Regular file: %s ", file);
	        } else {
	            System.out.format("Other: %s ", file);
	        }
	        System.out.println("(" + attr.size() + "bytes)");
	        return FileVisitResult.CONTINUE;
	}
	// Print each directory visited.
	@Override
    public FileVisitResult postVisitDirectory(Path dir,IOException exc) {
        System.out.format("Directory: %s%n", dir);
        return FileVisitResult.CONTINUE;
    }
	// If there is some error accessing the file, let the user know.
    // If you don't override this method and an error occurs, an IOException is thrown.
	@Override
    public FileVisitResult visitFileFailed(Path file,IOException exc) {
		if (exc instanceof FileSystemLoopException) { // FOLLOW_LINKS option  加了改选选项需要避免死循环
	        System.err.println("cycle detected: " + file);
	    } else {
	        System.err.format("Unable to copy:" + " %s: %s%n", file, exc);
	    }
        return FileVisitResult.CONTINUE;
    }
	public static void main(String[] args) {
		WalkFileTree walkFileTree = new WalkFileTree() ;

		try {
			Files.walkFileTree(Paths.get("D:\\study"), walkFileTree) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
