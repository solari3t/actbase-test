package actbase.code.q2.service;

import org.springframework.stereotype.Service;

@Service
public class RestService {
    public String sayHello(String name){
            name = name.replaceAll("'","");

            if(name.equals("")){
                return "유저 이름을 입력해주세요!";
            }
            return name+"님. 안녕하세요.";
        }
}
