$(document).ready(function(){

$("input").on("focus", function(){
  $(this).css("background-color", "#bfbfbf", "border-color", "#bfbfbf");
});
$("input").blur( function(){
$(this).css("background-color", "#eee");

  if($(this).val() == ""){
        $(this).css("background-color", "#ff8080", "border-color", "#ff8080");
      }else{
        $(this).css("background-color", "#eee","border-color", "#eee");
      }
});

$('input').on("blur", function(){
  if($(this).val() ==""){
  $(".erro").html("favor preencher todos os campos");
}
});


$('input').on("blur",function() {
    var nome = $('#nome').val();
    var email = $('#email').val();
    var sobrenome = $('#sobrenome').val();
    var senha = $('#senha').val();

  if(nome.length < 2 ) {
    $("#nome").css("background-color", "#ff8080", "border-color","#ff8080" );
    $("#erroNOME").html('Nome não pode ter menos que 2 caracteres');     
    }else{        
    $("#erroNOME").hide()
    $("#nome").css("background-color", "#99ff99", "border-color", "#99ff99");
    }

  if(sobrenome.length < 2) {
    $("#sobrenome").css("background-color", "#ff8080","border-color", "#ff8080");
    $("#erroSobrenome").html('sobrenome não pode ter menos que 2 caracteres');     
    }else{
      $("#erroSobrenome").hide();
      $("#sobrenome").css("background-color", "#99ff99","border-color", "#99ff99");
    }

  if(email != "") {
      var filtro = /^.+@.+\..{2,}$/;
      if (filtro.test(email)) {
        $("#erroEmail").hide();  
        $("#email").css("background-color", "#99ff99","border-color", "#99ff99");
      }else {
        $("#email").css("background-color", "#ff8080","border-color", "#ff8080");
        $("#erroEmail").html('O endereço de email fornecido é invalido');
       }
    } else {
      $("#email").css("background-color", "#ff8080","border-color", "#ff8080");
      $("#erroEmail").html('Forneça um endereço de email');
    }

    if(senha.length < 6) {
    $("#senha").css("background-color", "#ff8080","border-color", "#ff8080");
    $("#erroSenha").html('senha deve ter no minino 6 digitos');     
    }else{
    $("#erroSenha").hide();
    $("#senha").css("background-color", "#99ff99","border-color", "#99ff99");
    }
  });
});
//});
/*if (senha =="") {
      $("#password").css("background-color", "#ff8080","border-color", "#ff8080");
      $("#erroEmail").html('senha não pode fica vazia'); 
  }else{
    var filtroPass = /^(?=(?:.*?[A-Z]){3})(?=(?:.*?[0-9]){2})(?=(?:.*?[!@#$%*()_+^&}{:;?.]){1})(?!.*\s)[0-9a-zA-Z!@#$%;*(){}_+^&]*$/;
    if(filtroPass.exec(senha)){
      $("#password").css("background-color", "#99ff99","border-color", "#99ff99");
    }else{
      $("#password").css("background-color", "#ff8080","border-color", "#ff8080");
      $("#erroEmail").html('senha não atende os requisitos, certifique-se de que a senha tenha ao menos um caracter maiusculo, um numero e um caracter especial');
    }*/