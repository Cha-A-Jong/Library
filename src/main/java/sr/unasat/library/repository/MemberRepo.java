package sr.unasat.library.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.library.entities.Member;

import java.util.List;

public class MemberRepo {

//    private EntityManager entityManager;
//
//    public MemberRepo(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    // alle records ophalen
//    public List<Member> getMembers() {
//        String query = "select m from Member m";
//        TypedQuery<Member> typedQuery = entityManager.createQuery(query, Member.class);
//        List<Member> memberList = typedQuery.getResultList();
//        return memberList;
//    }
//
//    //invoeren van een record
//    public Member createMember(Member member) {
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(member);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//        return member;
    }




