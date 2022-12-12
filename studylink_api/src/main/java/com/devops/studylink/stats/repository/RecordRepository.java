package com.devops.studylink.stats.repository;

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
}
