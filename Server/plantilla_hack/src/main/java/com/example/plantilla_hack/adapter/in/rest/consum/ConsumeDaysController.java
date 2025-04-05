package com.example.plantilla_hack.adapter.in.rest.consum;

import com.example.plantilla_hack.application.port.in.consum.*;
import com.example.plantilla_hack.model.Consum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/carts")
public class ConsumeDaysController {

    private final GetAllDaysUseCase getAllDaysUseCase;
    private final GetConsumSpecificDayUseCase getConsumSpecificDayUseCase;
    private final GetLastMonthUseCase getLastMonthUseCase;
    private final GetLastWeekUseCase getLastWeekUseCase;
    private final GetYesterdayUseCase getYesterdayUseCase;

    public ConsumeDaysController(GetAllDaysUseCase getAllDaysUseCase,
                                  GetConsumSpecificDayUseCase getConsumSpecificDayUseCase,
                                  GetLastMonthUseCase getLastMonthUseCase,
                                  GetLastWeekUseCase getLastWeekUseCase,
                                  GetYesterdayUseCase getYesterdayUseCase) {
        this.getAllDaysUseCase = getAllDaysUseCase;
        this.getConsumSpecificDayUseCase = getConsumSpecificDayUseCase;
        this.getLastMonthUseCase = getLastMonthUseCase;
        this.getLastWeekUseCase = getLastWeekUseCase;
        this.getYesterdayUseCase = getYesterdayUseCase;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Consum>> getAllDays(@RequestParam String email) {
        List<Consum> consumList = getAllDaysUseCase.getAllDays(email);
        return ResponseEntity.ok(consumList);
    }

    @GetMapping("/specific")
    public ResponseEntity<Consum> getConsumSpecificDay(@RequestParam Date date, @RequestParam String email) {
        Consum consum = getConsumSpecificDayUseCase.getConsumSpecificDay(date, email);
        return ResponseEntity.ok(consum);
    }

    @GetMapping("/last-month")
    public ResponseEntity<List<Consum>> getLastMonth(@RequestParam String email) {
        List<Consum> consumList = getLastMonthUseCase.getLastMonth(email);
        return ResponseEntity.ok(consumList);
    }

    @GetMapping("/last-week")
    public ResponseEntity<List<Consum>> getLastWeek(@RequestParam String email) {
        List<Consum> consumList = getLastWeekUseCase.getLastWeek(email);
        return ResponseEntity.ok(consumList);
    }

    @GetMapping("/yesterday")
    public ResponseEntity<Consum> getYesterday(@RequestParam String email) {
        Consum consumList = getYesterdayUseCase.getYesterday(email);
        return ResponseEntity.ok(consumList);
    }
}
