package com.ssg.w1.todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

// ConnectionUtil 클래스는 하나의 객체를 만들어서 사용하는 방식
// HikariConfig를 이용해서 하나의 HikariDataSource를 구성한다.
// 구성된 HikariDataSource는 getConnection()을 통해서 사용된다.
// 외부에서는 ConnectionUtil.INSTANCE.getConnection()을 통해 Connection을 받을 수 있다.
public enum ConnectionUtil {
    INSTANCE;

    private HikariDataSource ds;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/ssg?serverTimezone=UTC");
        config.setUsername("webuser");
        config.setPassword("1234"); // git에 바로 올리면 털리니까 ignore처리 잘해서 올리자
        config.addDataSourceProperty("cachePrespStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
