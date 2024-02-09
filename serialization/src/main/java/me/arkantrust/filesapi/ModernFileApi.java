package me.arkantrust.filesapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.InvalidPathException;

public class ModernFileApi {

    protected String read(String filepath) {

        String data = "";

        try {

            data = Files.readString(Path.of(filepath));

        } catch (IOException e) {

            System.err.println("There was an error while trying to read the file: " + filepath);

        } catch (InvalidPathException e) {

            System.err.println("Invalid path: " + filepath);

        }

        return data;

    }

    protected void write(String filepath, String content) {

        try {

            Files.write(Path.of(filepath), content.getBytes());

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
