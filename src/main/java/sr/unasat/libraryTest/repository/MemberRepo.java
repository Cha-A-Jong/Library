package sr.unasat.libraryTest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryTest.entities.Member;

import java.util.List;

public class MemberRepo {

    private EntityManager entityManager;

    public MemberRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // alle records ophalen
    public List<Member> getMembers() {
        String query = "select m from Member m";
        TypedQuery<Member> typedQuery = entityManager.createQuery(query, Member.class);
        List<Member> memberList = typedQuery.getResultList();
        return memberList;
    }

    //invoeren van een record
    public Member createMember(Member member) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(member);
            entityManager.getTransaction().commit();
            System.out.println("Member has been created");
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return member;
    }

    public Member updateMember(Member member){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Member.class, member.getId());
            entityManager.merge(member);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return member;
    }

    public Member deleteMember(Member member) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Member.class, member.getId());
            if (member != null) entityManager.remove(member);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return member;
    }
}




