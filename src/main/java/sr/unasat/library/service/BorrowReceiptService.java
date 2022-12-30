package sr.unasat.library.service;

import sr.unasat.library.configuration.JPAConfig;
import sr.unasat.library.entities.BorrowReceipt;
import sr.unasat.library.repository.BorrowReceiptRepo;

import java.util.List;

public class BorrowReceiptService {
    private final BorrowReceiptRepo borrowReceiptRepo;

    public BorrowReceiptService(){
        this.borrowReceiptRepo = new BorrowReceiptRepo(JPAConfig.getEntityManager());
    }

    public List<BorrowReceipt> getBorrowReceipt() {return  borrowReceiptRepo.getBorrowreceipt();}

    public BorrowReceipt findBorrowReceiptByReceiptNumber(String receipt_number) {return borrowReceiptRepo.findBorrowReceiptByReceiptNumber(receipt_number);}

    public BorrowReceipt createBorrowReceipt(BorrowReceipt borrowReceipt){ return borrowReceiptRepo.createBorrowReceipt(borrowReceipt);}

    public BorrowReceipt updateBorrowReceipt(BorrowReceipt borrowReceipt) { return borrowReceiptRepo.updateBorrowReceipt(borrowReceipt);}

    public BorrowReceipt deleteBorrowReceipt(BorrowReceipt borrowReceipt) { return borrowReceiptRepo.deleteBorrowReceipt(borrowReceipt);}
}
