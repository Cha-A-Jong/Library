package sr.unasat.libraryTest.service;

import sr.unasat.libraryTest.configuration.JPAConfig;
import sr.unasat.libraryTest.entities.BorrowReceipt;
import sr.unasat.libraryTest.repository.BorrowReceiptRepo;

public class BorrowReceiptService {
    private final BorrowReceiptRepo borrowReceiptRepo;

    public BorrowReceiptService(){
        this.borrowReceiptRepo = new BorrowReceiptRepo(JPAConfig.getEntityManager());
    }

    public BorrowReceipt createBorrowReceipt(BorrowReceipt borrowReceipt){
        return borrowReceiptRepo.createBorrowReceipt(borrowReceipt);
    }
    public BorrowReceipt updateBorrowReceipt(BorrowReceipt borrowReceipt) {
        return borrowReceiptRepo.updateBorrowReceipt(borrowReceipt);
    }

    public BorrowReceipt deleteBorrowReceipt(BorrowReceipt borrowReceipt) {
        return borrowReceiptRepo.deleteBorrowReceipt(borrowReceipt);
    }
}
