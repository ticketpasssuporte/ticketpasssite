// Form Cadastro //

		$(document).ready(function(){
			$('#formCadastro').validate({
				rules:{
					'nome': {
						required:true, 
						maxlength: 20,
	                   	minlength: 3	
					},
					
					'email': {
						required:true,
						minlength: 7,
						email: true
					},
					'senha': {
			            required:true,
			            maxlength: 15,
	                   	minlength: 5
			            
						}
			        },
					messages:{
						'nome':{
							required:"Este campo é obrigatório!",
							rangelength:"Este campo deve ter entre 3 e 20 caracteres!",
							
					},
					'email':{
						required:"Este campo é obrigatório!",
						email:"Insira o email corretamente!"
					},
					'senha':{
						required:"Este campo é obrigatório!",
						rangelength:"Digite pelo menos 5 caracteres!"
					
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
		            email:true
		          },
		          'senha':{
		            required:true, 
		            maxlength: 15,
                   	minlength: 5
		          	}
		          },
		          messages:{
					'email':{
						required: "Este campo é obrigatório!",
						email: "Insira o email corretamente!",
					},
					'senha':{
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
		            email:true
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
//-------------------------------------------------------//
		 
		 $(document).ready(function(){
				$('#formEvento').validate({
					rules:{
						'nomeEvento': {
							required:true, 
							maxlength: 30,
		                   	minlength: 6	
						},
						
						'desc_evento': {
							required:true,
							maxlength: 100,
							minlength: 15
							
						},
						'endereco': {
				            required:true,				            
		                   	minlength: 9
				            
							},
				        
				        'nomeOrganizador': {
				            required:true,				            
		                   	minlength: 4
				            
							},
							'desc_org': {
					            required:true,				            
			                   	minlength: 15
					            
								},
					        
				        },
						messages:{
							'nomeEvento':{
								required:"Este campo é obrigatório!",
								rangelength:"Este campo deve ter entre 6 e 30 caracteres!",
								
						},
						'desc_evento':{
							required:"Este campo é obrigatório!"
						},
						'endereco':{
							required:"Este campo é obrigatório!",
							rangelength:"Digite pelo menos 9 caracteres!"
						
							},
						'nomeOrganizador':{
							required:"Este campo é obrigatório!"
							
						},
						'desc_org':{
							required:"Este campo é obrigatório!"
								
						}
					  }
					});
				});

//------------------------------------------------------------------------------// 
			
		 $(document).ready(function(){
		      $('#formEventoGratis').validate({
		        rules:{ 
		          'nomeEventoGt':{
		            required:true,
		            maxlength: 20,
		            minlength: 6
		           }
		         },
		          messages:{
					'nomeEventoGt':{
						required: "Este campo é obrigatório!"
						
					  }
				  },
			});
		});
//-------------------------------------------------------//
		 $(document).ready(function(){
		      $('#formEventoPago').validate({
		        rules:{ 
		          'nomeEventoPg':{
		            required:true,
		            minlength: 6
		           }
		         },
		          messages:{
					'nomeEventoPg':{
						required: "Este campo é obrigatório!"
						
					  }
				  },
			});
		});
		 
//---------------------------------------------------------------------//
		 
		 
		 