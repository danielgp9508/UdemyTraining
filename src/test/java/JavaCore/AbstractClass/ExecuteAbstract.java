package JavaCore.AbstractClass;

import org.testng.annotations.Test;

public class ExecuteAbstract {
	
	
	@Test
	public void executeAbstractClass() {
		
		AutomovilGasolina autoGas = new AutomovilGasolina();
		
		autoGas.mantenimiento();
		autoGas.hola();
		
		Motos motos = new Motos();
		motos.mantenimiento();
		motos.hola();
	}
}
