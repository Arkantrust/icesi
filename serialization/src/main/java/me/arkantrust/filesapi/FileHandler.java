package me.arkantrust.filesapi;

import java.io.File;
import java.io.IOException;

public abstract class FileHandler<T> {

    protected final char separator = File.separatorChar;

    protected File folder;
    protected File file;

    /**
     * 
     * This constructor will save the file to the specified folder as a path.
     * 
     * @param type     Type of the file to be saved
     * @param folder   Folder to save the file. e.g. {@code "/home/user/Documents"}
     * @param filename Name of the file to be saved without starting slash nor
     *                 extension. e.g. {@code "users"}
     * 
     *                 The path and the file extension will be set automatically to
     *                 avoid parsing errors.
     * 
     * @see Filetype
     */
    public FileHandler(Filetype type, File folder, String filename) {

        if (!folder.exists()) {

            throw new IllegalArgumentException("Folder does not exist: " + folder.getAbsolutePath());

        }

        this.folder = folder;

        // file path
        String path = folder.getAbsolutePath() + separator + filename + type.extension;
        file = new File(path);

        validate();

    }

    /**
     * 
     * This constructor will save the file to the
     * {@code project/src/main/resources/data} folder
     * 
     * @param type     Type of the file to be saved
     * @param filename Name of the file to be saved without starting slash. e.g.
     *                 {@code "users"}
     * 
     *                 The file extension will be set automatically to avoid parsing
     *                 errors.
     * 
     * @see Filetype
     */
    public FileHandler(Filetype type, String filename) {

        String path = System.getProperty("user.dir");

        // folder path
        path += separator + "src" + separator + "main" + separator + "resources" + separator + "data";
        folder = new File(path);

        // file path
        path += separator + filename + type.extension;
        file = new File(path);

        validate();

    }

    public FileHandler(Filetype type, File folder, String filename, T data) {

        this(type, folder, filename);

    }

    public FileHandler(Filetype type, String filename, T data) {

        this(type, filename);

    }

    private void validate() {

        if (!folder.exists()) {

            folder.mkdir();

            if (!file.exists()) {

                try {

                    file.createNewFile();

                } catch (IOException e) {

                    // TODO: Validate this message looks correct
                    String msg = "Could not create file: " + file.getName() + "\nin folder: " + folder.getAbsolutePath()
                            + "\ndue to: " + e.getMessage();

                    System.err.println(msg);

                }
            }
        }
    }

    public abstract T load(Class<?> dataType);

    public abstract void save(T data);

}