package com.poly.datn.sd08.schedule;

import com.poly.datn.sd08.repositories.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleVoucher {

    @Autowired
    private VoucherRepository voucherRepository;
}
