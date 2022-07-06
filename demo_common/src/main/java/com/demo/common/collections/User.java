package com.demo.common.collections;

import lombok.*;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author haohao
 * @date 2022年06月20日 14:29
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparator<User> {
    private String username;
    private Integer age;

    @Override
    public int compare(User o1, User o2) {
        return o2.age.compareTo(o1.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, age);
    }
}
