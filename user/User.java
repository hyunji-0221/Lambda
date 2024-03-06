package user;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString


public class User {
    private Long id;
    private String userName;
    private String password;
    private String passwordCheck;
    private String name;
    private String rrn;
    private String pNum;
    private String address;
    private String job;
    private Double height;
    private Double weight;

@Builder(builderMethodName = "builder")
    public User(String userName, String password, String passwordCheck, String name, String rrn, String pNum, String address, String job, Double height, Double weight) {
        this.userName = userName;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.name = name;
        this.rrn = rrn;
        this.pNum = pNum;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
