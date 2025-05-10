package com.catalog.system.service.design.patterns;

import com.catalog.system.domain.Book;
import com.catalog.system.domain.bo.PaperBook;
import com.catalog.system.domain.vo.BookVo;
import org.springframework.beans.BeanUtils;

import java.nio.charset.CharacterCodingException;

/**
 * 工厂模式
 *
 * @author zjd
 * @date 2025-05-09
 */
public class BookFactory {

    public static Book createBook(BookVo bookVo) throws CharacterCodingException {

        switch (bookVo.getType()) {
            case 0:
                //普通纸质书
                Book book= new PaperBook();
                //Prototype Copy
                BeanUtils.copyProperties(bookVo, book);
                return book;
            case 1:
                //电纸书
                Worker worker = new Worker();
                return worker.build(bookVo);

            default:
                throw new IllegalArgumentException("Unknown book type");

        }

    }

}
