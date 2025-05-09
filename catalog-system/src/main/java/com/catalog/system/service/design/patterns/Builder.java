package com.catalog.system.service.design.patterns;

import com.catalog.system.domain.Book;

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
     * @param fileData
     * @return 返回数据转换
     * @throws CharacterCodingException
     */
    abstract Book build(String fileData) throws CharacterCodingException;

}