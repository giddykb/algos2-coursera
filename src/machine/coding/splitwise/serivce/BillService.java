package machine.coding.splitwise.serivce;

import machine.coding.splitwise.entity.Bill;
import machine.coding.splitwise.entity.Group;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/04/19
 * Time:    11:35 PM
 */
public interface BillService {

  long addBill(Bill bill);

  boolean updateBill(Bill bill);

  boolean deleteBill(Integer billId);

  List<Bill> getAllBills();

  List<Bill> getAllBillsForGroup(Group group);

  List<Bill> getBill(Integer billId);


}
