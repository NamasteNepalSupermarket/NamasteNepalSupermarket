/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs544.waa.nns.util;

import com.cs545.waa.nns.model.Category;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author GMaharjan
 */
public class Utility {

    public static Date getCurrentDate() {
        return new Date();
    }

    public static boolean saveImageFile(Category category) {
        boolean saved = false;

        if (category.getImage_file().getSize() > 0) {
            try {
                InputStream input = category.getImage_file().getInputstream();

                //creating the directory to store file
                // String rootPath = System.getProperty("catalina.home");
                ClassLoader c = Utility.class.getClassLoader();
                URLClassLoader u = (URLClassLoader) c;
                URL[] urls = u.getURLs();
                String path = "";
                for (URL i : urls) {
                    if (i.toString().contains("WEB-INF")) {
                        path = i.toString();
                        System.out.println("url: " + i);
                        break;
                    }

                }
                String tokens[] = path.split("WEB-INF");
                path = tokens[0];
                path = path.replaceFirst("file:", "");
                File categoryDir = new File(path + File.separator + "resources" + File.separator + "uploads" + File.separator + "img" + File.separator + "category");

                if (!categoryDir.exists()) {
                    categoryDir.mkdirs();
                }
                //create the file on server
                File serverFile = new File(categoryDir.getAbsolutePath() + File.separator + category.getImage_file().getFileName());
            
                try (BufferedOutputStream videoStream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    videoStream.write(IOUtils.toByteArray(input));
                }
                saved = true;
                System.out.println("You successfully uploaded " + category.getImage_file().getFileName());
            } catch (Exception e) {
                System.out.println(" Failed to upload ");
            }
        } else {
            System.out.println("Failed to upload " + category.getImage() + " because the file was empty.");
        }
        return saved;
    }

}
