package sr.unasat.libraryTest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryTest.entities.Book;
import sr.unasat.libraryTest.entities.BorrowReceipt;

import java.util.List;

public class BorrowReceiptRepo {

    private EntityManager entityManager;

    public BorrowReceiptRepo(EntityManager entityManager) {this.entityManager = entityManager;}

    public List<BorrowReceipt> getBorrowreceipt(){
        String query = "select br from BorrowReceipt br";
        TypedQuery<BorrowReceipt> typedQuery = entityManager.createQuery(query, BorrowReceipt.class);
        List<BorrowReceipt> borrowReceiptList = typedQuery.getResultList();
        return borrowReceiptList;
    }

//    public Book findBookByBorrowReceipt(String book) {
//        String query = "select br from BorrowReceipt br join br.";
//        TypedQuery<BorrowReceipt> typedQuery = entityManager.createQuery(query, BorrowReceipt.class);
//        List<BorrowReceipt> borrowReceiptList = typedQuery.setParameter("title", book).getResultList();
//        BorrowReceipt borrowReceipt = null;
//        if (!borrowReceiptList.isEmpty()){
//            borrowReceipt = borrowReceiptList.get(0);
//        } else {
//            System.out.println("No book found");
//        }
//        return borrowReceipt;
//    }

    public BorrowReceipt createBorrowReceipt(BorrowReceipt borrowReceipt) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(borrowReceipt);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrowReceipt;
    }


    public BorrowReceipt updateBorrowReceipt(BorrowReceipt borrowReceipt){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(BorrowReceipt.class, borrowReceipt.getId());
            entityManager.merge(borrowReceipt);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return borrowReceipt;
    }

    public BorrowReceipt deleteBorrowReceipt(BorrowReceipt borrowReceipt) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(BorrowReceipt.class, borrowReceipt.getId());
            if (borrowReceipt != null) entityManager.remove(borrowReceipt);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return borrowReceipt;
    }

}
