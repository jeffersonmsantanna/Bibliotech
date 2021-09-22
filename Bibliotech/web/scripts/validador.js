/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function valida (){
    let cpf = frmLogin.cpf.value;
    let dn = frmLogin.dn.value;
    if (cpf === ""){
        alert('Preencha o campo CPF');
        frmLogin.cpf.focus();
        return false;
    } else if (dn === ""){
        alert("Preencha o campo Data de nascimento");
        frmLogin.dn.focus();
        return false;
    } else {
        document.forms["frmLogin"].submit();
    }
    
}




