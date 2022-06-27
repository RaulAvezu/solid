package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

	private List<ValidacaoReajuste> validacaoReajustes;

	public ReajusteService(List<ValidacaoReajuste> validacaoReajustes) {
		this.validacaoReajustes = validacaoReajustes;
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		this.validacaoReajustes.forEach(v -> v.validar(funcionario, aumento));
		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}

}
