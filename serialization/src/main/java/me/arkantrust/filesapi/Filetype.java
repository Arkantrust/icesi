package me.arkantrust.filesapi;

public enum Filetype {

    JSON(".json"), XML(".xml"), CSV(".csv"), TXT(".txt");

    // ignored encapsulation on purpose
    public String extension;

    Filetype(String extension) {

        this.extension = extension;

    }

}
