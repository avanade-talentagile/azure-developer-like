package com.example.functions.model;

public class File {

    public File() {
    }

    public File(String fileName, byte[] content) {
        this.fileName = fileName;
        this.content = content;
    }

    private byte[] content;
    private String fileName;

    public byte[] getContent() { return content; }
    public void setContent(byte[] content) { this.content = content; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
}
