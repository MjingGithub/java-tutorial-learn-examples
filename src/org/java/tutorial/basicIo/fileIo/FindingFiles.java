package org.java.tutorial.basicIo.fileIo;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * @ClassName:FindingFiles
 * @Description:TODO
 * @author jing.ming
 * @date 2016年12月10日 下午3:39:53
 */
public class FindingFiles {
   public static class Finder extends SimpleFileVisitor<Path>{
	private final PathMatcher matcher;
    private int numMatches = 0;

    Finder(String pattern) {
        matcher = FileSystems.getDefault()
                .getPathMatcher("glob:" + pattern);
    }

    // Compares the glob pattern against
    // the file or directory name.
    void find(Path file) {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            numMatches++;
            System.out.println(file);
        }
    }

    // Prints the total number of
    // matches to standard out.
    void done() {
        System.out.println("Matched: "
            + numMatches);
    }
 // Invoke the pattern matching
    // method on each file.
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attrs) {
        find(file);
        return FileVisitResult.CONTINUE;
    }

    // Invoke the pattern matching
    // method on each directory.
    @Override
    public FileVisitResult preVisitDirectory(Path dir,
            BasicFileAttributes attrs) {
        find(dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file,
            IOException exc) {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }
   }

	public static void main(String[] args) {
		//pathMatcher
		PathMatcher matcher =
		    FileSystems.getDefault().getPathMatcher("glob:*.{java,class}");//参数有疑问,为什么是glob:
        
		System.out.println(matcher.matches(Paths.get("D:\\study").getFileName()));
		//Recursive Pattern Matching
		
		//Finder finder = new Finder(pattern);
       // Files.walkFileTree(startingDir, finder);
       // finder.done();
		
	
	}

}
