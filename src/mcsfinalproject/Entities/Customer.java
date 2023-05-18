package mcsfinalproject.Entities;

import java.util.List;


public class Customer {
    
    private int id;
    private String name;
    private boolean isSeniorCitizen;
    private List<String> check_In_History;
    private List<String> check_Out_History;
    private int IDpaymentItem;
    private List<String> paymentDue;
    private List<Integer> paymentDueQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCheck_In_History() {
        return check_In_History;
    }

    public void setCheck_In_History(List<String> check_In_History) {
        this.check_In_History = check_In_History;
    }

    public List<String> getCheck_Out_History() {
        return check_Out_History;
    }

    public void setCheck_Out_History(List<String> check_Out_History) {
        this.check_Out_History = check_Out_History;
    }

    public int getIDpaymentItem() {
        return IDpaymentItem;
    }

    public void setIDpaymentItem(int IDpaymentItem) {
        this.IDpaymentItem = IDpaymentItem;
    }

    public List<String> getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(List<String> paymentDue) {
        this.paymentDue = paymentDue;
    }

    public List<Integer> getPaymentDueQuantity() {
        return paymentDueQuantity;
    }

    public void setPaymentDueQuantity(List<Integer> paymentDueQuantity) {
        this.paymentDueQuantity = paymentDueQuantity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setIsSeniorCitizen(boolean isSeniorCitizen) {
        this.isSeniorCitizen = isSeniorCitizen;
    }
    
    public Customer()
    {
        
    }
    
}
