// Form Cadastro //

		$(document).ready(function(){
			$('#formCadastro').validate({
				rules:{
					'nome': {
						required:true, rangelength:[3, 50],
						minWords:2
					},
					'email': {
						required:true,
						email: true,
					},
					'password': {
			            required:true,
			            rangelength:[5, 15],
						}
			        },
					messages:{
						'nome':{
							required:"Este campo é obrigatório!",
							rangelength:"Este campo deve ter entre 3 e 50 caracteres!",
							minWords: 2,
					},
					'email':{
						required:"Este campo é obrigatório!",
						email:"Insira o email corretamente!",
					},
					'password':{
						required:"Este campo é obrigatório!",
						rangelength:"Digite pelo menos 5 caracteres!",
						rangelength:"A senha deve conter entre 5 e 15 caracteres!",
						}
					}
				});
			});
		
//-------------------------------------------------------------//

// Login Form //
		
		 $(document).ready(function(){
		      $('#form-login').validate({
		        rules:{ 
		          'email':{
		            required:true,
		            'email':true,
		          },
		          'password':{
		            required:true, 
		            rangelength: [5,15],
		          	}
		          },
		          messages:{
					'email':{
						required: "Este campo é obrigatório!",
						email: "Insira o email corretamente!",
					},
					'password':{
						required:"Este campo é obrigatório",
						rangelength:"A senha deve ter entre 5 e 15 caracteres!",
						}
					},
			});
		});
//-------------------------------------------------------------//

// form recuperar senha //
		 
		 $(document).ready(function(){
		      $('#form-senha').validate({
		        rules:{ 
		          'email':{
		            required:true,
		            'email':true,
		           }
		         },
		          messages:{
					'email':{
						required: "Este campo é obrigatório!",
						email: "Insira o email corretamente!",
					  }
				  },
			});
		});
//------------------------------------------------------------//