package com.catalog.system.domain;

import com.catalog.common.annotation.Excel;
import com.catalog.common.core.domain.BaseEntity;

/**
 * 图书 Book
 *
 * @author zjd
 * @date 2025-05-09
 */
public class Book extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 默认构造函数
     */
    public Book() {
    }

    public Book(String title, Integer type, String author, String isbn, String fileData) {
        this.title = title;
        this.type = type;
        this.author = author;
        this.isbn = isbn;
        this.fileData = fileData;
    }

    public Book(String title, Integer type, String author, String isbn) {
        this.title = title;
        this.type = type;
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * id
     */
    private String id;

    /**
     * 书名
     */
    @Excel(name = "书名")
    private String title;

    /**
     * 类型，默认1:小说，2:科学
     */
    @Excel(name = "类型，默认0：纸质图书，1：电子图书")
    private Integer type;

    /**
     * 电子书存储二进制文件
     */
    @Excel(name = "二进制文件")
    private String fileData;

    /**
     * 作者
     */
    @Excel(name = "作者")
    private String author;

    /**
     * isbn
     */
    @Excel(name = "isbn")
    private String isbn;

    public String displayInfo() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    public String getFileData() {
        return fileData;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
