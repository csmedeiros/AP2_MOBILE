package testes;
import calculadora.Calculos;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
class TestesCalculadora {
	
	Calculos testes;
	@Before
	public void setup() {
		testes = new Calculos();
	}
	@Test
	void adultoSobrepesoMax() {
		Assert.assertEquals("Sobrepeso", testes.calculos(1.80, 97.16, 19, "masculino"));
	}
	@Test
	void adultoBaixoPesoMuitoGraveMax() {
		Assert.assertEquals("Baixo peso muito grave", testes.calculos(1.80, 51.84, 19, "masculino"));
	}
	@Test
	void adultoBaixoPesoGraveMax() {
		Assert.assertEquals("Baixo peso grave", testes.calculos(1.80, 55.0476, 19, "masculino"));
	}
	@Test
	void adultoBaixoPesoMax() {
		Assert.assertEquals("Baixo peso", testes.calculos(1.80, 59.9076, 19, "masculino"));
	}
	@Test
	void adultoPesoNormalMax() {
		Assert.assertEquals("Peso normal", testes.calculos(1.80, 80.9676, 19, "masculino"));
	}
	@Test
	void adultoObesidade1Max() {
		Assert.assertEquals("Obesidade grau I", testes.calculos(1.80, 113.3676, 19, "masculino"));
	}
	@Test
	void adultoObesidade2Max() {
		Assert.assertEquals("Obesidade grau II", testes.calculos(1.80, 129.5676, 19, "masculino"));
	}
	@Test
	void idosoBaixoPesoMax() {
		Assert.assertEquals("Baixo peso", testes.calculos(1.80, 70.956, 70, "masculino"));
	}
	@Test
	void idosoPesoNormalMax() {
		Assert.assertEquals("Peso normal", testes.calculos(1.80, 87.48, 70, "masculino"));
	}
	@Test
	void idosoSobrepesoMax() {
		Assert.assertEquals("Sobrepeso", testes.calculos(1.80, 97.2, 70, "masculino"));
	}
	@Test
	void idosoObesidade1Max() {
		Assert.assertEquals("Obesidade grau I", testes.calculos(1.80, 113.4, 70, "masculino"));
	}
	@Test
	void idosoObesidade2Max() {
		Assert.assertEquals("Obesidade grau II", testes.calculos(1.80, 129.5676, 70, "masculino"));
	}
	@Test
	void idosaPesoBaixoMax() {
		Assert.assertEquals("Baixo peso", testes.calculos(1.80, 70.956, 70, "feminino"));
	}
	@Test
	void idosaPesoNormalMax() {
		Assert.assertEquals("Peso normal", testes.calculos(1.80, 87.48, 70, "feminino"));
	}
	@Test
	void idosaSobrepesoMax() {
		Assert.assertEquals("Sobrepeso", testes.calculos(1.80, 103.68, 95, "feminino"));
	}
	@Test
	void idosaObesidade1Max() {
		Assert.assertEquals("Obesidade grau I", testes.calculos(1.80, 119.88, 70, "feminino"));
	}
	@Test
	void idosaObesidade2Max() {
		Assert.assertEquals("Obesidade grau II", testes.calculos(1.80, 135.756, 70, "feminino"));
	}
	@Test
	void adultoSobrepesoMin() {
		Assert.assertEquals("Sobrepeso", testes.calculos(1.80, 81, 19, "masculino"));
	}
	@Test
	void adultoBaixoPesoMuitoGraveMin() {
		Assert.assertEquals("Baixo peso muito grave", testes.calculos(1.80, 0.1, 19, "masculino"));
	}
	@Test
	void adultoBaixoPesoGraveMin() {
		Assert.assertEquals("Baixo peso grave", testes.calculos(1.80, 51.84, 19, "masculino"));
	}
	@Test
	void adultoBaixoPesoMin() {
		Assert.assertEquals("Baixo peso", testes.calculos(1.80, 55.08, 19, "masculino"));
	}
	@Test
	void adultoPesoNormalMin() {
		Assert.assertEquals("Peso normal", testes.calculos(1.80, 59.84, 19, "masculino"));
	}
	@Test
	void adultoObesidade1Min() {
		Assert.assertEquals("Obesidade grau I", testes.calculos(1.80, 97.2, 19, "masculino"));
	}
	@Test
	void adultoObesidade2Min() {
		Assert.assertEquals("Obesidade grau II", testes.calculos(1.80, 113.4, 19, "masculino"));
	}
	@Test
	void adultoObesidade3Min() {
		Assert.assertEquals("Obesidade grau III", testes.calculos(1.80, 129.6, 19, "masculino"));
	}
	@Test
	void idosoBaixoPesoMin() {
		Assert.assertEquals("Baixo peso", testes.calculos(1.80, 0.1, 70, "masculino"));
	}
	@Test
	void idosoPesoNormalMin() {
		Assert.assertEquals("Peso normal", testes.calculos(1.80, 71.28, 70, "masculino"));
	}
	@Test
	void idosoSobrepesoMin() {
		Assert.assertEquals("Sobrepeso", testes.calculos(1.80, 87.804, 70, "masculino"));
	}
	@Test
	void idosoObesidade1Min() {
		Assert.assertEquals("Obesidade grau I", testes.calculos(1.80, 97.524, 70, "masculino"));
	}
	@Test
	void idosoObesidade2Min() {
		Assert.assertEquals("Obesidade grau III", testes.calculos(1.80, 113.724, 70, "masculino"));
	}
	@Test
	void idosaPesoBaixoMin() {
		Assert.assertEquals("Baixo peso", testes.calculos(1.80, 129.6, 70, "feminino"));
	}
	@Test
	void idosaBaixoPesoMin() {
		Assert.assertEquals("Baixo peso", testes.calculos(1.80, 0.1, 70, "feminino"));
	}
	@Test
	void idosaPesoNormalMin() {
		Assert.assertEquals("Peso normal", testes.calculos(1.80, 71.28, 70, "feminino"));
	}
	@Test
	void idosaSobrepesoMin() {
		Assert.assertEquals("Sobrepeso", testes.calculos(1.80, 87.804, 70, "feminino"));
	}
	@Test
	void idosaObesidade1Min() {
		Assert.assertEquals("Obesidade grau I", testes.calculos(1.80, 104.004, 70, "feminino"));
	}
	@Test
	void idosaObesidade2ERROR() {
		Assert.assertEquals("Obesidade grau II", testes.calculos(1.80, 120.204, 70, "feminino"));
	}
	@Test
	void idosaObesidade3Min() {
		Assert.assertEquals("Obesidade grau III", testes.calculos(1.80, 136.08, 70, "feminino"));
	}
}
