package study.db.jdbc.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.db.jdbc.domain.Member;

import java.sql.SQLException;

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

}