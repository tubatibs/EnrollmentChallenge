package com.ntt.challenge.member.enrollment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes=EnrollmentApplication.class)
@ComponentScan
class EnrollmentApplicationTests {

	Logger logger = LoggerFactory.getLogger(EnrollmentApplicationTests.class);
	
	@Autowired
	MemberRepository memRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testFindAllMembers() {
		Iterable<MemberEntity> enrolleesRes = memRepo.findAll();
		enrolleesRes.forEach(me -> {logger.info(me.toString());});
		assertNotNull(enrolleesRes);
	}
	@Test
	public void testAddEnrollee() {
		MemberEntity enrolleeReq = new MemberEntity();
		enrolleeReq.setName("SPRING TEST");
		enrolleeReq.setActivationStatus(true);
		enrolleeReq.setDateOfBirth(new Date(System.currentTimeMillis()));
		enrolleeReq.setEId(0);
		enrolleeReq.setType("ENROLLEE");
		enrolleeReq.setPhone("000-000-0000");
		MemberEntity enrolleeRes = memRepo.save(enrolleeReq);
		logger.info("testAddEnrollee "+ enrolleeRes.toString());
		assertNotNull(enrolleeRes);
	}
	@Test
	public void testFindAllMembersAfterAddEnrollee() {

		Iterable<MemberEntity> enrolleesRes = memRepo.findAll();
		enrolleesRes.forEach(me -> {logger.info(me.toString());});
		assertNotNull(enrolleesRes);
	}
	@Test
	public void testModifyEnrolee() {

		MemberEntity enrolleesReq = memRepo.findById(new Long(1)).orElse(null);

		if (logger.isInfoEnabled() && enrolleesReq != null) {			
			assertEquals(enrolleesReq.getName(), "JOHN SMITH");
			enrolleesReq.setName("JOHN ANTONY SMITH");
			MemberEntity enrolleeRes = memRepo.save(enrolleesReq);
			logger.info("testModifyEnrolee "+enrolleeRes);
			assertEquals(enrolleeRes.getName(), "JOHN ANTONY SMITH");
		}
	}
	
	@Test
	public void testRemoveEnroleeEntirely() {
		List<MemberEntity> lstMe = memRepo.findAllEnrolleeAndDependents(new Long(4));
		lstMe.forEach(me -> {logger.info("testRemoveEnroleeEntirely After soft delete" +me.toString());});
		lstMe.stream().forEach(me -> {me.setActivationStatus(false); memRepo.save(me);});
		
		List<MemberEntity> lstMeAfter = memRepo.findAllEnrolleeAndDependents(new Long(4));
		lstMeAfter.forEach(me -> {logger.info("testRemoveEnroleeEntirely After soft delete" +me.toString());});
		lstMeAfter.forEach(me -> {assertFalse(me.isActivationStatus());});

	}
	
	@Test
	public void testAddDependent() {
		MemberEntity enrolleesReq = memRepo.findById(new Long(1)).orElse(null);
		MemberEntity dependentReq = new MemberEntity();
		dependentReq.setName("ANNAMERY JOHN SMITH");
		dependentReq.setActivationStatus(true);
		dependentReq.setDateOfBirth(new Date(System.currentTimeMillis()));
		dependentReq.setEId((new Long(enrolleesReq.getId())).intValue());
		dependentReq.setType("DEPENDENT");
		dependentReq.setPhone("000-123-0000");
		MemberEntity dependentRes = memRepo.save(dependentReq);
		assertEquals(dependentRes.getName(), "ANNAMERY JOHN SMITH");

		List<MemberEntity> lstMeAfter = memRepo.findAllEnrolleeAndDependents(new Long(1));
		lstMeAfter.forEach(me -> {logger.info("testAddDependent After adding dependent " +me.toString());});
	}
	
	
	@Test
	public void testSoftRemoveDependent() {
		MemberEntity dependentReq = memRepo.findByName("LISA SMITH");
		dependentReq.setActivationStatus(false);
		MemberEntity dependentRes = memRepo.save(dependentReq);
		assertFalse(dependentRes.isActivationStatus());
	}
	
	
	@Test
	public void testModifyDependent() {
		MemberEntity dependentReq = memRepo.findByName("LISA SMITH");
		dependentReq.setActivationStatus(true);
		dependentReq.setPhone("111-222-3333");
		MemberEntity dependentRes = memRepo.save(dependentReq);
		assertTrue(dependentRes.isActivationStatus());
	}
	
	
	//@Test
	public void testHardRemoveDependent() {
		MemberEntity dependentReq = memRepo.findByName("LISA SMITH");
		memRepo.delete(dependentReq);
		MemberEntity dependentRes = memRepo.findByName("LISA SMITH");
		assertNull(dependentRes);
	}
}
