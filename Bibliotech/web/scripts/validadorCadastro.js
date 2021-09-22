/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validarCadastro (){
    let txtTitulo = frmCadastrar.txtTitulo.value;
    let txtAutor = frmCadastrar.txtAutor.value;
    let txtEditora = frmCadastrar.txtEditora.value;
    let txtAno = frmCadastrar.txtAno.value;
    let txtNumPaginas = frmCadastrar.txtNumPaginas.value;
    let txtDescricao = frmCadastrar.txtDescricao.value;
    
    if (txtTitulo === ""){
        alert('Preencha o campo Título do livro');
        frmCadastrar.txtTitulo.focus();
        return false;
    } else if (txtAutor === ""){
        alert("Preencha o campo Autor");
        frmCadastrar.txtAutor.focus();
        return false;
    } else if (txtEditora === ""){
        alert("Preencha o campo Editora");
        frmCadastrar.txtEditora.focus();
        return false;
    }else if (txtAno === ""){
        alert("Preencha o campo Ano de publicação");
        frmCadastrar.txtAno.focus();
        return false;
    } else if (txtNumPaginas === ""){
        alert("Preencha o campo Número de páginas");
        frmCadastrar.txtNumPaginas.focus();
        return false;
    }else if (txtDescricao === ""){
        alert("Preencha o campo Descrição");
        frmCadastrar.txtDescricao.focus();
        return false;
    }else {
        document.forms["frmCadastrar"].submit();
    }
}