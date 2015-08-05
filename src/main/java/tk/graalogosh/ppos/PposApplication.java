package tk.graalogosh.ppos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PposApplication {

    public static void main(String[] args) {
        SpringApplication.run(PposApplication.class, args);
    }
}
