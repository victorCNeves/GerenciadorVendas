# GerenciadorVendas

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO), com o objetivo de implementar funcionalidades de um sistema de gerenciamento de vendas utilizando Java e interface com Swing.

## ​ Sobre

Este projeto foi criado como atividade acadêmica para a disciplina de POO, seguindo diretrizes do professor. Por orientação docente, todo o código está organizado em um único pacote padrão, sem divisão em diversos pacotes — embora a organização em pacotes seja recomendada em projetos profissionais, essa estrutura atendeu às instruções recebidas.

##  Funcionalidades

- Cadastro de clientes
- Registro de móveis (como geladeira, mesa, guarda-roupa, etc.)
- Realização de vendas com itens variados
- Geração de relatórios (movéis, clientes, vendas)
- Interface gráfica com formulários para cadastro, consulta, venda e relatórios

##  Estrutura de arquivos / visão geral

- Classes modelo: `Cliente.java`, `Movel.java`, `Venda.java`, `ItemVenda.java`, etc.
- Exceções customizadas: `EstoqueInsuficienteException.java`, `VendaInvalidaException.java`, `ValorNumericoInvalidoException.java`
- Data storage (simples): `BdPessoa.java`, `BdMovel.java`, `BdVenda.java`
- Interface gráfica (forms + lógica): arquivos `.form` e `.java` como `FormCadPessoa`, `FormCadMovel`, `FormCadVenda`, `FormRelPessoa`, etc.
