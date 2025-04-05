package com.example.plantilla_hack.application.port.in.consum;

import com.example.plantilla_hack.model.Consum;

public interface GetYesterdayUseCase {

    Consum getYesterday(String email);
}
