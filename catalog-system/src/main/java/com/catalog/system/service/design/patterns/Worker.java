package com.catalog.system.service.design.patterns;

import com.catalog.system.domain.Book;
import com.catalog.system.domain.bo.Ebook;
import com.catalog.system.domain.vo.BookVo;
import org.springframework.beans.BeanUtils;

import java.nio.charset.CharacterCodingException;

/**
 * 二进制存储实现类
 *
 * @author zjd
 * @date 2025-05-09
 */
public class Worker extends Builder {
    private Book book;

    public Worker(){
        this.book = new Ebook();
    }

    @Override
    public Book build(BookVo bookVo) throws CharacterCodingException {

        String textDes = bookVo.getTextDes();
        if (null == textDes){
            return this.book;
        }
        BeanUtils.copyProperties(bookVo, this.book);
        this.book.setFileData(textDes.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        return this.book;
    }

}
