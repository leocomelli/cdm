import sys
from atm import ATM

if __name__ == '__main__':
    try:
        valor = sys.argv[1]
        atm = ATM()
        print atm.efetuarSaque(int(valor))
    except:
        import sys
        print sys.exc_info()[1]