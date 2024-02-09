package me.arkantrust.filesapi;

import java.io.File;

import com.google.gson.Gson;

public class JsonHandler<T> extends FileHandler<T> {

    public JsonHandler(File folder, String filename) {

        super(Filetype.JSON, folder, filename);

    }

    public JsonHandler(String filename) {

        super(Filetype.JSON, filename);

    }

    public JsonHandler(File folder, String filename, T data) {

        super(Filetype.JSON, folder, filename);

    }

    public JsonHandler(String filename, T data) {

        super(Filetype.JSON, filename);

    }

    @Override
    public void save(T data) {

        String json = new Gson().toJson(data);

        new LegacyFileApi().write(this.file, json);

    }

    @Override
    @SuppressWarnings("unchecked")
    public T load(Class<?> dataType) {

        String json = new LegacyFileApi().read(this.file);

        return (T) new Gson().fromJson(json, dataType.getClass());

    }

}
