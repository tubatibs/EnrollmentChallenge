package com.ntt.challenge.member.enrollment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memService ;
	
	// Add a new enrollee
	MemberEntity addEnrollee(MemberEntity enrollee) {
		return memService.addEnrollee(enrollee);
	}

	// Modify an existing enrollee
	MemberEntity modifyEnrolee(MemberEntity enrollee) {
		return memService.modifyEnrolee(enrollee);
	}

	// Remove an enrollee entirely - soft delete to set activation status as FALSE
	void removeEnroleeEntirely(long id) {
		memService.removeEnroleeEntirely(id);
	}

	// Add dependents to an enrollee
	MemberEntity addDependent(MemberEntity dependent) {
		return memService.addDependent(dependent);
	}

	// Remove dependents from an enrollee
	void removeDependent(int memberId) {
		memService.removeDependent(memberId);
	}

	// Modify existing dependents
	MemberEntity modifyDependent(MemberEntity dependent) {
		return memService.modifyDependent(dependent);
	}


	// Supporting Methods
	List<MemberEntity> findAllEnrolleeAndDependents(long id, String status) {
		return memService.findAllEnrolleeAndDependents(id, status);
	}


}
