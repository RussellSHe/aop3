package AopCase.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ProjectName: aop2
 * @Package: AopCase.domain
 * @ClassName: Account
 * @Description:
 * @Author: zengyanbo
 * @CreateDate: 2019-04-27 21:15
 * @UpdateDate: 2019-04-27 21:15
 * @Version: 1.0
 */
@Component
public class Account implements Serializable {
    private int id;
    private String name;
    private float money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", moeny=" + money +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getMoney() {
        return money;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(float moeny) {
        this.money = moeny;
    }
}
