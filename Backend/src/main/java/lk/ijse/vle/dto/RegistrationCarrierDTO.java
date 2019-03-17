package lk.ijse.vle.dto;

public class RegistrationCarrierDTO {
    private String submitType;
    private String registrationId;
    private String graduationType;
    private String payType;
    private UndergraduateDetailsDTO underGraduate;
    private PostgraduateDetailsDTO postGraduate;
    private CardPaymentDTO cardPay;
    private CashPaymentDTO cashPay;
    private ChequePaymentDTO chequePay;

    public RegistrationCarrierDTO() {
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getGraduationType() {
        return graduationType;
    }

    public void setGraduationType(String graduationType) {
        this.graduationType = graduationType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public UndergraduateDetailsDTO getUnderGraduate() {
        return underGraduate;
    }

    public void setUnderGraduate(UndergraduateDetailsDTO underGraduate) {
        this.underGraduate = underGraduate;
    }

    public PostgraduateDetailsDTO getPostGraduate() {
        return postGraduate;
    }

    public void setPostGraduate(PostgraduateDetailsDTO postGraduate) {
        this.postGraduate = postGraduate;
    }

    public CardPaymentDTO getCardPay() {
        return cardPay;
    }

    public void setCardPay(CardPaymentDTO cardPay) {
        this.cardPay = cardPay;
    }

    public CashPaymentDTO getCashPay() {
        return cashPay;
    }

    public void setCashPay(CashPaymentDTO cashPay) {
        this.cashPay = cashPay;
    }

    public ChequePaymentDTO getChequePay() {
        return chequePay;
    }

    public void setChequePay(ChequePaymentDTO chequePay) {
        this.chequePay = chequePay;
    }
}
