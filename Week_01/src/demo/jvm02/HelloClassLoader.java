package demo.jvm02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;
/**
 * @ClassName: HelloClassLoader
 * @Description: TODO
 * @author: randomzhang
 * @date: 2020/10/18  21:28
 */
public class HelloClassLoader extends ClassLoader{
    public static void main(String[] args) {
        try{
            Class<?> clazz = new HelloClassLoader().findClass("Hello");
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("hello");
            method.invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(this.getClass().getResource("Hello.xlass").getPath());
        long fileSize = file.length();
        byte[] buffer = new byte[(int) fileSize];
        try {
            FileInputStream fi=new FileInputStream(file);
            fi.read(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte)(255-buffer[i]);
        }
        return defineClass(name, buffer, 0, buffer.length);
    }

    private byte[] decode(String helloBase64) {
        return Base64.getDecoder().decode(helloBase64);
    }
}
