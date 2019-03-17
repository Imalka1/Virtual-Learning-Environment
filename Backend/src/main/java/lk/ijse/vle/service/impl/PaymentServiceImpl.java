package lk.ijse.vle.service.impl;

import lk.ijse.vle.dto.PaymentDTO;
import lk.ijse.vle.repository.StudentCardPaymentRepository;
import lk.ijse.vle.repository.StudentCashPaymentRepository;
import lk.ijse.vle.repository.StudentChequePaymentRepository;
import lk.ijse.vle.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private StudentChequePaymentRepository studentChequePaymentRepository;
    @Autowired
    private StudentCardPaymentRepository studentCardPaymentRepository;
    @Autowired
    private StudentCashPaymentRepository studentCashPaymentRepository;

    @Override
    public ArrayList<PaymentDTO> getPaymentData(String regId) {
        ArrayList<PaymentDTO> paymentDTOS = new ArrayList<>();
        List<Object[]> cardPaymentData = studentCardPaymentRepository.getPaymentData(regId);
        List<Object[]> cashPaymentData = studentCashPaymentRepository.getPaymentData(regId);
        List<Object[]> chequePaymentData = studentChequePaymentRepository.getPaymentData(regId);
        for (Object[] cardPayment : cardPaymentData) {
            setPaymentDto(cardPayment, paymentDTOS, "Card");
        }
        for (Object[] cashPayment : cashPaymentData) {
            setPaymentDto(cashPayment, paymentDTOS, "Cash");
        }
        for (Object[] chequePayment : chequePaymentData) {
            setPaymentDto(chequePayment, paymentDTOS, "Cheque");
        }
        return paymentDTOS;
    }

    private void setPaymentDto(Object[] payment, ArrayList<PaymentDTO> paymentDTOS, String payMethod) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPayId("P" + payment[0].toString());
        paymentDTO.setTotalFee(Double.parseDouble(payment[1].toString()));
        paymentDTO.setPaid(Double.parseDouble(payment[2].toString()));
        paymentDTO.setDate(payment[3].toString());
        paymentDTO.setPayMethod(payMethod);
        paymentDTOS.add(paymentDTO);
    }
}
