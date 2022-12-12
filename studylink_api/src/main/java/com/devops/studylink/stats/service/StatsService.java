package com.devops.studylink.stats.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.devops.studylink.stats.repository.RecordRepository;
import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class StatsService {

    private final RecordRepository recordRepository;

    public void saveRecord(Record record) {
        recordRepository.saveRecord( record );
    }

    public Map<String, Float> barchartSecteurSalaire() {

        Map<String, Float> result = new HashMap<>();
        Map<String, List<Float>> histogram = histogramSecteurSalaire();
        if (histogram != null && !histogram.isEmpty()) {
            histogram.entrySet().forEach(
                e -> {
                    result.put( 
                        e.getKey(),
                        e.getValue().stream().reduce( 0f, (a,b) -> a+b )
                    );
                }
            );
        }
        return result;

    }

    public float getSalaireMoyen() {
        List<Record> records = recordRepository.getRecords();
        if ( records == null || records.isEmpty() ) return 0f;
        return records.stream().map(r -> r.getCurrentGrossSalary()).reduce(0f, (a,b) -> a + b) / records.size();
    }

    public Map<String, List<Float>> histogramSecteurSalaire() {

        Map<String, List<Float>> result = new HashMap<>();
        List<Record> records = recordRepository.getRecords();
        if( records != null && !records.isEmpty() ) {
            Set<String> domains = records.stream().map( r -> r.getCurrentCompanyDomain()).collect( Collectors.toSet() );
            domains.forEach(
                d -> {
                    result.put(
                        d,
                        records.stream().filter( r -> r.getCurrentCompanyDomain().equals(d) ).map( r -> r.getCurrentGrossSalary() ).collect(Collectors.toList())
                    );
                }
            );
        }
        return result;

    }

    public Set<String> top3DomainsBySalary() {

        Set<String> result = new HashSet<>();
        Map<String, Float> data = barchartSecteurSalaire();

        if(data != null && !data.isEmpty()) {
            result = data.entrySet().stream().sorted(Map.Entry.comparingByValue()).map( d -> d.getKey() ).limit(3).collect(Collectors.toSet());
        }
        
        return result;

    }    

}
