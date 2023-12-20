package com.gangforcode.mysqlimage.entity;

import jakarta.persistence.*;
@Entity
public class FileObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contentType;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    public FileObj() {
    }
    public FileObj(Long id, String name, String contentType, byte[] data) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

