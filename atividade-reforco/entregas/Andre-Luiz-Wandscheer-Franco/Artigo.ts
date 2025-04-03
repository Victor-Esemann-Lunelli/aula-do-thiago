import { MaterialLeitura } from "./MaterialLeitura";

class Artigo implements MaterialLeitura{
    titulo: string;
    autor: string;
    dataPublicacao: Date;

    constructor(titulo: string, autor: string, dataPublicacao: Date){
        this.autor =autor
        this.titulo = titulo
        this.dataPublicacao = dataPublicacao
    }

    exibirDetalhe(): void {
       console.log(`Título: ${this.titulo}`)
       console.log(`Autor: ${this.autor}`)
       console.log(`Data de publicação: ${this.dataPublicacao.toDateString()}`)
    }

}

const artigo = new Artigo("Peixario","Victor",new Date("2025-4-03"));
artigo.exibirDetalhe();