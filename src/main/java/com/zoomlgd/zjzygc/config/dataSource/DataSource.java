package com.zoomlgd.zjzygc.config.dataSource;

import java.lang.annotation.*;

/**
 * @author ldw
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.ZJZYWX;
}
