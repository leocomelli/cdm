
class Saque
	attr_reader :cedulas

	def initialize(cedulas = {})
		@cedulas = cedulas.clone
		@cedulas.default = 0
	end

	def ==(other)
		self.cedulas == other.cedulas
	end

	def add_cedula(cedula)
		@cedulas[cedula]+=1
	end

end

class CaixaEletronico

	def initialize(cedulas = { 100 => 5, 50 => 5, 20 => 5, 10 => 5 })
		@cedulas = cedulas.clone
		@cedulas.default = 0
	end

	def saque(valor)
		saque = Saque.new
		cedulas = [100, 50, 20, 10]
		valor_restante = valor
		for valor_cedula in cedulas
			while ainda_contem_cedula_de(valor_cedula) and valor_restante >= valor_cedula
				saque.add_cedula(valor_cedula)
				@cedulas[valor_cedula]-=1
				valor_restante-=valor_cedula
			end
		end
		if valor_restante > 0
			nil
		else
			saque
		end
	end

	def ainda_contem_cedula_de(valor)
		@cedulas[valor] > 0
	end

end