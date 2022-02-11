package di_via_annotations.coffee_machine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages= {"coffe_machine"})
public class ConfigClass {
	
	@Primary
	@Bean
	public CoffeMachine getCappuccinoMachine() {
		return new Cappuccino();
	}
	
	@Primary
	@Bean CoffeMachine getEspressoMachine() {
		return new Espresso();
	}
	
}
