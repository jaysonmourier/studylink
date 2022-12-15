package com.devops.studylink.stats.repository;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.devops.studylink.stats.repository.entities.RecordEntity;
import com.devops.studylink.stats.service.Record;
import com.devops.studylink.stats.service.RecordDao;

@Service
public class RecordRepository {
    
    private final RecordDao recordDao;
    public RecordRepository(RecordDao recordDao) {
        this.recordDao = recordDao;
    }
    public void saveRecord(Record record) {
        recordDao.save( new RecordEntity( record ) );
    }
    public List<Record> getRecords() {
        return recordDao.findAll().stream().map( r -> Record.create(r) ).collect(Collectors.toList());
    }
}
