package org.makovoz.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String login;
    private String password;
}
