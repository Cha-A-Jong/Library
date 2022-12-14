package sr.unasat.library.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.library.entities.BorrowReceipt;
import sr.unasat.library.entities.Member;

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

    public Member findMemberByLastName (String lastname){
        entityManager.getTransaction().begin();
        String query = "select m from Member m where m.lastname = :lastname";
        TypedQuery<Member> typedQuery = entityManager.createQuery(query, Member.class);
        Member member = typedQuery.setParameter("lastname", lastname).getSingleResult();
        entityManager.getTransaction().commit();
        return member;
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




