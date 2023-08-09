import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File folder = new File("D:\\"); // Создали класс File и указали на директорию диска D
        // Если указать в параметрах ".", то покажет список папки, в которой запускается программа
//        for (File file : folder.listFiles()) { // циклом пробежались по списку файлов в директории
//            System.out.println(file.getName()); // вывели имена файлов в директории
//        }
        System.out.println("======================================================================");

        System.out.println("Is it a folder - " + folder.isDirectory()); // true
        System.out.println("Is it a file - " + folder.isFile()); // false

        File file = new File("./Dockerfile");
        System.out.println("Length file - " + file.length()); // 0
        System.out.println("Absolute path - " + file.getAbsolutePath()); // D:\Geek Brains 2022\JAVA CORE\Lessons\Lesson_05\.\Dockerfile
        System.out.println("Total space on disk - " + folder.getTotalSpace()); // 366390276096 общий размер диска
        System.out.println("File exists - " + file.exists()); // false, возвращает, существует ли файл
        System.out.println("File deleted - " + file.delete()); //false, возвращает, удалось ли удалить файл
        System.out.println("Free space on disc - " + folder.getFreeSpace()); // 158425415680 свободное место на диске

        System.out.println("======================================================================");

        try {
            FileSystem fileSystem = FileSystems.getDefault(); // работает с файловой системой
            for (Path rootdir : fileSystem.getRootDirectories()) {
                System.out.println(rootdir.toString()); // выведет список корневых директорий (С:\ и D:\)
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("======================================================================");
        
        File file1 = new File("Main.java");
        Path filePath = Paths.get(file1.getName());
        System.out.println(filePath); // Main.java

        System.out.println("======================================================================");

        Path filePath2 = Paths.get("/pics/pic.jpg");
        Path fileName = filePath2.getFileName();
        System.out.println("Filename: " + fileName); // Filename: pic.jpg
        Path parent = filePath2.getParent();
        System.out.println("Parent directory: " + parent); // Parent directory: \pics

        boolean endWitihTxt = filePath2.endsWith("pic.jpg");
        System.out.println("Ends with filePath: " + endWitihTxt); // true
        endWitihTxt = filePath2.endsWith("jpg");
        System.out.println("End with string: " + endWitihTxt); // false

        boolean startsWithPics = filePath2.startsWith("pics");
        System.out.println("Starts with filePath: " + startsWithPics);

        System.out.println("======================================================================");

        System.out.println(filePath2.isAbsolute()); // false
        Path pathFirst = Paths.get("./pics/pic.jpg");
        System.out.println(pathFirst.normalize()); // pics\pic.jpg
        Path pathSecond = Paths.get("./src/../pics/pic.jpg"); // ".." позволяет не отображать папку src
        System.out.println(pathSecond.normalize()); // pics\pic.jpg
        /*
        Path newFile = Files.createFile(Paths.get("D:/Geek Brains 2022/JAVA CORE/Lessons/Lesson_05/src/pics/file.txt"));
        // Создаст файл только с абсолютным путем
        System.out.print("Was the file captired sucessfully in pics directory? ");
        System.out.println(Files.exists(Paths.get("D:/Geek Brains 2022/JAVA CORE/Lessons/Lesson_05/src/pics/file.txt")));
        // true, видит только при абсолютном пути
        Path testDirectory = Files.createDirectory(Paths.get("./testing")); // Создаст директорию
        System.out.print("Was the test directory created sucessfuly? ");
        System.out.println(Files.exists(Paths.get("./testing")));
        // true, директорию видит при таком пути
        newFile = Files.move(newFile, Paths.get("./testing/file.txt"), REPLACE_EXISTING); // перемещение файла из одной папки в другую
        System.out.print("Is our file still in the pics directory? ");
        System.out.println(Files.exists(Paths.get("D:/Geek Brains 2022/JAVA CORE/Lessons/Lesson_05/src/pics/file.txt")));
        // false, нужно проверить, видит ли при таком пути файл
        System.out.print("Has our file been moved to testing directory? ");
        System.out.println(Files.exists(Paths.get("./testing/file.txt")));
        // true, файл видит при таком указании пути
        Path copyFile = Files.copy(newFile, Paths.get("D:/Geek Brains 2022/JAVA CORE/Lessons/Lesson_05/src/pics/file.txt"), REPLACE_EXISTING);
        // копирование файла в папку
        System.out.print("Has our file been copied to pics directory? ");
        System.out.println(Files.exists(Paths.get("D:/Geek Brains 2022/JAVA CORE/Lessons/Lesson_05/src/pics/file.txt")));
        // true, видит только при абсолютном пути
        Files.delete(newFile); // удалит файл
        System.out.print("Does the file exist in testing directory? ");
        System.out.println(Files.exists(Paths.get("./testing/file.txt")));
        // false, удалит файл из папки testing, но он останется в папке pics, так как это не newFile, а copyFile
        System.out.print("Does the testing directory exist? ");
        System.out.println(Files.exists(Paths.get("./testing")));
        // директория testing удалена не будет
        */
        /*
        System.out.println("======================================================================");
        /**
         * Создаем лист
         */
        List<String> lines = Arrays.asList("The cat wants to play with you", "But you don't want to play with it");
        /**
         * Создаем новый файл
         */
        /*
        Path file3 = Files.createFile(Paths.get("cat.txt"));
        if (Files.exists(file3)) { // если файл существует
            Files.write(file3, lines, StandardCharsets.UTF_8); // записать в файл данные из списка в кодировке
            Files.write(file3, Collections.singleton("New string"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            // StandardOpenOption.APPEND - дописать в файл
            System.out.println(Files.readAllLines(Paths.get("cat.txt").normalize()) + " - new write");
            System.out.println();
            lines = Files.readAllLines(Paths.get("cat.txt"), StandardCharsets.UTF_8); // Перезаписали список
            for (String s : lines){
                System.out.println(s);
            }
        }
        */
        System.out.println("======================================================================");
        /**
         * Создаем поток вывода
         */
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(1); // записываем в поток вывода
        out.write(-1);
        out.write(0);
        out.write('a');
        out.write('b');
        /**
         * Создаем
         */
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        int value = in.read();
        System.out.println("First element is - " + value); // 1
        value = in.read();
        System.out.println("Second element in - " + value + ". If (byte)value - " + (byte)value); // 255 и -1
        value = in.read();
        System.out.println("Third element is - " + value); // 0
        value = in.read();
        System.out.println(value); //97
        value = in.read();
        System.out.println(value); // 98
        System.out.println((char) value); // преобразует в b
        value = in.read();
        System.out.println(value); // -1 => empty

        System.out.println("======================================================================");
        /**
         * Создали два массива: с данными, и пустой для записи
         */
        byte[] bytesToWrite = {0, 10, 12, 14, 55, 13, 23}; // 7 bytes
        byte[] bytesToRead = new byte[10];
        /**
         * Создали файл
         */
        File file4 = new File("bytes.txt");
        try {
            System.out.println("Begin");
            FileOutputStream outFile = new FileOutputStream(file4); // создали поток ввода, + true - до записывать
            outFile.write(bytesToWrite); outFile.close(); // записали массив в файл и закрыли поток
            System.out.println("Bytes written");

            FileInputStream inFile = new FileInputStream(file4); // создали поток на чтение
            int bytesAvailable = inFile.available(); // вернет длину файла
            System.out.println("Ready to read " + bytesAvailable + " bytes");
            int count = inFile.read(bytesToRead, 0, bytesAvailable); // массив для записи, с нуля, доступное кол-во данных
            for (int i = 0; i < count; i++) {
                System.out.println(" " + bytesToRead[i]); // распечатывает массив
            }
            System.out.println(); inFile.close();
            System.out.println("Input stream closed");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write data to file - " + file4.getName());
        } catch (IOException e) {
            System.out.println("Error input/output: " + e.toString());
        }

        System.out.println("======================================================================");

        String fileName2 = "test.txt";
        InputStream inStream= null;
        OutputStream outStream = null;
        /**
         * Заполнили буфер миллионом символов, замерили время записи
         */
        /*
        try {
            long timeStart = System.currentTimeMillis();
            outStream = new BufferedOutputStream(new FileOutputStream(fileName2));
            for (int i = 10000000; --i >= 0;) {
                outStream.write(i);
            }
            long time = System.currentTimeMillis() - timeStart;
            System.out.println("Writing time: " + time + " millisec"); // Writing time: 369 millisec
            outStream.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
            e.printStackTrace();
        }
        try { // считываем из потока
            long timeStart = System.currentTimeMillis();
            inStream = new FileInputStream(fileName2);
            while (inStream.read() != -1) { }
            long time = System.currentTimeMillis() - timeStart;
            inStream.close();
            System.out.println("Direct read time: " + (time) + " millisec"); // Direct read time: 13513 millisec
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
            e.printStackTrace();
        }

        try { // считываем из буфера гораздо быстрее, чем из потока
            long timeStart = System.currentTimeMillis();
            inStream = new BufferedInputStream(new FileInputStream(fileName2));
            while (inStream.read() != -1) { }
            long time = System.currentTimeMillis() - timeStart;
            inStream.close();
            System.out.println("Buffered read time: " + (time) + " millisec"); // Buffered read time: 312 millisec
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
            e.printStackTrace();
        }
        */
        System.out.println("======================================================================");
        ByteArrayOutputStream out2 = new ByteArrayOutputStream(); // создаем поток
        try { // Записываем определенного типа данные в поток, в определенной последовательности
            DataOutputStream outData = new DataOutputStream(out2);
            outData.writeByte(128);
            outData.writeInt(128);
            outData.writeLong(128);
            outData.writeDouble(128);
            outData.close();
        } catch (Exception e){
            System.out.println("Impossible IOException occurs: " + e.toString());
            e.printStackTrace();
        }
        try {
            byte[] bytes = out2.toByteArray();
            InputStream in2 = new ByteArrayInputStream(bytes);
            DataInputStream inData = new DataInputStream(in2);
            System.out.println("Reading in the correct sequence: ");
            System.out.println("ReadByte: " + inData.readByte());
            // Если скрыть считывание Byte, то дальше считается всякий бред, порядок крайне важен
            System.out.println("ReadInt: " + inData.readInt());
            System.out.println("ReadLong: " + inData.readLong());
            System.out.println("ReadDouble: " + inData.readDouble());
            inData.close();
        } catch (Exception e) {
            System.out.println("Impossible IOException occurs: " + e.toString());
            e.printStackTrace();
        }

        System.out.println("======================================================================");
        /**
         * В файле cat написали 2 имени
         */
        try (RandomAccessFile catFile = new RandomAccessFile("cat.txt", "rw")){
            FileChannel inChannel = catFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(100);
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead + " bytes");
                // set read mode
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("======================================================================");
    }
}
