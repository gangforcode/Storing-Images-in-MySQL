package com.gangforcode.mysqlimage.repo;

import com.gangforcode.mysqlimage.entity.FileObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FileRepo extends JpaRepository<FileObj,Long>{
}