import javax.swing.JOptionPane;


public class ConversorChallenge {
	public static void main(String[] args) {
		IniciaPrograma();	
	}
	
	private static void IniciaPrograma() {
		String [] opciones = {"Divisas", "Temperatura"};
		String opcion = OptionCombo("Selecciona un conversor", "Conversor Alura", opciones);
			try {
				TipoConversion(opcion);	
			} catch (NullPointerException e) {
				PreguntarContinuar();
			}		
	}
	
	 private static void TipoConversion(String opcion) {	 		 
		 switch (opcion) {
		 case "Temperatura":
			 String [] temperaturas = {"Fahrenheit a Celsius", "Celsius a Fahrenheit"};
			 String temperatura = OptionCombo("Selecciona una opción", "Conversor Alura", temperaturas);
			 if (temperatura != null) {
				 ConversorTemperatura(temperatura);
				}	
			 else {PreguntarContinuar();}				 
			 break;			 
		 
		 case "Divisas":
		 	 String [] monedas = {"De pesos a otra divisa", "De otra divisa a pesos"};
			 String moneda = OptionCombo("Selecciona una opción", "Conversor Alura", monedas);
			 if (moneda != null) {
				 ConversorMoneda(moneda);}	
			 else {PreguntarContinuar();}
			 break; 
		 }	
	 }
	

	 private static void ConversorTemperatura(String temperatura){
		 
		 try {
			 double cantidad = Double.parseDouble(JOptionPane.showInputDialog
						(null,"Cantidad a convertir",0));
			 double grados = 0;
			 
			 if (temperatura == "Fahrenheit a Celsius") {
				grados = (cantidad -32) * 5/9;
				MostrarMensaje(grados, " celsius" );
			 }
			 else {
				 grados = (cantidad * 9/5) + 32;
				 MostrarMensaje(grados, "Fahrenheit" );
			 }
			 PreguntarContinuar();
			
		} catch (NumberFormatException e) {
			MostrarMensaje("Dato inválido, ingresar de nuevo la cantidad");
			ConversorTemperatura(temperatura);
			
		}
		 
		 
		 
	 } 
	 
	 private static void ConversorMoneda(String opcion){
		 String [] divisas = {" Dólares", " Yenes", " Libras", " Euros", " Wones"};
		 String divisa = OptionCombo("Selecciona la divisa", "Conversor Alura", divisas);
		 
		 try {

			 double cantidad = Double.parseDouble(JOptionPane.showInputDialog
						(null,"Cantidad a convertir",0));
			 double conversion = 0;
			 
			if (opcion == "De pesos a otra divisa" ) {
				switch (divisa) {
				case " Dólares":
					conversion = cantidad * 0.059;
					break;
				case " Yenes":
					conversion = cantidad * 8.51;
					break;
				case " Libras":
					conversion = cantidad * 0.046;
					break;
				case " Euros":
					conversion = cantidad * 0.054;
					break;
				case " Wones":
					conversion = cantidad * 78.14;
					break;
				}
				
			}
			else {
				switch (divisa) {
				case " Dólares":
					conversion = cantidad * 17.03;
					break;
				case " Yenes":
					conversion = cantidad * 0.12;
					break;
				case " Libras":
					conversion = cantidad * 21.57;
					break;
				case " Euros":
					conversion = cantidad * 18.61;
					break;
				case " Wones":
					conversion = cantidad * 0.013;
					break;
				}
				divisa = " Pesos";
				
			}
			MostrarMensaje( conversion, divisa);
			PreguntarContinuar();
			
		} catch (NumberFormatException e) {
			MostrarMensaje("Dato inválido, ingresar de nuevo la cantidad");
			ConversorMoneda(opcion);		
		}
	 }
	 
	private static String OptionCombo(String pregunta, String titulo, String [] lista){
		 return (String) JOptionPane.showInputDialog(null,pregunta, 
				 titulo,JOptionPane.QUESTION_MESSAGE,null,lista, lista[0]);
	}

	private static void MostrarMensaje( String mensaje) {
		 JOptionPane.showMessageDialog(null, mensaje);
	};
	
	private static void MostrarMensaje(Double mensaje, String mensaje1) {
		 JOptionPane.showMessageDialog(null, mensaje + mensaje1);
	};
	
	private static void PreguntarContinuar(){
		int pregunta;
		pregunta = JOptionPane.showConfirmDialog(null,"Deseas realizar otra conversión", "Conversor Alura",
	               JOptionPane.YES_NO_OPTION,
	               JOptionPane.QUESTION_MESSAGE);
		
		 if( pregunta == JOptionPane.YES_OPTION){
			 IniciaPrograma();
		 }
		 else {
			 MostrarMensaje("Gracias por usar nuestro servicios de conversión");
		 }
		
	}



}
