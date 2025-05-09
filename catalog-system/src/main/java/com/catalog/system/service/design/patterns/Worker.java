package com.catalog.system.service.design.patterns;

import com.catalog.system.domain.Book;
import com.catalog.system.domain.bo.Ebook;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/**
 * 二进制存储实现类
 *
 * @author zjd
 * @date 2025-05-09
 */
public class Worker extends Builder {
    Book book;

    public Worker(){
        book = new Ebook();
    }

    @Override
    public Book build(String fileData) throws CharacterCodingException {

        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder encoder = charset.newEncoder()
                .onMalformedInput(CodingErrorAction.REPLACE)
                .onUnmappableCharacter(CodingErrorAction.REPLACE);
        CharBuffer charBuffer = CharBuffer.allocate(fileData.length());
        charBuffer.put(fileData);
        charBuffer.flip();
        ByteBuffer buff = encoder.encode(charBuffer);

        while (buff.hasRemaining()) {
            byte b = buff.get();
            String binary = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            book.setFileData(binary);
        }

        return this.book;
    }

}
