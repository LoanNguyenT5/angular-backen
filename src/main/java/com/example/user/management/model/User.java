package com.example.user.management.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String loginName;
    private boolean customProfile;
    private String template;
    private List<String> roles;
    private Instant createdOn;
}
