package com.newer.automobile.service;

import com.newer.automobile.domain.TestDrive;
import com.newer.automobile.mapper.TestDriveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDriveService {
    @Autowired
    private TestDriveMapper testDriveMapper;

    public int addTestDrive(TestDrive testDrive){
        return testDriveMapper.addTestDrive(testDrive);
    }

    public List<TestDrive> queryAll(Integer startIndex,Integer pageSize){
        return testDriveMapper.queryAll(startIndex, pageSize);
    }

    public int countTid(){
        return testDriveMapper.countTid();
    }
}
