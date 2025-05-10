package com.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author zjd
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BootApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BootApplication.class, args);
        System.out.println("(@@@@@@@--System success \n" +
                "    (_)                     (_)  \n" +
                "    | |   _ _      ___      | |  \n" +
                " _/ |  | ' \\    (_-<     _/ |  |     \n" +
                "  |__/_  |_||_|   /__/_   |__/_       \n" +
                " |\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|         \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
