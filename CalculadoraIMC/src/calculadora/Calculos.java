package calculadora;

public class Calculos {
	double imc;
	String resultado;
	public String calculos(double altura , double peso, int idade, String genero) {
		
		imc = peso/(altura*altura);
		if(idade<65 && idade>=18) {
			if(imc<16) {
				resultado = "Baixo peso muito grave";
			}
			else if(imc>=16 && imc<=16.99) {
				resultado = "Baixo peso grave";
			}
			else if(imc>=17 && imc<=18.49) {
				resultado = "Baixo peso";
			}
			else if(imc>=18.50 && imc<=24.99) {
				resultado = "Peso normal";
			}
			else if(imc>=25 && imc<=29.99) {
				resultado = "Sobrepeso";
			}
			else if(imc>=30 && imc<=34.99) {
				resultado = "Obesidade grau I";
			}
			else if(imc>=35 && imc<=39.99) {
				resultado = "Obesidade grau II";
			}
			else if(imc>=40) {
				resultado = "Obesidade grau III";
			}
		}
		if(idade>65) {
			if(genero.equals("masculino")) {
				if(imc<21.9) {
					resultado = "Baixo peso";
				}
				else if(imc>=22 && imc<=27) {
					resultado = "Peso normal";
				}
				else if(imc>=27.1 && imc<=30) {
					resultado = "Sobrepeso";
				}
				else if(imc>=30.1 && imc<=35) {
					resultado = "Obesidade grau I";
				}
				else if(imc>=35.1 && imc<=39.9) {
					resultado = "Obesidade grau II";
				}
				else if(imc>=40) {
					resultado = "Obesidade grau III";
				}
			}
			
			if(genero.equals("feminino"))  {
				if(imc<21.9) {
					resultado = "Baixo peso";
				}
				else if(imc>=22 && imc<=27) {
					resultado = "Peso normal";
				}
				else if(imc>=27.1 && imc<=32) {
					resultado = "Sobrepeso";
				}
				else if(imc>=32.1 && imc<=37) {
					resultado = "Obesidade grau I";
				}
				else if(imc>=37.1 && imc<=41.9) {
					resultado = "Obesidade grau II";
				}
				else if(imc>=42) {
					resultado = "Obesidade grau III";
				}
			}
		}
				return resultado;
	}
}
