package com.catalog.system.service.design.patterns;

import com.catalog.system.domain.Book;
import com.catalog.system.domain.vo.BookVo;

import java.nio.charset.CharacterCodingException;

/**
 * 建造者模式
 *
 * @author zjd
 * @date 2025-05-09
 */
public abstract class Builder {

    /**
     * 保存
     * @param bookVo
     * @return 返回数据转换
     * @throws CharacterCodingException
     */
    abstract Book build(BookVo bookVo) throws CharacterCodingException;

}