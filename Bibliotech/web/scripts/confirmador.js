/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function confirmar (idexemplar) {
    
    let resposta = confirm('Confirma a exclusão deste livro?');
    if (resposta === true) {
        window.location.href = "delete?idexemplar=" + idexemplar
    }
}
