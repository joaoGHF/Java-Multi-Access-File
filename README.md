# Java-Multi-Access-File
A Java program to exercite multithreading and synchronization

## How Works
<p>This program works by creating (if not existing) a file called "arq.txt" in the root of the project and cleaning it, then stores in an <code>ArrayList&#60;Thread&#62;</code> a number of threads of type <code>WriterThread</code> and starts each one. The main method is in <a href="MultiAccessFile/src/org/multi_access_file/App.java">App.java</a>.</p>
<p>The <a href="MultiAccessFile/src/org/multi_access_file/FileController.java">FileController.java</a> class has the methods to manage a <code>File</code> object, this can initialize, clear and write by yours static and some synchronized methods.</p>
<p>The <a href="MultiAccessFile/src/org/multi_access_file/GenerateLine.java">GenerateLine.java</a> class is used to get a String or a String Array by yours methods: <code>public static String getLine(int maxSize)</code> and <code>public static String[] getLines(int maxSize, int lines)</code>.</p>
<p>The <a href="MultiAccessFile/src/org/multi_access_file/WriteThread.java">WriteThread.java</a> is a subclass of <code>Thread</code> that will write in the <code>File</code> object a formated String with your name and the generated text how many times your attribute determines. Finally will print that the current thread was ended.</p>

## Results
> One preview of a possible content in the 'arq.txt':
```
[Thread-55]:{çƞeĿǃù{ɩΙϲϫɪΊƯ΀ϙͅ}
[Thread-52]:{ʾğƜʃũƷʕĥ͠ȬŻŮƎĖ}
[Thread-0]:{Ęȩ:ßΑȗ}
[Thread-36]:{Ə©̿}
[Thread-11]:{όƋŸϳʎƹßʅ¡ά'}
[Thread-9]:{}
[Thread-26]:{ĜŉǵϚȐɱǽɦV-͍ŗºΠɴąİΩΔϋ͢ŧǆȢ͎ļȉ}
[Thread-32]:{̑Ĺ̛ʀͳɃÞ>ͬ΢ȪϨ͉¨ĶǱǲ̀˧̬À_ĔǙȂſ}
[Thread-37]:{ϣ͡ƹ˷ĜʲÍ͏õϥ˽ʯ}
[Thread-28]:{ʞÛȮć}
```

> And one preview of a possible snippet in the terminal:
```
Added in file arq.txt the content:
[Thread-11]:{♫?]?A??e?????}
Added in file arq.txt the content:
[Thread-65]:{??µ§??ñ?}
+++Thread-81 was ENDED 
+++Thread-60 was ENDED
+++Thread-43 was ENDED
+++Thread-48 was ENDED 
+++Thread-74 was ENDED
```
