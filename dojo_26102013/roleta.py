class RoletaRomana(object):

	pessoas = 0
	passo = 0
	inicial = 0

	def __init__(self, pessoas, passo, inicial):

		if pessoas <= 0:
			raise Exception('Erro no numero de pessoas')

		if passo <= 0 or passo > pessoas: 	
			raise Exception('O passo deve estar entre 0 e o numero de pessoas')

		if inicial <= 0 or inicial > pessoas:
			raise Exception('O valor inicial deve estar entre 0 e o numero de pessoas')

		self.pessoas = pessoas
		self.passo = passo
		self.inicial = inicial

	def obterPosicaoIdeal(self):

		posicaoAtual = self.inicial + self.passo

		mortos = []

		while self.pessoas - len(mortos) > 1:			
 			
 			if(posicaoAtual > self.pessoas):
 				posicaoAtual -= self.pessoas

 			mortos.append(posicaoAtual)

 			#if(self.pessoas - len(mortos)  1):
 			posicaoAtual += 1 + self.passo


 		if(posicaoAtual > self.pessoas):
 				posicaoAtual -= self.pessoas
 		#	print mortos
		return posicaoAtual


		




