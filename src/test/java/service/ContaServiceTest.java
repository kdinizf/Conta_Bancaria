package service;

import model.Conta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *  Deve ser possível criar uma conta
 *  Novas contas iniciam com o saldo ZERO
 *  Deve ser possível depositar
 *  Caso haja saldo deve ser possível sacar
 *  Caso haja saldo deve ser possível transferir entre contas
 *  Contas com mesmo numero e mesma agencia são iguais
 *
 *  Assert.assertTrue(true);
 *  Assert.assertFalse(false);
 *  Assert.assertEquals(1, 1);
 *  Assert.assertNotEquals(2 , 10);
 *
 *  Assert equals comparando duas contas
 *  Assert.assertSame
 */

public class ContaServiceTest {

    ContaService contaService;

    @Before
    public void setup() {
        contaService = new ContaService();
    }

    @Test
    public void deveSerPossivelCriarUmaConta() {

        // Quando
        Conta conta = contaService.cadastrar("Karina");
        Conta conta2 = contaService.cadastrar("José");

        // Então
        Assert.assertEquals(1, conta.getAgencia());
        Assert.assertEquals(2, conta2.getAgencia());

        Assert.assertEquals(1, conta.getNumero());
        Assert.assertEquals(2, conta2.getNumero());

        Assert.assertEquals("Karina", conta.getNome());
        Assert.assertEquals("José", conta2.getNome());

    }

    @Test
    public void novasContasDevemIniciarComSaldoIgualAZero() {

        // Quando
        Conta conta = contaService.cadastrar("Karina");

        // Então
        Assert.assertFalse(conta.getSaldo() != 0);

    }

    @Test
    public void deveSerPossivelDepositar() {

        // Quando
        Conta conta = contaService.cadastrar("Karina");
        contaService.depositar(conta,  234.46);

        // Então
        Assert.assertEquals(234.46, conta.getSaldo(), 0.01);

    }

    @Test
    public void deveSerPossivelSacarSeTiverSaldo() {

        // Quando
        Conta conta = contaService.cadastrar("Karina");
        contaService.depositar(conta,  345.0);
        contaService.sacar(conta, 47.3);

        // Então
        Assert.assertEquals(297.7, conta.getSaldo(), 0.1);

    }

    @Test
    public void deveSerPossivelTransferirEntreContasCasoHajaSaldo() {

        // Quando
        Conta conta = contaService.cadastrar("Karina");
        Conta conta2 = contaService.cadastrar("José");
        contaService.depositar(conta,  230.0);
        contaService.transferir(conta, conta2, 55.0);

        // Então
        Assert.assertEquals(175.0, conta.getSaldo(), 0.1);
        Assert.assertEquals(55.0, conta2.getSaldo(), 0.1);

    }

    @Test
    public void contasComMesmoNumeroEAgenciaDevemSerIguais() {

        // Quando
        Conta conta = contaService.cadastrar("Karina");
        Conta conta2 = contaService.cadastrar("José");

        Assert.assertNotEquals(conta.getNumero(), conta2.getNumero());
        Assert.assertNotEquals(conta.getAgencia(), conta2.getAgencia());

    }

    @Test
    public void testaAssertSame() {

        Conta conta = contaService.cadastrar("Karina");
        Conta conta2 = conta;

        Assert.assertSame(conta, conta2);

    }

}
