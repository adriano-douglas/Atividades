package Lanchonete;

public class Controle {
	
	private static Integer totalPratos = 0;
	private static Integer totalPizzas = 0;
	private static Integer totalLanches = 0;
	private static Integer totalSalgadinhos = 0;
	private static Integer totalP1 = 0;
	private static Integer totalP2 = 0;
	private static Integer totalP3 = 0;
	private static Integer totalP4 = 0;
	private static Integer totalP5 = 0;
	private static Integer totalPP = 0;
	private static Integer totalL1 = 0;
	private static Integer totalL2 = 0;
	private static Integer totalL3 = 0;
	private static Integer totalS1 = 0;
	private static Integer totalS2 = 0;
	private static Integer totalS3 = 0;
	
	public static void adicionarPrato(String ID, Integer quantidade) {
		totalPratos += quantidade;
		switch(ID.toUpperCase()) {
		case "P1":
			totalP1 += quantidade;
			totalPizzas += quantidade;
			break;
		case "P2":
			totalP2 += quantidade;
			totalPizzas += quantidade;
			break;
		case "P3":
			totalP3 += quantidade;
			totalPizzas += quantidade;
			break;
		case "P4":
			totalP4 += quantidade;
			totalPizzas += quantidade;
			break;
		case "P5":
			totalP5 += quantidade;
			totalPizzas += quantidade;
			break;
		case "P":
			totalPP += quantidade;
			totalPizzas += quantidade;
			break;
		case "L1":
			totalL1 += quantidade;
			totalLanches += quantidade;
			break;
		case "L2":
			totalL2 += quantidade;
			totalLanches += quantidade;
			break;
		case "L3":
			totalL3 += quantidade;
			totalLanches += quantidade;
			break;
		case "S1":
			totalS1 += quantidade;
			totalSalgadinhos += quantidade;
			break;
		case "S2":
			totalS2 += quantidade;
			totalSalgadinhos += quantidade;
			break;
		case "S3":
			totalS3 += quantidade;
			totalSalgadinhos += quantidade;
			break;
		}
	}

	public static Integer getTotalPratos() {
		return totalPratos;
	}

	public static Integer getTotalPizzas() {
		return totalPizzas;
	}

	public static Integer getTotalLanches() {
		return totalLanches;
	}

	public static Integer getTotalSalgadinhos() {
		return totalSalgadinhos;
	}

	public static Integer getTotalP1() {
		return totalP1;
	}

	public static Integer getTotalP2() {
		return totalP2;
	}

	public static Integer getTotalP3() {
		return totalP3;
	}

	public static Integer getTotalP4() {
		return totalP4;
	}

	public static Integer getTotalP5() {
		return totalP5;
	}

	public static Integer getTotalPP() {
		return totalPP;
	}

	public static Integer getTotalL1() {
		return totalL1;
	}

	public static Integer getTotalL2() {
		return totalL2;
	}

	public static Integer getTotalL3() {
		return totalL3;
	}

	public static Integer getTotalS1() {
		return totalS1;
	}

	public static Integer getTotalS2() {
		return totalS2;
	}

	public static Integer getTotalS3() {
		return totalS3;
	}
	
}
