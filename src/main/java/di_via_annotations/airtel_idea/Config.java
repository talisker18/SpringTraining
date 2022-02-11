package di_via_annotations.airtel_idea;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//class representing configuration file

@Configuration
@ComponentScan(basePackages= {"springannotations"}) //scan in this package for @Component
public class Config {
	
	//if we do not say primary on the getter, there will be following error: expected single matching bean but found 2: airtel2,getAirtel2
	//so using Primary on the getter, the bean will be injected via getAirtel2(), not the constructor
	
	/*@Bean
	public Airtel2 getAirtel2() {
		return new Airtel2();
	}
	
	@Bean Idea getIdea() {
		return new Idea();
	}*/

}
