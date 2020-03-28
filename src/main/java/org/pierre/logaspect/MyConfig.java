package org.pierre.logaspect;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MyConfig {
    public static void main(String[] args) {
        System.out.println("liao");
        System.out.println("miao");
    }
}
