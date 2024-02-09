package me.arkantrust.filesapi;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

public class LegacyFileApi {

    public void write(File file, String data) {

        // File: folder --> abstract representation of the folder in the OS
        // FileOutputStream: fos --> actual connection between the file and jvm
        // BufferWriter: writer --> writes the java String to actual text in the file
        try (var link = new FileOutputStream(file);
                var writer = new BufferedWriter(new OutputStreamWriter(link))) {

            writer.write(data);

            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String read(File file) {

        StringBuilder sb = new StringBuilder();

        // File: folder --> abstract representation of the folder in the OS
        // FileOutputStream: fos --> actual connection between the file and jvm
        // BufferWriter: writer --> writes the java String to actual text in the file
        try (var link = new FileInputStream(file);
                var reader = new BufferedReader(new InputStreamReader(link))) {

            // Read the content of the file directly into a string
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }

}
