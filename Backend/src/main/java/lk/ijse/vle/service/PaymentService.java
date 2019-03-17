package lk.ijse.vle.service;

import lk.ijse.vle.dto.PaymentDTO;

import java.util.ArrayList;

public interface PaymentService {
    ArrayList<PaymentDTO> getPaymentData(String regId);
}
