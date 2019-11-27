package com.jpa.jpatest;

import com.jpa.jpatest.domain.Address;
import com.jpa.jpatest.domain.Member;
import com.jpa.jpatest.domain.Team;
import com.jpa.jpatest.domain.Zipcode;
import com.jpa.jpatest.repository.MemberRepository;
import com.jpa.jpatest.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTestExample {


    @Autowired
    private  TeamRepository teamRepository;

    @Autowired
    private  MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void jpa_테스트() throws Exception {

        //테스트 결과 무조건 영속성 컨텍스트에 존재해야 테이블 외래키와 매핑할때 기본키를 가진 엔티티를 참조가 가능합니다.
        //이 테스트를 수행하면 처음에 select문이 3번 날라가는 것을 확인할 수 있습니다. 데이터베이스에 이미 존재할 수 도 있기때문에 영속컨텍스트로 가져오고 보는거 같습니다.
        //given
        Team team1 = new Team();
        team1.setId("StartUp");
        team1.setName("스타트업");

        Team team2 = new Team();
        team2.setId("TransFormer");
        team2.setName("트랜슈");

        //when
        //양방향 매핑일때 팀 엔티티에서 회원 엔티티를 참조하려면 마찬가지로.. 회원엔티티가 영속 컨테스트안에 존재해야 합니다.
        teamRepository.save(team1);
        teamRepository.save(team2);


        Member member = new Member();
        member.setId("member1");
        member.setName("임준영");
        member.setAge(28);
        member.setTeam(team1);
        memberRepository.save(member);

        //영속컨텍스트가 열려있으므로 변경감지로 인해 위에 있는 회원 엔티티는 insert 쿼리로 등록 되다가  트랜잭션 커밋전에 변경감지로 인해 아래 회원엔티티는 update 쿼리가 전송됩니다.

        Member newMember = new Member();
        newMember.setId("member2");
        newMember.setAge(31);
        newMember.setName("임광빈");
        newMember.setTeam(team2);

        //팀 엔티티가 영속 컨테스트안에 존재하지 않으면 외래키 매핑이 불가하기 때문에 에러 발생...
        memberRepository.save(newMember);




     }


     @Test
     @Transactional(readOnly = true)
     public void 양방향_매핑_조회_테스트() throws Exception {


         //given
         // 단건 조회시 left outer join을 수행합니다. 글로벌 패치전략은 EAGER로 설정했기 때문입니다.
         Optional<Member> optMember = memberRepository.findById("member1");
         Member findMember = optMember.get();

         System.out.println("*********조회************");
         System.out.println(findMember.getId()+" "+findMember.getName() + " " +  findMember.getAge());
         Team findTeam = findMember.getTeam();
         System.out.println(findTeam.getId() + " " + findTeam.getName());



         List<Member> members = findTeam.getMembers();
         members.stream().forEach(m -> System.out.println(m.getName() + " " +m.getAge() +"욕심쟁이 훗훗훗!"));

         //when

         //then
      }


      @Test
      @Transactional
      @Rollback(false)
      public void 값타입_저장_테스트() throws Exception {

          //given


          //then
       }

}
