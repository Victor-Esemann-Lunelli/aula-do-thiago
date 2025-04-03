<h2 align="center">Gerenciamento de Biblioteca Digital</h2>
Você desenvolverá um sistema de gerenciamento de uma biblioteca digital utilizando apenas classes e interfaces simples e introdutórias em TypeScript. Este sistema permitirá que os usuários cadastrem e gerenciem diferentes tipos de materiais de leitura, incluindo livros, revistas e artigos.

O objetivo será criar uma arquitetura básica para o sistema, utilizando conceitos simples de classes e interfaces em TypeScript. Cada classe deve representar um tipo de material de leitura e implementar uma interface que defina os métodos e propriedades necessários para gerenciar esse tipo de material.

**Sua tarefa inclui:**

- Identificar os tipos de materiais de leitura a serem gerenciados.
- Criar uma interface simples para representar a estrutura básica de um material de leitura.
- Desenvolver classes para cada tipo de material, implementando a interface definida.
- Adicionar métodos nas classes para exibir as informações.
- Testar as classes criadas criando instâncias de objetos e invocando os métodos implementados.

**Passo a Passo:**

- Criar uma interface MaterialLeitura para representar a estrutura básica de um material de leitura, contendo propriedades como titulo, autor e métodos como exibirDetalhes.
- Criar três classes (Livro, Revista e Artigo) que implementam a interface MaterialLeitura.
- Utilizar o construtor das classes para inicializar as propriedades dos objetos durante a instanciação.
- Criar instâncias de objetos das classes criadas para exemplificar a utilização das classes e interfaces.


```lua
          +-------------------------+
          |    MaterialLeitura    |
          +-------------------------+
          | - titulo: string        |
          | - autor: string         |
          | - exibirDetalhe():Void  |
          +-------------------------+
                  /_\
                   |
         +------------------------+
         |         Livro          |
         +------------------------+
         | - titulo: string       |
         | - autor: string        |
         | - numeroPagina: number |
         +------------------------+
                  /_\
                   |
         +-------------------+
         |     Revista       |
         +-------------------+
         | - titulo: string  |
         | - autor: string   |
         | - edicao: number  |
         +-------------------+
                  /_\
                   |
         +------------------------+
         |         Artigo         |
         +------------------------+
         | - titulo: string       |
         | - autor: string        |
         | - dataPublicacao: Date |
         +------------------------+

```

Terminou o exercício? Dá uma olhada nessa checklist e confere se tá tudo certinho, combinado?!

- [ ] Fiz o fork do repositório.
- [ ] Clonei o fork na minha máquina (`git clone url-do-meu-fork`).
- [ ] Criei minha branch (` git checkout -b nome-sobrenome `)
- [ ] Criei a pasta com o meu nome dentro da pasta entregas (` mkdir nome-sobrenome`)
- [ ] Adicionei as mudanças. (`git add .` para adicionar todos os arquivos, ou `git add nome_do_arquivo` para adicionar um arquivo específico)
- [ ] Commitei a cada mudança significativa ou na finalização do exercício (`git commit -m "Mensagem do commit"`)
- [ ] Pushei os commits na minha branch (`git push origin nome-da-branch`)
- [ ] Criei um Pull Request seguindo as orientações que estao nesse [documento](instrucoes-pull-request.md).
