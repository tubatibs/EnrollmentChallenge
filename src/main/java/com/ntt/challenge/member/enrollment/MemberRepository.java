package com.ntt.challenge.member.enrollment;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableAutoConfiguration
@Repository

public interface MemberRepository extends CrudRepository<MemberEntity, Long> {
	
	  @Query("select MEM from MEMBER MEM where MEM.id=?1 or MEM.eId=?1")
	  List<MemberEntity> findAllEnrolleeAndDependents(long id);
	  
	  @Query("select MEM from MEMBER MEM where (MEM.id=?1 or MEM.eId=?1) and activationStatus=?2")
	  List<MemberEntity> findAllEnrolleeAndDependentsWithStatus(long id, String status);
	  
	  @Query("select MEM from MEMBER MEM where name=?1")
	  MemberEntity findByName(String name);


}
