package com.leprechauns.main.Entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ChanceList {
     public static List<Map<Object, Object>> chanceList(List<Object[]> results, String... fields) {
        List<Map<Object, Object>> chanceResults = new ArrayList<>();
    
        for (Object[] result : results) {
            Map<Object, Object> entry = new LinkedHashMap<>();
            for (int i = 0; i < fields.length; i++) {
                entry.put(fields[i], result[i]);
            }
            chanceResults.add(entry);
        }

        return chanceResults;
    }
}