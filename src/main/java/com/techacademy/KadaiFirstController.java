package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {
    
    @GetMapping("/dayofweek/{dateStr}")
    public String dispDayOfWeek(@PathVariable String dateStr) {
        String cleanedDateStr = dateStr.replaceAll("\\D", "");
        
        LocalDate date = LocalDate.parse(cleanedDateStr, DateTimeFormatter.BASIC_ISO_DATE);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dayOfWeekName = formatDayOfWeek(dayOfWeek);
        
        return dayOfWeekName;
    }

    private String formatDayOfWeek(DayOfWeek dayOfWeek) {
        String originalName = dayOfWeek.name();
        return Character.toUpperCase(originalName.charAt(0)) + originalName.substring(1).toLowerCase();
    }
    
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2){
        int res = 0;
        res = val1 + val2;
        return "計算結果: " + res;
    }
    
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果: " + res;
    }
    
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果: " + res;
    }
    
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果: " + res;
    }

}
