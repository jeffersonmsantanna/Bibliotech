/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validarEmprestimo(){
    let txtNumExemplar = frmEmprestar.txtNumExemplar.value;
    let txtTitulo = frmEmprestar.txtTitulo.value;
    let txtAutor = frmEmprestar.txtAutor.value;
    let txtEditora = frmEmprestar.txtEditora.value;
    let txtAno = frmEmprestar.txtAno.value;
    let txtNumPaginas = frmEmprestar.txtNumPaginas.value;
    let txtDescricao = frmEmprestar.txtDescricao.value;
    let txtSituacao = frmEmprestar.txtSituacao.value;
    let txtCarteirinha = frmEmprestar.txtCarteirinha.value;
    if (txtNumExemplar === ""){
        alert('Preencha o campo Número do exemplar');
        frmEmprestar.txtNumExemplar.focus();
        return false;
    } else if (txtTitulo === ""){
        alert('Preencha o campo Título do livro');
        frmEmprestar.txtTitulo.focus();
        return false;
    } else if (txtAutor === ""){
        alert("Preencha o campo Autor");
        frmEmprestar.txtAutor.focus();
        return false;
    } else if (txtEditora === ""){
        alert("Preencha o campo Editora");
        frmEmprestar.txtEditora.focus();
        return false;
    }else if (txtAno === ""){
        alert("Preencha o campo Ano de publicação");
        frmEmprestar.txtAno.focus();
        return false;
    } else if (txtNumPaginas === ""){
        alert("Preencha o campo Número de páginas");
        frmEmprestar.txtNumPaginas.focus();
        return false;
    }else if (txtDescricao === ""){
        alert("Preencha o campo Descrição");
        frmEmprestar.txtDescricao.focus();
        return false;
    }else if (txtSituacao === "Indisponível"){
        alert("Livro não pode ser emprestado");
        frmEmprestar.txtSituacao.focus();
        return false;
    }else if (txtCarteirinha === ""){
        alert("Preencha o número da carteirinha do estudante");
        frmEmprestar.txtCarteirinha.focus();
        return false;
    }else {
        document.forms["frmEmprestar"].submit();
    }
}