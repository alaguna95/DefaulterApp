package com.galibox.defaulterApp;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class DefaulterAppApplicationTests {

	@Test
	void verify_module_architecture() {

		var modules = ApplicationModules.of(DefaulterAppApplication.class).verify(); 

		new Documenter(modules) 
				.writeModulesAsPlantUml()
				.writeIndividualModulesAsPlantUml();		
	}

}
