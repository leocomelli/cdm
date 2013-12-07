
import Test.HUnit
import Exemplo

testExemplo = TestCase (assertEqual "Descricao do teste" 10 (exemplo 5))

tests = TestList [TestLabel "testExemplo" testExemplo]