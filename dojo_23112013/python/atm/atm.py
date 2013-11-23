#coding:utf-8
from collections import Counter
from valorInvalidoException import ValorInvalidoException

class ATM():
    
    def contarNotas(self, valor):
        """
        Conta as notas que serão devolvidas
        """    
        notas = []
        
        while valor > 0:
            nota = self.obterMaiorNotaPossivel(valor)
            valor -= nota
            notas.append(nota)
        
        return notas
    
    def obterMaiorNotaPossivel(self, valor):
        """
        Obtém a maior nota disponível para o valor desejado
        """    
        
        notasDisponiveis = [100, 50, 20, 10]
        
        for nota in notasDisponiveis:
            
            if nota <= valor:
            
                return nota
    
    def efetuarSaque(self, valor):
        """
        Retorna a mensagem com as notasUtilizadas que deverão ser entregues
        """    
        
        if valor is None or int(valor) % 10 != 0:
            raise ValorInvalidoException ('O valor informado não é possível de ser sacado')
        
        notasContadas = self.contarNotas(valor)
        notasAgrupadas = dict(Counter(notasContadas))
        
        template = "{0} nota(s) de R$ {1:.2f}"
        msgNotas = []
        
        notasUtilizadas = notasAgrupadas.keys()
        notasUtilizadas.sort()
        notasUtilizadas.reverse()
        
        for nota in notasUtilizadas:
            msgNotas.append(template.format(notasAgrupadas.get(nota), nota))
        
        return "Entregar {0}".format(" e ".join(msgNotas).replace(".", ","))
    
