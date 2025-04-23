package study.db.jdbc.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.db.jdbc.domain.Member;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void 회원이_DB에_정상적으로_저장된다() throws SQLException {
        // given
        Member member = new Member("member V0", 10000);
        repository.save(member);

        // when
        Member fetchedMember = repository.findById(member.getMemberId());

        // then
        Assertions.assertThat(fetchedMember).isEqualTo(member);
    }

    @Test
    void 회원이_가진_금액이_정상적으로_업데이트된다() throws SQLException {
        // given
        String memberId = "member V0";
        int money = 20000;

        // when
        repository.update(memberId, money);
        Member fetchedMember = repository.findById(memberId);

        // then
        Assertions.assertThat(fetchedMember.getMoney()).isEqualTo(money);
    }

    @Test
    void 회원이_DB에서_정상적으로_삭제된다() throws SQLException {
        // given
        String memberId = "member V0";

        // when
        repository.delete(memberId);

        // then
        assertThrows(NoSuchElementException.class, () -> {
            repository.findById(memberId);
        });
    }

}