package com.ntt.challenge.member.enrollment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MemberService {

	@Autowired
	MemberRepository memRepo;

	// Add a new enrollee
	MemberEntity addEnrollee(MemberEntity enrollee) {
		return memRepo.save(enrollee);
	}

	// Modify an existing enrollee
	MemberEntity modifyEnrolee(MemberEntity enrollee) {
		return memRepo.save(enrollee);
	}

	// Remove an enrollee entirely - soft delete to set activation status as FALSE
	void removeEnroleeEntirely(long id) {
		List<MemberEntity> lstMe = memRepo.findAllEnrolleeAndDependents(new Long(id));
		lstMe.stream().forEach(me -> {me.setActivationStatus(false); memRepo.save(me);});
	}

	// Add dependents to an enrollee
	MemberEntity addDependent(MemberEntity dependent) {
		return memRepo.save(dependent);
	}

	// Remove dependents from an enrollee
	void removeDependent(int memberId) {
		memRepo.deleteById(new Long(memberId));
	}

	// Modify existing dependents
	MemberEntity modifyDependent(MemberEntity dependent) {
		return memRepo.save(dependent);
	}


	// Supporting Methods
	List<MemberEntity> findAllEnrolleeAndDependents(long id, String status) {
		return memRepo.findAllEnrolleeAndDependentsWithStatus(id, status);
	}
	// Supporting Methods
	Iterable<MemberEntity> findAll() {
		return memRepo.findAll();
	}
	
	// Supporting Methods
	Optional<MemberEntity> findById(Long id) {
		return memRepo.findById(id);
	}
	
}
