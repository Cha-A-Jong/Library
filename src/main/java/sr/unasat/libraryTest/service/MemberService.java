package sr.unasat.libraryTest.service;

import sr.unasat.libraryTest.configuration.JPAConfig;
import sr.unasat.libraryTest.entities.Member;
import sr.unasat.libraryTest.repository.MemberRepo;

import java.util.List;

public class MemberService {

    private final MemberRepo memberRepo;

    public MemberService(){
        this.memberRepo = new MemberRepo(JPAConfig.getEntityManager());
    }

    public List<Member> getMember(){
        return memberRepo.getMembers();
    }

    public Member createMember(Member member){
        return memberRepo.createMember(member);
    }

    public Member updateMember(Member member) {
        return memberRepo.updateMember(member);
    }

    public Member deleteMember(Member member) {
        return memberRepo.deleteMember(member);
    }
}


