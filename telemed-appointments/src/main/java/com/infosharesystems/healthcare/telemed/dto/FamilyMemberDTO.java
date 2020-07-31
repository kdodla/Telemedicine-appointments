package com.infosharesystems.healthcare.telemed.dto;

import lombok.Data;
import lombok.ToString;

@Data@ToString
public class FamilyMemberDTO {

    private String title;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String contactNumber;

    private String gender;

    private String age;

    private String relation;
}
