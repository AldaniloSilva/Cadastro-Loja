/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

/**
 *
 * @author Alipio
 */
public enum EnumEstadoCadastro {
    
    PRODUTO (new TelaProduto()),
    FUNCIONARIO (new TelaFuncionario()),
    PEDIDO (new TelaPedido()),
    CLIENTE (new TelaCliente());
    

    private final MaquinaEstadoCadastro classe;

    EnumEstadoCadastro(MaquinaEstadoCadastro classe) {
        this.classe = classe;
    }

    public MaquinaEstadoCadastro getClasse() {
        return this.classe;
    }
}
