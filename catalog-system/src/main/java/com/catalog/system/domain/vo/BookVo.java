package com.catalog.system.domain.vo;

import com.catalog.common.annotation.Excel;
import com.catalog.common.core.domain.BaseEntity;

/**
 * 图书 Book
 *
 * @author zjd
 * @date 2025-05-09
 */
public class BookVo{

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

    private String textDes;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTextDes() {
        return textDes;
    }

    public void setTextDes(String textDes) {
        this.textDes = textDes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
