package study.db.jdbc.connection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class DBConnectionUtilTest {

    @Test
    void 정상적으로_DB에_연결되면_Null이_아닌_커넥션을_반환한다() {
        // when
        Connection connection = DBConnectionUtil.getConnection();

        // then
        assertThat(connection).isNotNull();
    }

}