import { MaterialLeitura } from "./MaterialLeitura";

class Revista implements MaterialLeitura{
    titulo: string;
    autor: string;
    edicao: number;

    constructor(titulo: string, autor: string, edicao: number){
        this.autor = autor;
        this.titulo = titulo;
        this.edicao = edicao;
    }

    exibirDetalhe(): void {
       console.log(`Autor: ${this.autor}`)
       console.log(`Título: ${this.titulo}`)
       console.log(`Edição: ${this.edicao}`)
    }

}

const revista = new Revista("Avon","Victor",58);
revista.exibirDetalhe();