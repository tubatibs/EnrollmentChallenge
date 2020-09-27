package com.ntt.challenge.member.enrollment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.ComponentScan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "MEMBER")
@Entity
@NoArgsConstructor
@ConstructorBinding
@ComponentScan(basePackages = "com.ntt.challenge.member.enrollment")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@NotNull
	@Setter
	@Getter
	private int id;

	@Column(name = "NAME")
	@NotNull(message = "Enrollee/Dependent name can not be null")
	@Setter
	@Getter
	private String name;

	@Column(name = "ACTIVATION_STATUS")
	@NotNull(message = "Enrollee/Dependent activationStatus can not be null")
	@Setter
	@Getter
	private boolean activationStatus;

	@Column(name = "BIRTH_DATE")
	@NotNull(message = "Enrollee/Dependent dateOfBirth can not be null")
	@Setter
	@Getter
	private Date dateOfBirth;

	@Column(name = "PHONE")
	@Setter
	@Getter
	private String phone;

	@Column(name = "TYPE")
	@Setter
	@Getter
	private String type;

	@Column(name = "E_ID")
	@Setter
	@Getter
	private int eId;

	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", name=" + name + ", activationStatus=" + activationStatus + ", dateOfBirth="
				+ dateOfBirth + ", phone=" + phone + ", type=" + type + ", eId=" + eId + "]";
	}

	public MemberEntity(@NotNull int id, @NotNull(message = "Enrollee/Dependent name can not be null") String name,
			@NotNull(message = "Enrollee/Dependent activationStatus can not be null") boolean activationStatus,
			@NotNull(message = "Enrollee/Dependent dateOfBirth can not be null") Date dateOfBirth, String phone,
			String type, int eId) {
		super();
		this.id = id;
		this.name = name;
		this.activationStatus = activationStatus;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.type = type;
		this.eId = eId;
	}

}
