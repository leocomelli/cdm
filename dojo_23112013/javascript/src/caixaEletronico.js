var caixaEletronico = {

	notasDisponiveis : [100, 50, 20, 10],

	validaValorSaque : function(valor){
		if(valor % this.notasDisponiveis[this.notasDisponiveis.length - 1] == 0){
			return true;
		}
		return false;
	},

	separarNotas : function(valor){
		var notasSeparadas = [0, 0, 0, 0],
		    valorAtual = valor, 
		    ultimoValor = valor, 
		    indiceNota = 0;
		
		while(true){
			nota = this.notasDisponiveis[indiceNota],
			ultimoValor = valorAtual,
			valorAtual -= nota;

			if(valorAtual > 0){
				notasSeparadas[indiceNota] += 1;
			} else if (valorAtual < 0){
				indiceNota += 1;
				valorAtual = ultimoValor;
			} else {
				notasSeparadas[indiceNota] += 1;
				break;
			} 
		}

		return notasSeparadas;
	},

	sacar : function(valorInformado){
		var valor = parseInt(valorInformado);
		if(isNaN(valor) || !this.validaValorSaque(valor)){
			return "Valor inválido";
		}

		return this.separarNotas(valor);
	},

	sacarComComprovante : function(valorInformado){
		var notasSeparadas = this.sacar(valorInformado);
		return this.criarMensagemComprovante(valorInformado, notasSeparadas);
	},

	criarMensagemComprovante : function(valorInformado, notasSeparadas){
		var mensagem = "Valor do Saque R$ " + valorInformado + " - Resultado Esperado: Entregar ";

		for(var i = 0; i < notasSeparadas.length; i++){
			var notaSeparada = notasSeparadas[i];
			if(notaSeparada > 0){
				mensagem += notaSeparada + " nota(s) de R$ " + this.notasDisponiveis[i] + " ";
			}
		}

		return mensagem;
	}

}