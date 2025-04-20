package study.db.jdbc.connection;

/**
 * 상수들만 있기 때문에 인스턴스를 생성하지 못하게 추상 클래스로 만든다.
 */
public abstract class ConnectionConst {
    public static final String URL = "jdbc:h2:tcp://localhost/~/test";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
}