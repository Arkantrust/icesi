package me.arkantrust.filesapi;

import java.io.File;

public class CsvHandler<T> extends FileHandler<T> {

    public CsvHandler(Filetype type, File folder, String filename) {
        super(type, folder, filename);
    }

    public CsvHandler(Filetype type, String filename) {
        super(type, filename);
    }

    @Override
    public T load(Class<?> dataType) {
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    public void save(Object data) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
