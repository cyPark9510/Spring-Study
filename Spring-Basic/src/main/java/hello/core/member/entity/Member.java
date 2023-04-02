package hello.core.member.entity;

import hello.core.member.repository.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {

    private Long id;
    private String name;
    private Grade grade;
}
