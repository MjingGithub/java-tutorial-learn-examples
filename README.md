# java-tutorial-learn-examples
my codes when learn java core  .
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

-Scanning 
Objects of type Scanner are useful for breaking down formatted input into tokens and translating individual tokens according to their data type.


 

