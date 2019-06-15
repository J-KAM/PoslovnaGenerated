package com.uni.jelenaiana.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;

public class JavaClassGenerator {

    public static void create(String className, String classPackage, StringWriter writer) {
        String workingDir = System.getProperty("user.dir");
        if (!workingDir.endsWith("/")) workingDir += "/";
        workingDir += "src/main/generated/";
        workingDir += classPackage.replace(".", "/");
        File file = new File(workingDir + "/" + className + ".java");
        file.getParentFile().mkdirs();
        try (FileOutputStream fop = new FileOutputStream(file)) {
            if (!file.exists()) file.createNewFile();
            fop.write(writer.toString().getBytes(Charset.forName("UTF-8")));
            fop.flush();
            fop.close();
            System.out.println("Created class " + className);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
