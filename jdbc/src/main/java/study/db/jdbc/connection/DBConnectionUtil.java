package study.db.jdbc.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static study.db.jdbc.connection.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {

    /**
     * DriverManager는 등록된 드라이버 중 요청을 처리할 수 있는 드라이버를 찾아 연결을 시도하고, 성공하면 커넥션 객체를 반환한다.
     */
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("connection={}, class={}", connection, connection.getClass());
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException(e); // Checked Exception을 Runtime Exception으로 변환한다.
        }
    }

}