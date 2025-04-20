package study.db.jdbc.repository;

import lombok.extern.slf4j.Slf4j;
import study.db.jdbc.connection.DBConnectionUtil;
import study.db.jdbc.domain.Member;

import java.sql.*;

/**
 * JDBC의 DriverManager를 사용한다.
 */
@Slf4j
public class MemberRepositoryV0 {

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null; // Statement의 하위 클래스로, 파라미터를 바인딩하는 추가 기능을 가진다.

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql); // 데이터베이스에 전달할 SQL과 파라미터로 전달할 데이터들을 준비한다.

            preparedStatement.setString(1, member.getMemberId());
            preparedStatement.setInt(2, member.getMoney());
            preparedStatement.executeUpdate(); // 커넥션을 통해 SQL을 실제 데이터베이스에 전달한다.

            return member;
        } catch (SQLException e) {
            log.error("database error", e);
            throw e;
        } finally {
            close(connection, preparedStatement, null); // 예외 발생 여부와 관계 없이 항상 리소스를 정리해야 한다.
        }
    }

    /**
     * 역순으로 리소스를 정리한다.
     */
    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                log.error("close error", e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                log.error("close error", e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("close error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }

}