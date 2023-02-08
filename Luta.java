package guanabaraPOOLutador;

import java.util.Random;

public class Luta {
	private Lutador desafiado;
	private Lutador desafiante;
	private int rounds;
	private boolean aprovada;

	// Métodos Especiais:
	// Setters and Getters

	public Lutador getDesafiado() {
		return desafiado;
	}

	public void setDesafiado(Lutador desafiado) {
		this.desafiado = desafiado;
	}

	public Lutador getDesafiante() {
		return desafiante;
	}

	public void setDesafiante(Lutador desafiante) {
		this.desafiante = desafiante;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public boolean getAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}

	// Métodos Personalizados
	public void marcarLuta(Lutador l1, Lutador l2) {
		if (l1.getCategoria() == l2.getCategoria() && l1 != l2) {
			this.setAprovada(true);
			this.setDesafiado(l1);
			this.setDesafiante(l2);
		} else {
			this.setAprovada(false);
			this.setDesafiado(null);
			this.setDesafiante(null);
		}
	}

	public void lutar() {
		if (this.getAprovada()) {
			System.out.println("----DESAFIADO----");
			this.desafiado.apresentar();
			System.out.println("----DESAFIANTE----");
			this.desafiante.apresentar();
			Random gerador = new Random();
			int vencedor = gerador.nextInt(3);
			System.out.println("--------RESULTADO DA LUTA--------");
			switch (vencedor) {
			case 0:
				System.out.println("      Empatou!");
				this.getDesafiado().empatarLuta();
				this.getDesafiante().empatarLuta();
				break;
			case 1:
				System.out.println("      Vitória de "+this.getDesafiado().getNome());
				this.getDesafiado().ganharLuta();
				this.getDesafiante().perderLuta();
				break;
			case 2:
				System.out.println("      Vitória de "+this.getDesafiante().getNome());
				this.getDesafiado().perderLuta();
				this.getDesafiante().ganharLuta();
				break;

			}
		}else {
			System.out.println("Luta não pode acontecer!");
		}
		System.out.println("---------------------------------");

	}

}
