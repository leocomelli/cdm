describe("Caixa Eletrônico", function(){
	var cxEletronico = caixaEletronico;

	it("não deve aceitar valores nulos", function(){
		expect(cxEletronico.sacar(null)).toEqual("Valor inválido");
	});

	it("deve aceitar somente números", function(){
		expect(cxEletronico.sacar("x")).toEqual("Valor inválido");
	});

	it("não deve aceitar saques não múltiplos da menor nota disponível", function(){
		expect(cxEletronico.sacar(5)).toEqual("Valor inválido");
	});

	it("deve sacar apenas 1 nota do maior valor", function(){
		var saque = cxEletronico.sacar(100);
		expect(saque[0]).toEqual(1);
	});

	it("deve sacar notas do maior valor", function(){
		var saque = cxEletronico.sacar(300);
		expect(saque[0]).toEqual(3);
	});

	it("deve sacar notas do segundo maior valor", function(){
		var saque = cxEletronico.sacar(50);
		expect(saque[1]).toEqual(1);
	});

	it("deve sacar notas do terceiro maior valor", function(){
		var saque = cxEletronico.sacar(20);
		expect(saque[2]).toEqual(1);
	});

	it("deve sacar notas do menor valor", function(){
		var saque = cxEletronico.sacar(10);
		expect(saque[3]).toEqual(1);
	});

	it("deve sacar uma nota do maior e outra do segundo maior valor", function(){
		var saque = cxEletronico.sacar(150);
		expect(saque[0]).toEqual(1);
		expect(saque[1]).toEqual(1);
	});

	it("deve sacar uma nota do maior, uma segundo maior valor e uma terceiro maior valor", function(){
		var saque = cxEletronico.sacar(170);
		expect(saque[0]).toEqual(1);
		expect(saque[1]).toEqual(1);
		expect(saque[2]).toEqual(1);
	});

	it("deve sacar uma nota de cada valor", function(){
		var saque = cxEletronico.sacar(180);
		expect(saque[0]).toEqual(1);
		expect(saque[1]).toEqual(1);
		expect(saque[2]).toEqual(1);
		expect(saque[3]).toEqual(1);
	});

	it("deve sacar uma nota de cada valor", function(){
		var saque = cxEletronico.sacar(180);
		expect(saque[0]).toEqual(1);
		expect(saque[1]).toEqual(1);
		expect(saque[2]).toEqual(1);
		expect(saque[3]).toEqual(1);
	});	

	it("deve sacar cinco notas do maior valor e uma do menor valor", function(){
		var saque = cxEletronico.sacar(510);
		expect(saque[0]).toEqual(5);
		expect(saque[3]).toEqual(1);
	});


	it("deve sacar cinco notas do maior valor, uma nota do segundo maior valor e duas notas do terceiro maior valor", function(){
		var saque = cxEletronico.sacar(590);
		expect(saque[0]).toEqual(5);
		expect(saque[1]).toEqual(1);
		expect(saque[2]).toEqual(2);
	});	

	it("deve sacar cinco notas do maior valor, uma nota do segundo maior valor e duas notas do terceiro maior valor com comprovante", function(){
		var mensagem = cxEletronico.sacarComComprovante(590);
		console.log(mensagem);
	});

});