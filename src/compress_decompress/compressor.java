package compress_decompress;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
public class compressor {

    public static void method(File file) throws IOException {
        String fileParent = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileParent+"\\compressfile.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        byte []buffer = new byte[1024];
        int len;

        while((len=fis.read(buffer)) != -1){
            gzip.write(buffer,0, len);
        }
        gzip.finish();
        fis.close();
        fos.close();
        gzip.close();
    }
    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\Ujjwal Singh\\Desktop\\Project\\test");
        method(path);
    }
}
