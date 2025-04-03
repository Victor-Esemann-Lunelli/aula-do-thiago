import { MaterialLeitura } from "./MaterialLeitura";

class Livro implements MaterialLeitura{

    titulo: string;
    autor: string;
    numeroPagina: number;

    constructor(titulo: string, autor: string, numeroPagina: number,){
            this.autor = autor
            this.titulo = titulo
            this.numeroPagina = numeroPagina
        }

    exibirDetalhe(): void {
       console.log(`Título: ${this.titulo}`)
       console.log(`Autor: ${this.autor}`)
       console.log(`Número de páginas: ${this.numeroPagina}`)
    }

}

const livro = new Livro("roteiro de Minecraft o filme","victor",3000);
livro.exibirDetalhe(); 