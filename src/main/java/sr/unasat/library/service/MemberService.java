package sr.unasat.library.service;

import sr.unasat.library.configuration.JPAConfig;
import sr.unasat.library.entities.Member;
import sr.unasat.library.repository.MemberRepo;

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


