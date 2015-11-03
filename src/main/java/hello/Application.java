package hello;

import hello.domain.SUser;
import hello.services.SUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Throwable {
        SpringApplication app = new SpringApplication(Application.class);
        Appctx.ctx=app.run(args);
        SUserService suserService = (SUserService) Appctx.ctx.getBean("suserService");
        SUser su= suserService.findUserById(1);
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
        su.setPassword(bc.encode("111111"));
        suserService.update(su);

    }

}
