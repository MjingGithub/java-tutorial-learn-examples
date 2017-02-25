# java-tutorial-learn-examples
my codes when learn java core  .

## 项目结构
- src 目录<br>
以包区分不同的学习知识点.<br>

## 包目录
        ├── org.java.tutorial             // 根目录
              ├── nestedClass           // 内部类
              ├── exceptions        // java 核心类Exception
              ├── basicIo          // 文件读取io处理
                   ├── fileIo
                   ├── ioStreams
              ├── concurrency      //并发
                   ├── threadObjects   //thread对象的创建和基本静态方法
                   ├── synchronization  //同步处理的方法和策略
                   ├── liveness     //处理更复杂的线程饥饿,死锁等问题
 
              
##学习方法
根据包一个类一个知识点的学习,跑测试用例.


## learn Notes
### BasicIo
* 大多数关于I/O Streams部分的类都在java.io 包中.大多数关于File I/O的部分的类都在java.nio.file包中.*

- I/O Streams
a stream is a sequence of data. a program use an input stream to read data from a source ,one item at a time.
a program uses a output stream write data to a destination,ont item at a time.

- Byte streams 
Programs use byte streams to perform input and output of 8-bit bytes. All byte stream classes are descended from InputStream and OutputStream.
所有的stream 类信息都是建立在byte stream 之上的.
根据stream要传递的资源类型选择不同的stream处理,可以提高效率.

- Character streams 
The Java platform stores character values using Unicode conventions. Character stream I/O automatically translates this internal format to and from the local character set. In Western locales, the local character set is usually an 8-bit superset of ASCII.
For most applications, I/O with character streams is no more complicated than I/O with byte streams. Input and output done with stream classes automatically translates to and from the local character set. A program that uses character streams in place of byte streams automatically adapts to the local character set and is ready for internationalization — all without extra effort by the programmer.


 一行的分隔符可以是("\r\n"), 回车("\r"), 换行符("\n"). 不同系统分隔符可能不一样.

- Buffered Streams
为了减轻直接os操作引起的效率问题,java实现了i/o buffered streams.buffer i/o从内存读取数据,只有当buffer空了的时候才会调用直接os操作.
可以将unbuffered streams 转换为buffered streams.
```
inputStream = new BufferedReader(new FileReader("xanadu.txt"));
outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));
```
There are four buffered stream classes used to wrap unbuffered streams: BufferedInputStream and BufferedOutputStream create buffered byte streams, while BufferedReader and BufferedWriter create buffered character streams.

- Flushing Buffered Streams
It often makes sense to write out a buffer at critical points, without waiting for it to fill. This is known as flushing the buffer.

- Scanning 
Objects of type Scanner are useful for breaking down formatted input into tokens and translating individual tokens according to their data type.

- random access files 
使用SeekableByteChannel接口定义可以实现这个功能.因为它继承的channel I/O有记录当前位置的标记.这里几个方法:

   `` position – Returns the channel's current position
    position(long) – Sets the channel's position
    read(ByteBuffer) – Reads bytes into the buffer from the channel
    write(ByteBuffer) – Writes bytes from the buffer to the channel
    truncate(long) – Truncates the file (or other entity) connected to the channel
  ``  
    
- 方法介绍:Buffer java.nio.Buffer.rewind().
Rewinds this buffer. The position is set to zero and the mark is discarded. 

Invoke this method before a sequence of channel-write or get operations, assuming that the limit has already been set appropriately. For example: 

 out.write(buf);    // Write remaining data
 buf.rewind();      // Rewind buffer
 buf.get(array);    // Copy data into array

- walking a file tree
首先要实现接口FileVistor:
``
    preVisitDirectory – Invoked before a directory's entries are visited.
    postVisitDirectory – Invoked after all the entries in a directory are visited. If any errors are encountered, the specific exception is passed to the method.
    visitFile – Invoked on the file being visited. The file's BasicFileAttributes is passed to the method, or you can use the file attributes package to read a specific set of attributes. For example, you can choose to read the file's DosFileAttributeView to determine if the file has the "hidden" bit set.
    visitFileFailed – Invoked when the file cannot be accessed. The specific exception is passed to the method. You can choose whether to throw the exception, print it to the console or a log file, and so on.
``
如果你不需要实现FileVistor接口中所有的方法,那么你可以继承SimpleFileVisitor,然后选择override你所需要的方法.

    
### Concurrency
* processes and threads(进程和线程) *
```
线程也称为轻量级的进程.它们都有自己的执行环境.但是创建一个线程比创建一个进程需要 更少的资源..线程在进程中,并且一个进程包含至少一个线程.线程分享进程的资源.java应用启动会创建一个主线程,称为main thread.main thread 可以创建多个线程.

```
#### Thread Objects
每一个线程都是一个Thread对象实例.有2这种方式创建并行应用.
1.每当需要执行异步任务时,直接初始化一个Thread对象.
2.使用抽象的thread管理应用,在需要异步任务时,传递任务给一个executor.

##### 定义和启动一个线程
创建Thread实例必须定义在线程中执行的代码,有2种方式:
1.提供一个Runnable对象.Runnable接口定义了一个唯一的run方法,意味着在run方法中写线程执行的代码.Runnable对象会被传递给Thread构造函数.
2.继承Thread.覆盖Thread对象的run方法.
* 一般我们选择使用第一种方法创建一个Thread对象,因为第一种方法中,Runnable对象可以继承自己定义的线程类而第二种只能是Thread子类. * 

##### 使用Sleep方法暂停当前线程的执行
Thread.sleep()让当前线程暂停一段时间执行.

##### Interrupts
中断意味着,这个线程需要停止当前执行的任务,去做其他的任务.
Interrupt 机制的实现通过一个interrupt status的标识.调用Thread.interrupt会设置这个标识.当一个线程调用Thread.interrupted(),interrupt status标识会清除.非静态方法isInterrupted():通过调用一个线程去查询另外一个线程的状态,则不会改变interrupt status标识.抛出InterruptedException异常时,interrupt status标识也会清除.
- 非静态方法`public void interrupt()`会设置interrupt status标识,并且让当前线程中断该线程.
- 静态方法`public static boolean interrupted()`检测是否当前线程已经中断了,interrupt status标识会清除.
- 非静态方法`public boolean isInterrupted()`检测该线程是否已经中断了,通过调用一个线程去查询另外一个线程的状态,不会改变interrupt status标识.


##### join
join()方法允许一个线程等待另外一个线程的的完成.假如一个线程t.join().会导致当前线程暂停,执行t线程,直到t线程执行结束.
当A线程执行到了B线程的join()方法时，A就会等待，等B线程都运行完，A线程才会执行。使用join()方法时，会产生异常。
join方法可以用于临时加入线程，一个线程在运算过程中，如果满足于条件，我们可以临时加入一个线程，让这个线程运算完，另外一个线程再继续运行。

#### Synchronization
##### Thread Interference(线程干扰)
##### 使用synchronized关键字
标注synchronized关键字的方法可以保证同步,一个时间只能有一个线程访问,其余线程只能阻塞.
* 构造方法不能使用synchronized 关键字.*
1.使用Synchronized关键字
2.使用synchronized statement.
3.使用锁.
4.Reentrant Synchronization:一个线程不能获取到另外一个线程控制的锁.但是一个线程可以获取到它本身已经拥有的锁.
允许一个线程多次获取同一个锁就是 reentrant synchronization

##### atomic access
要么全部执行完成,要么完成不执行.类似于原子操作.
原子操作的有:
1.引用变量,基本变量(除了long和double)的读和写.
2.申明为volatile 的变量.

#### liveness

